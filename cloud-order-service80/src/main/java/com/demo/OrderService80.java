package com.demo;

import com.myrule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@RibbonClient(name = "cloud-payment-service", configuration = MyRule.class)
@EnableDiscoveryClient
public class OrderService80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderService80.class, args);
    }
}
