package com.muke.mq;

import com.alibaba.fastjson.JSON;
import com.muke.req.ConfirmOrderDoReq;
import com.muke.service.ConfirmOrderService;
import jakarta.annotation.Resource;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Service;

/**
 * MQ消费
 *
 * @author tangcj
 * @date 2024/01/27 12:28
 **/
@Service
@RocketMQMessageListener(consumerGroup = "default", topic = "CONFIRM_ORDER")
public class ConfirmOrderConsumer implements RocketMQListener<MessageExt> {

    private static final Logger LOG = LoggerFactory.getLogger(ConfirmOrderConsumer.class);

    @Resource
    private ConfirmOrderService confirmOrderService;

    @Override
    public void onMessage(MessageExt messageExt) {
        byte[] body = messageExt.getBody();
        ConfirmOrderDoReq req = JSON.parseObject(new String(body), ConfirmOrderDoReq.class);
        MDC.put("LOG_ID", req.getLogId());
        LOG.info("ROCKETMQ收到消息：{}", new String(body));
        confirmOrderService.doConfirm(req);
    }
}