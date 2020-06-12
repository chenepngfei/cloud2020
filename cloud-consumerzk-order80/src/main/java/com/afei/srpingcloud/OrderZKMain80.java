package com.afei.srpingcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient//该注解用于向使用consul或者zookeeper作为注册中心注册服务
public class OrderZKMain80 {
    public static void main(String[] args) {
            SpringApplication.run(OrderZKMain80.class,args);
        }
}
