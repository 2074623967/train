package com.muke.job;

/**
 * 框架自带job
 *
 * @author tangcj
 * @date 2024/01/18 11:00
 * 适合单体应用，不适合集群
 * 没法实时更改定时任务状态和策略
 **/
// @Component
// @EnableScheduling
// public class SpringBootTestJob {
//
//     @Scheduled(cron = "0/5 * * * * ?")
//     private void test() {
//         // 增加分布式锁，解决集群问题
//         System.out.println("SpringBootTestJob TEST");
//     }
// }
