package com.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 * 不能放到componentScan扫描的包路径下
 * </p>
 *
 * @description:
 * @author: chenhao
 * @date: 2020/4/20 21:31
 */
@Configuration
public class MyRule {
    @Bean
    public IRule myRule(){
        return new RandomRule();
    }
}
