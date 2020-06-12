package com.afei.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyselfRule {

    @Bean
    public IRule myRule() {
        //自定义负载算法，定义为随机
        return new RandomRule();
    }
}