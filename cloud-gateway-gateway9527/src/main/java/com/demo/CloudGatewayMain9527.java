package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <p>
 *
 * </p>
 *
 * @description:
 * @author: chenhao
 * @date: 2020/4/29 21:41
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class CloudGatewayMain9527 {

    public static void main(String[] args) {
        SpringApplication.run(CloudGatewayMain9527.class, args);
    }
}
