package com.wilmiam.cloud.feign.client;

import org.springframework.stereotype.Service;

@Service
public class HiClientImpl implements HiClient {

    @Override
    public String sayHiFromClientOne(String name) {
        return String.format("sorry %s", name);
    }

}
