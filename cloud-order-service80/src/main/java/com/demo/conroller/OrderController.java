package com.demo.conroller;

import com.demo.base.ApiResult;
import com.demo.domain.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/create")
    public ApiResult create(@RequestParam("orderNo") String orderNo) {
        log.info("订单中心收到下单请求：orderNo = {}",orderNo);
        Payment param = new Payment();
        param.setOrderNo(orderNo);
        return restTemplate.postForEntity(PAYMENT_URL + "/payment", param, ApiResult.class).getBody();
    }
}
