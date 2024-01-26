package com.muke.feign;

import com.muke.resp.CommonResp;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 降级策略
 *
 * @author tangcj
 * @date 2024/01/25 17:25
 **/
@Component
public class BusinessFeignFallback implements BusinessFeign {

    @Override
    public String hello() {
        return "Fallback";
    }

    @Override
    public CommonResp<Object> genDaily(Date date) {
        return null;
    }
}