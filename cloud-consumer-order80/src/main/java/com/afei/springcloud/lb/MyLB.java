package com.afei.springcloud.lb;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyLB implements LoadBalaner {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getIncrement() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= 2147483647 ? 0 : current+1;

        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("------------第几次访问：次数next"+next);
        return next;
    }
    //负载均衡算法：rest接口第几次请求数 % 服务器集群总数量 = 实际调用服务器位置下标 ，每次服务重启后rest接口计数从1开始

    @Override
    public ServiceInstance instance(List<ServiceInstance> instances) {
        int index = getIncrement() % instances.size();
        return instances.get(index);
    }
}
