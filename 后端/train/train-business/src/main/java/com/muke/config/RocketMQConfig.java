package com.muke.config;

/**
 * MQ配置
 *
 * @author tangcj
 * @date 2024/01/27 12:11
 **/
//@Component
//public class RocketMQConfig {
//
//    /**
//     * 新版本需要声明RocketMQTemplate，否则会注入失败
//     * @return
//     */
//    @Bean
//    public RocketMQTemplate rocketMQTemplate() {
//        RocketMQTemplate rocketMQTemplate = new RocketMQTemplate();
//        DefaultMQProducer producer = new DefaultMQProducer();
//        producer.setProducerGroup("default");
//        producer.setNamesrvAddr("http://localhost:9876");
//        producer.setSendMsgTimeout(3000);
//        rocketMQTemplate.setProducer(producer);
//        return rocketMQTemplate;
//    }
//}
