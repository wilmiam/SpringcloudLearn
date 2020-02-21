package com.wilmiam.cloud.hi_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//@EnableEurekaClient // 针对eureka客户端的注解，一般会使用新的@EnableDiscoveryClient来替代
@EnableDiscoveryClient
@SpringBootApplication
public class HiServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HiServiceApplication.class, args);
    }

}
