package com.afei.springcloud.conttroller;

import com.afei.springcloud.entities.CommonResult;
import com.afei.springcloud.entities.PaymentEntity;
import com.afei.springcloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("order")
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("selectOne/{id}")
    public CommonResult<PaymentEntity> selectOne(@PathVariable("id") Long id){
        return paymentFeignService.selectOne(id);
    }

    @GetMapping("/feign/timeout")
    public String getFeignTimeOut() {
        return paymentFeignService.getFeignTimeOut();
    }
}