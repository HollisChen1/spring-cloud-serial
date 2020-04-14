package com.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages= {"com.demo.dao"})
public class Payment8003 {
    public static void main(String[] args) {
        SpringApplication.run(Payment8003.class, args);
    }
}
