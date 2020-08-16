package com.gfpz.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration//就相当于spring的applicationContext.xml
public class ConfigBean {

    //IRule接口的实现类：
    //AvailabilityFilteringRule：先过滤掉跳闸的服务 对剩下的服务进行轮询
    //RoundRobinRule：轮询  默认使用这个
    //RandomRule：随机
    //RetryRule：先轮询，失败的话，在指定的时间内重试
    @Bean
    @LoadBalanced//配置ribbon负载均衡实现RestTemplate
    public RestTemplate getTemplate(){
        return new RestTemplate();
    }

}
