package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @description:
 * @author:chenhao
 * @date:2020-04-16 20:31:14
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderServiceZkMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderServiceZkMain80.class, args);
    }
}
