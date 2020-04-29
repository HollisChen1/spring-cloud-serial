package com.demo.service;

import com.demo.dao.PaymentMapper;
import com.demo.domain.Payment;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.Setter;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    private PaymentMapper paymentMapper;

    public void setPaymentMapper(@Autowired PaymentMapper paymentMapper) {
        this.paymentMapper = paymentMapper;
    }

    public Integer create(Payment payment) {
        return paymentMapper.create(payment);
    }

    public Payment get(Integer id) {
        return paymentMapper.get(id);
    }


    public String paymentInfo_OK(Integer id) {
        return "thread: " + Thread.currentThread().getName() + "ok  id = " + id;
    }

    @SneakyThrows
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",
    commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    })
    public String paymentInfo_TimeOut(Integer id) {
        System.out.println("进入");
        Thread.sleep(3000L);
        return "thread: " + Thread.currentThread().getName() + "timeout id = " + id;
    }

    public String paymentInfo_TimeOutHandler(Integer id) {
        return "提供者降级成功";
    }

}