package com.muke.service.impl;

import cn.hutool.core.date.DateTime;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSON;
import com.muke.context.LoginMemberContext;
import com.muke.domain.ConfirmOrder;
import com.muke.enums.ConfirmOrderStatusEnum;
import com.muke.enums.RocketMQTopicEnum;
import com.muke.exception.BusinessException;
import com.muke.exception.BusinessExceptionEnum;
import com.muke.mapper.ConfirmOrderMapper;
import com.muke.req.ConfirmOrderDoReq;
import com.muke.service.BeforeConfirmOrderService;
import com.muke.service.SkTokenService;
import com.muke.util.SnowUtil;
import jakarta.annotation.Resource;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

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

    @Resource
    private ConfirmOrderMapper confirmOrderMapper;

    @SentinelResource(value = "beforeDoConfirm", blockHandler = "beforeDoConfirmBlock")
    @Override
    public void beforeDoConfirm(ConfirmOrderDoReq req) {
        req.setMemberId(LoginMemberContext.getId());
        // 校验令牌余量
        boolean validSkToken = skTokenService.validSkToken(req.getDate(), req.getTrainCode(), LoginMemberContext.getId());
        if (validSkToken) {
            LOG.info("令牌校验通过");
        } else {
            LOG.info("令牌校验不通过");
            throw new BusinessException(BusinessExceptionEnum.CONFIRM_ORDER_SK_TOKEN_FAIL);
        }

        DateTime now = DateTime.now();
        Date date = req.getDate();
        String trainCode = req.getTrainCode();
        String start = req.getStart();
        String end = req.getEnd();
        ConfirmOrder confirmOrder = new ConfirmOrder();
        confirmOrder.setId(SnowUtil.getSnowflakeNextId());
        confirmOrder.setMemberId(req.getMemberId());
        confirmOrder.setDate(date);
        confirmOrder.setTrainCode(trainCode);
        confirmOrder.setStart(start);
        confirmOrder.setEnd(end);
        confirmOrder.setDailyTrainTicketId(req.getDailyTrainTicketId());
        confirmOrder.setStatus(ConfirmOrderStatusEnum.INIT.getCode());
        confirmOrder.setCreateTime(now);
        confirmOrder.setUpdateTime(now);
        confirmOrder.setTickets(JSON.toJSONString(req.getTickets()));
        confirmOrderMapper.insert(confirmOrder);

        // 发送MQ排队购票
        req.setLogId(MDC.get("LOG_ID"));
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
