package com.demo.controller;

import com.demo.base.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @description:
 * @author: chenhao
 * @date: 2020/4/16
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("")
    public ApiResult<String> index(){
        discoveryClient.getServices().stream().forEach(log::info);
        return ApiResult.success(UUID.randomUUID().toString());
    }

}
