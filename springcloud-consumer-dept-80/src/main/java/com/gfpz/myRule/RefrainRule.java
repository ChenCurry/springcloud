package com.gfpz.myRule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RefrainRule {
    @Bean
    public IRule myRule(){
        return new RefrainRandomRule();//自定义负载均衡策略
    }
}
