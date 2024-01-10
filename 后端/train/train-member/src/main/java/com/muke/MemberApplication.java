package com.muke;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 会员模块
 *
 * @author tangcj
 * @date 2024/01/10 17:08
 **/

@SpringBootApplication(scanBasePackages = {"com.muke"})
public class MemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemberApplication.class, args);
    }
}
