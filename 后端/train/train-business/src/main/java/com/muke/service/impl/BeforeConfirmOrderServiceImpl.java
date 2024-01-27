package com.muke.service.impl;

import cn.hutool.core.date.DateUtil;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSON;
import com.muke.context.LoginMemberContext;
import com.muke.enums.RedisKeyPreEnum;
import com.muke.enums.RocketMQTopicEnum;
import com.muke.exception.BusinessException;
import com.muke.exception.BusinessExceptionEnum;
import com.muke.req.ConfirmOrderDoReq;
import com.muke.service.BeforeConfirmOrderService;
import com.muke.service.SkTokenService;
import jakarta.annotation.Resource;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * 选座之前的处理
 *
 * @author tangcj
 * @date 2024/01/27 11:23
 **/
@Service
public class BeforeConfirmOrderServiceImpl implements BeforeConfirmOrderService {

    private static final Logger LOG = LoggerFactory.getLogger(BeforeConfirmOrderServiceImpl.class);

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private SkTokenService skTokenService;

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @SentinelResource(value = "beforeDoConfirm", blockHandler = "beforeDoConfirmBlock")
    @Override
    public void beforeDoConfirm(ConfirmOrderDoReq req) {
        // 校验令牌余量
        boolean validSkToken = skTokenService.validSkToken(req.getDate(), req.getTrainCode(), LoginMemberContext.getId());
        if (validSkToken) {
            LOG.info("令牌校验通过");
        } else {
            LOG.info("令牌校验不通过");
            throw new BusinessException(BusinessExceptionEnum.CONFIRM_ORDER_SK_TOKEN_FAIL);
        }

        String lockKey = RedisKeyPreEnum.CONFIRM_ORDER + "-" + DateUtil.formatDate(req.getDate()) + "-" + req.getTrainCode();
        // 保存确认订单表，状态初始
        Boolean setIfAbsent = stringRedisTemplate.opsForValue().setIfAbsent(lockKey, lockKey, 5, TimeUnit.SECONDS);
        if (Boolean.TRUE.equals(setIfAbsent)) {
            LOG.info("恭喜，抢到锁了！");
        } else {
            // 只是没抢到锁，并不知道票抢完了没，所以提示稍候再试
            LOG.info("很遗憾，没抢到锁！");
            throw new BusinessException(BusinessExceptionEnum.CONFIRM_ORDER_LOCK_FAIL);
        }

        // 发送MQ排队购票
        String reqJson = JSON.toJSONString(req);
        LOG.info("排队购票，发送mq开始，消息：{}", reqJson);
        rocketMQTemplate.convertAndSend(RocketMQTopicEnum.CONFIRM_ORDER.getCode(), reqJson);
        LOG.info("排队购票，发送mq结束");
    }

    /**
     * 降级方法，需包含限流方法的所有参数和BlockException参数
     *
     * @param req
     * @param e
     */
    public void beforeDoConfirmBlock(ConfirmOrderDoReq req, BlockException e) {
        LOG.info("购票请求被限流：{}", req);
        throw new BusinessException(BusinessExceptionEnum.CONFIRM_ORDER_FLOW_EXCEPTION);
    }
}
