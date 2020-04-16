package com.demo.controller;

import com.demo.base.ApiResult;
import com.demo.domain.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @description:
 * @author: chenhao
 * @date: 2020/4/16
 */
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {
    public static  final String INVOKE_URL = "http://cloud-payment-service";

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("")
    public ApiResult create(@RequestParam String orderNo){
        Payment payment = new Payment();
        payment.setOrderNo(orderNo);
        return restTemplate.postForEntity(INVOKE_URL + "/payment/", payment, ApiResult.class).getBody();
    }
}
