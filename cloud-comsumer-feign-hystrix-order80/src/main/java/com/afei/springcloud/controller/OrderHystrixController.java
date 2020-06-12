package com.afei.springcloud.controller;

import com.afei.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/")
@Slf4j
//@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String getPaymentInfo_OK(@PathVariable("id") Integer id){
        String res = paymentHystrixService.getPaymentInfo_OK(id);
        log.info("****result:",res);
        return res;
    }

//    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
////    public String getPaymentInfo_TimeOut(@PathVariable("id") Integer id){
////        String res = paymentHystrixService.getPaymentInfo_TimeOut(id);
////        log.info("****result:",res);
////        return res;
////    }
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500"), //超时时间3秒
//    //            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"), //是否开启断路器
//    //            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"), //请求次数
//    //            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), //时间窗口期
//    //            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),//失败率达到多少后跳闸
//    })
    @HystrixCommand
    public  String getPaymentInfo_TimeOut(Integer id){
        String res = paymentHystrixService.getPaymentInfo_TimeOut(id);

        return res;
    }

    public  String paymentInfo_TimeOutHandler(Integer id){

        return "我是消费者80，对方支付系统繁忙请10秒钟后再试或者自己运行出错检查自己，kukukukuku" ;
    }

    //下面试全局fallback
    public String payment_Global_FallbackMethod(){
        return "Global异常处理信息，请稍后再试，o(╥﹏╥)o";
    }



}

