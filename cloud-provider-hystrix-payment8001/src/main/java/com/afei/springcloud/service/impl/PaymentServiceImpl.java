package com.afei.springcloud.service.impl;


import cn.hutool.core.util.IdUtil;
import com.afei.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentServiceImpl implements PaymentService {


    ///服务降级
    @Override
    public String getPaymentInfo_OK(Integer id) {
        return "线程池："+ Thread.currentThread().getName()+"----paymentinfo_OK，id"+id + "\t" + "haha" ;
    }

    @Override
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")//超时时间3秒
    })
    public  String getPaymentInfo_TimeOut(Integer id){
       int timeNumber = 2;
       try{ TimeUnit.SECONDS.sleep(timeNumber);}catch (Exception e){e.printStackTrace();}
        //int  i = timeNumber/0;

        return "线程池："+ Thread.currentThread().getName()+"----paymentinfo_OK，id"+id + "\t" + "haha_" + "耗时：" +timeNumber ;
    }

//    服务熔断

    @Override
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"), //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"), //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), //时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),//失败率达到多少后跳闸
    })
    public  String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if(id < 0){
            throw  new RuntimeException("*****id 不能负数");
        }
        String seriaNumber= IdUtil.simpleUUID();
        return "线程池："+ Thread.currentThread().getName()+"调用成功，流水号：" +seriaNumber ;
    }

    public  String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){

        return "id不能负数，请稍后再试，o(╥﹏╥)o~~~id：" + id ;
    }








    //@HystrixCommand:启用hystrix
    @HystrixCommand(fallbackMethod = "getPaymentInfo_ErrorHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String getPaymentInfo_Error(Integer id) {
//        return Thread.currentThread().getName()+"----ERROR----"+id;
        System.out.println(Thread.currentThread().getName()+"-----------error----------"+id);
        Integer timeout = 5;
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Thread.currentThread().getName()+"-----getPaymentInfo_Error----ERROR----"+id;
    }


    public String getPaymentInfo_ErrorHandler(Integer id) {
        return Thread.currentThread().getName()+"-----------getPaymentInfo_ErrorHandler----ERROR----"+id;
    }



}