package com.afei.springcloud.service;

import com.afei.springcloud.service.fallback.PaymentFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "cloud-provider-hystrix-payment",fallback = PaymentFallbackService.class)
public interface PaymentHystrixService{
        @GetMapping("/payment/hystrix/ok/{id}")
        public String getPaymentInfo_OK(@PathVariable("id") Integer id);


        @GetMapping("/payment/hystrix/timeout/{id}")
        public String getPaymentInfo_TimeOut(@PathVariable("id") Integer id);



}
