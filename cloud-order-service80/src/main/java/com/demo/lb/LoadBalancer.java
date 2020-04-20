package com.demo.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @description:
 * @author: chenhao
 * @date: 2020/4/20 22:01
 */
public interface LoadBalancer {

    ServiceInstance instance(List<ServiceInstance> serviceInstanceList);
}
