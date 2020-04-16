package com.demo.controller;

import com.demo.base.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * <p>
 *
 * </p>
 *
 * @description:
 * @author: chenhao
 * @date: 2020/4/16 21:29
 */
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    public static final String INVOKE_URL = "http://cloud-payment-service";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("")
    public ApiResult<String> index(){
        return restTemplate.getForEntity(INVOKE_URL + "/payment", ApiResult.class).getBody();
    }
}
