package com.gfpz.myRule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RefrainRule {
    @Bean
    public IRule myRule(){
        return new RoundRobinRule();//自定义负载均衡策略 RefrainRandomRule
    }
}
