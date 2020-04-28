package com.demo.configuration;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 *
 * </p>
 *
 * @description:
 * @author: chenhao
 * @date: 2020/4/26 20:43
 */
@Configuration
public class FeignConfig {

    @Bean
    Logger.Level feignLogLevel(){
        //feign详细日志
        return Logger.Level.FULL;
    }
}
