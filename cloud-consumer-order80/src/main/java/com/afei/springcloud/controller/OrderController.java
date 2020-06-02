package com.afei.springcloud.controller;

import com.afei.springcloud.entities.CommonResult;
import com.afei.springcloud.entities.PaymentEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("comsumer")
@Slf4j
public class OrderController {

    private static final String PAYENT_URL = "http://localhost:8001";
    @Resource
    private RestTemplate restTemplate;
//    @Resource
//    private LoadBalaner loadBalaner;
//    @Resource
//    private DiscoveryClient discoveryClient;
    @GetMapping("payment/create")
    public CommonResult<PaymentEntity> create(PaymentEntity payment) {
        //payment.setSerial("test");
        return restTemplate.postForObject(PAYENT_URL+"/sys/payment/save",payment,CommonResult.class);
    }
    @GetMapping("payment/selectOne/{id}")
    public CommonResult<PaymentEntity> getPayment(@PathVariable("id") long id) {
        CommonResult forObject = restTemplate.getForObject(PAYENT_URL + "/sys/payment/get/" + id, CommonResult.class);
        return forObject;
    }

//    @GetMapping("payment/lb")
//    public String getPaymentLB() {
//        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
//        if (instances == null || instances.size() == 0) {
//            return null;
//        }
//        ServiceInstance serviceInstance = loadBalaner.instance(instances);
//        URI uri = serviceInstance.getUri();
//        System.out.println(uri+"/payment/lb");
//        return restTemplate.getForObject(uri+"/payment/lb",String.class);
////        return uri+"/payment/lb";
//    }
}
