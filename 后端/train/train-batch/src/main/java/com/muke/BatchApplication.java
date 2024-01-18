package com.muke;


import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * 定时调度模块
 *
 * @author tangcj
 * @date 2024/01/18 10:20
 **/
@SpringBootApplication(scanBasePackages = {"com.muke"})
@MapperScan(basePackages = {"com.muke.mapper"})
@EnableFeignClients("com.muke.feign")
public class BatchApplication {

    private static final Logger LOG = LoggerFactory.getLogger(BatchApplication.class);

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(BatchApplication.class);
        ConfigurableEnvironment env = app.run(args).getEnvironment();
        LOG.info("启动成功!");
        LOG.info("地址: \thttp://127.0.0.1:{}{}", env.getProperty("server.port"),
                env.getProperty("server.servlet.context-path"));
    }
}
