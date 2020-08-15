package com.gfpz.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration//就相当于spring的applicationContext.xml
public class ConfigBean {
    @Bean
    public RestTemplate getTemplate(){
        return new RestTemplate();
    }
}
