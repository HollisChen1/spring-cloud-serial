package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <p>
 *
 * </p>
 *
 * @description:
 * @author: chenhao
 * @date: 2020/5/7 20:28
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosOrder83Main {

    public static void main(String[] args) {
        SpringApplication.run(NacosOrder83Main.class, args);
    }
}
