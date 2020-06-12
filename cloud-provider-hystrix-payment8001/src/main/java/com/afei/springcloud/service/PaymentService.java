package com.afei.springcloud.service;


import org.springframework.web.bind.annotation.PathVariable;

public interface PaymentService {

    String getPaymentInfo_OK(Integer id);

    String getPaymentInfo_TimeOut(Integer id);

    String getPaymentInfo_Error(Integer id);
    public  String paymentCircuitBreaker(@PathVariable("id") Integer id);
}