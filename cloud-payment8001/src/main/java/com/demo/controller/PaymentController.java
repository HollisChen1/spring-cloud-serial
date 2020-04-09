package com.demo.controller;

import com.demo.base.ApiResult;
import com.demo.domain.Payment;
import com.demo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/{id}")
    public ApiResult<Payment> get(@PathVariable() Integer id){
        return ApiResult.success(paymentService.get(id));
    }

    @PostMapping("")
    public ApiResult<Integer> create(@RequestBody Payment payment){
        paymentService.create(payment);
        return ApiResult.success(payment.getId());
    }

}
