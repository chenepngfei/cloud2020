package com.afei.springcloud.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("payment")
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("zk")
    public String paymentzk(){
        log.info(serverPort);
        return "springcloud with zookeeper:" + serverPort +"\t" + UUID.randomUUID().toString();
    }

}