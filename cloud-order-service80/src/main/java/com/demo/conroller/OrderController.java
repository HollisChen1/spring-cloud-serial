package com.demo.conroller;

import com.demo.base.ApiResult;
import com.demo.domain.Payment;
import com.demo.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancer loadBalancer;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/create")
    public ApiResult create(@RequestParam("orderNo") String orderNo) {
        log.info("订单中心收到下单请求：orderNo = {}", orderNo);
        Payment param = new Payment();
        param.setOrderNo(orderNo);
        return restTemplate.postForEntity(PAYMENT_URL + "/payment", param, ApiResult.class).getBody();
    }

    @GetMapping("/consumer/payment/lb")
    public ApiResult<Integer    > getPaymentLb() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        ServiceInstance instance = loadBalancer.instance(instances);
        URI uri = instance.getUri();
        return restTemplate.getForObject(uri + "/payment/port", ApiResult.class);
    }
}
