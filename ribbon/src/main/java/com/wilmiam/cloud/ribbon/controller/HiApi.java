package com.wilmiam.cloud.ribbon.controller;

import com.wilmiam.cloud.ribbon.service.HIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiApi {

    @Autowired
    private HIService hiService;

    @Value("${foo}")
    private String foo;

    @GetMapping("/hi")
    public String hi(@RequestParam String name) {
         return hiService.hiService(foo + " " + name);
    }

}
