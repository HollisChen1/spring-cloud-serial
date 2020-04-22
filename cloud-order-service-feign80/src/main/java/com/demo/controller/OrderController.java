package com.demo.controller;

import com.demo.base.ApiResult;
import com.demo.domain.Payment;
import com.demo.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * </p>
 *
 * @description:
 * @author: chenhao
 * @date: 2020/4/22 20:30
 */
@RestController
@Slf4j
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @PostMapping("/create")
    public ApiResult create(@RequestParam("orderNo") String orderNo) {
        log.info("订单中心收到下单请求：orderNo = {}", orderNo);
        Payment param = new Payment();
        param.setOrderNo(orderNo);
        return paymentFeignService.create(param);
    }

}
