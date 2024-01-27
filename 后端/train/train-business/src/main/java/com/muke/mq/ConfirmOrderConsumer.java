package com.muke.mq;

import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

     @Override
     public void onMessage(MessageExt messageExt) {
         byte[] body = messageExt.getBody();
         LOG.info("ROCKETMQ收到消息：{}", new String(body));
     }
 }