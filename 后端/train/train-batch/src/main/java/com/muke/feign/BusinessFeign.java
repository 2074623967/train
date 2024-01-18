package com.muke.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name = "business", url = "http://127.0.0.1:8003/business")
public interface BusinessFeign {

    @GetMapping("/business/hello")
    String hello();
}
