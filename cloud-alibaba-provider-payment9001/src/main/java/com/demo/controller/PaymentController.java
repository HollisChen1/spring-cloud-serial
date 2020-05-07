package com.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * </p>
 *
 * @description:
 * @author: chenhao
 * @date: 2020/5/6 22:20
 */
@RestController
@RefreshScope
public class PaymentController {
    @Value("${server.port}")
    private Integer serverPort;

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/echo/{name}")
    public String echo(@PathVariable String name){
        return "["+ serverPort +"] Hello, " + name;
    }

    @GetMapping("/config-info")
    public String getConfigInfo(){
        return this.configInfo;
    }
}
