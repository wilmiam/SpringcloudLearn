package com.wilmiam.cloud.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * fallback参数：发生错误是调用该实现类
 */
@FeignClient(value = "hi-service", fallback = HiClientImpl.class)
public interface HiClient {

    @GetMapping("/hi")
    String sayHiFromClientOne(@RequestParam(value = "name") String name);

}
