package com.wilmiam.cloud.hi_service.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiApi {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/hi")
    public String hi(@RequestParam(value = "name", defaultValue = "wilmiam") String name) {
        return "hi," + name + ",i am from port:" + port;
    }

}
