package com.demo.controller;

import com.demo.base.ApiResult;
import com.demo.domain.Payment;
import com.demo.service.PaymentFeignService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@DefaultProperties(defaultFallback = "")
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

    @GetMapping("/consumer/timeout")
//    @HystrixCommand(fallbackMethod = "timeoutFallback" ,
//    commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "4000")
//    })
    public ApiResult<String> timeout(@RequestParam() Integer id){
        return paymentFeignService.timeout(id);
    }


    public ApiResult<String> timeoutFallback(Integer id){
        return ApiResult.success("客户端降级处理");
    }

    public ApiResult defaultFallback(){
        return ApiResult.success("全局降级方法");
    }
}
