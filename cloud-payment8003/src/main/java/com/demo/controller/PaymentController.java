package com.demo.controller;

import com.demo.base.ApiResult;
import com.demo.domain.Payment;
import com.demo.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private Integer serverPort;

    @GetMapping("/{id}")
    public ApiResult<Payment> get(@PathVariable() Integer id){
        return ApiResult.success(paymentService.get(id));
    }

    @PostMapping("")
    public ApiResult<Integer> create(@RequestBody Payment payment){
        log.info("当前服务端口：{}", serverPort);
        paymentService.create(payment);
        return ApiResult.success(payment.getId());
    }

    @GetMapping("/port")
    public ApiResult<Integer> create(){
        return ApiResult.success(serverPort);
    }

}
