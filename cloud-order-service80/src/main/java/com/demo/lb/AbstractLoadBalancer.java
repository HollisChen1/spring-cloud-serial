package com.demo.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @description:
 * @author: chenhao
 * @date: 2020/4/20 22:08
 */
public abstract class AbstractLoadBalancer implements LoadBalancer {
    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstanceList) {
        if(CollectionUtils.isEmpty(serviceInstanceList)){
            return null;
        }
        if(serviceInstanceList.size() == 1){
            return serviceInstanceList.get(0);
        }

        return doSelect(serviceInstanceList);
    }

    protected abstract ServiceInstance doSelect(List<ServiceInstance> serviceInstanceList);
}
