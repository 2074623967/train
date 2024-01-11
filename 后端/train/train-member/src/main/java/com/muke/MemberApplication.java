package com.muke;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * 会员模块
 *
 * @author tangcj
 * @date 2024/01/10 17:08
 **/

@SpringBootApplication(scanBasePackages = {"com.muke"})
@MapperScan(basePackages = {"com.muke.mapper"})
public class MemberApplication {

    private static final Logger LOG = LoggerFactory.getLogger(MemberApplication.class);

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(MemberApplication.class);
        ConfigurableEnvironment env = app.run(args).getEnvironment();
        LOG.info("启动成功!");
        LOG.info("地址: \thttp://127.0.0.1:{}{}", env.getProperty("server.port"),
                env.getProperty("server.servlet.context-path"));
    }
}
