package com.wilmiam.cloud.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HIService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError") // 使用熔断的注解
    public String hiService(String name) {
        return restTemplate.getForObject("http://hi-service/hi?name=" + name, String.class);
    }

    /**
     * 熔断执行的方法
     * @param name
     * @return
     */
    public String hiError(String name) {
        return "hi " + name + ",sorry,error";
    }
}
