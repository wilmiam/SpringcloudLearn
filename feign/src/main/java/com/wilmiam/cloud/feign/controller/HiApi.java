package com.wilmiam.cloud.feign.controller;

import com.wilmiam.cloud.feign.client.HiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiApi {

    @Autowired
    private HiClient hiClient;

    @Value("${foo}")
    private String foo;

    @GetMapping("hi")
    public String sayHi(@RequestParam("name") String name) {
        return hiClient.sayHiFromClientOne(foo + " " + name);
    }

}
