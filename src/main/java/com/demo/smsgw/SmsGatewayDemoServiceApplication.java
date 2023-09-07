package com.demo.smsgw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableFeignClients
@SpringBootApplication
public class SmsGatewayDemoServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmsGatewayDemoServiceApplication.class, args);
    }

}
