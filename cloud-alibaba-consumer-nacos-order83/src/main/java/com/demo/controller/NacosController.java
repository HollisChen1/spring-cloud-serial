package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * <p>
 *
 * </p>
 *
 * @description:
 * @author: chenhao
 * @date: 2020/5/7 20:29
 */
@RestController
public class NacosController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${serviceUrl.paymentProvider}")
    private String serviceUrl;

    @GetMapping("/echo/{name}")
    public String echo(@PathVariable String name) {
        return restTemplate.getForObject(serviceUrl + "/echo/" + name, String.class);
    }
}
