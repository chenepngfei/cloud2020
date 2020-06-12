package com.afei.springcloud.service.fallback;

import com.afei.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String getPaymentInfo_OK(Integer id) {
        return "-----PaymentFallbackService fall back-getPaymentInfo_OK,o(╥﹏╥)o";
    }

    @Override
    public String getPaymentInfo_TimeOut(Integer id) {
        return "-----PaymentFallbackService fall back-getPaymentInfo_TimeOut,o(╥﹏╥)o";
    }
}
