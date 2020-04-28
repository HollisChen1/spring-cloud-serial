package com.demo.service;

import com.demo.base.ApiResult;
import com.demo.configuration.FeignConfig;
import com.demo.domain.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 *
 * </p>
 *
 * @description:
 * @author: chenhao
 * @date: 2020/4/22 20:26
 */
@FeignClient(value = "CLOUD-PAYMENT-SERVICE",configuration = FeignConfig.class, fallback = PaymentFeignFallbackService.class)
@Component
public interface PaymentFeignService {

    @PostMapping("/payment")
    ApiResult<Integer> create(@RequestBody Payment payment);

    /**
     * 测试超时
     * @return
     */
    @GetMapping("/payment/timeout")
    ApiResult<String> timeout(@RequestParam("id") Integer id);

}
