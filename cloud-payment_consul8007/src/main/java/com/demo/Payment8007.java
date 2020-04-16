package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @description:
 * @author: chenhao
 * @date: 2020/4/16
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Payment8007 {
    public static void main(String[] args) {
        SpringApplication.run(Payment8007.class, args);
    }
}
