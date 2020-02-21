package com.wilmiam.cloud.gateway;

import com.wilmiam.cloud.gateway.filter.RequestTimeGatewayFilterFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Bean
    public RequestTimeGatewayFilterFactory jwtCheckGatewayFilterFactory() {
        return new RequestTimeGatewayFilterFactory();
    }
}
