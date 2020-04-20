package com.demo.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 *
 * </p>
 *
 * @description:
 * @author: chenhao
 * @date: 2020/4/20 22:04
 */
@Component
public class MyLoadBalancer extends AbstractLoadBalancer {
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current++;
        } while (!atomicInteger.compareAndSet(next, current));
        return next;
    }

    @Override
    protected ServiceInstance doSelect(List<ServiceInstance> serviceInstanceList) {
        int next = this.getAndIncrement();
        int serverCount = serviceInstanceList.size();
        int serverIndex = next % serverCount;
        return serviceInstanceList.get(serverIndex);
    }
}
