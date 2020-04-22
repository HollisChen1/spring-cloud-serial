package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * <p>
 *
 * </p>
 *
 * @description:
 * @author: chenhao
 * @date: 2020/4/22 20:25
 */
@SpringBootApplication
@EnableFeignClients
public class OrderServiceFeign {
    public static void main(String[] args) {
        SpringApplication.run(OrderServiceFeign.class, args);
    }
}
