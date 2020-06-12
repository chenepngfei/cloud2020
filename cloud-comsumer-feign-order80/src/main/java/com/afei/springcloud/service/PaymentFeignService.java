package com.afei.springcloud.service;

import com.afei.springcloud.entities.CommonResult;
import com.afei.springcloud.entities.PaymentEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/sys/payment/selectOne/{id}")
    CommonResult<PaymentEntity> selectOne(@PathVariable("id") Long id);

    @GetMapping("/sys/payment/feign/timeout")
    String getFeignTimeOut();
}