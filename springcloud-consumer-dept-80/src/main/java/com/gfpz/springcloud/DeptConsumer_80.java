package com.gfpz.springcloud;

import com.gfpz.myRule.RefrainRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
//在微服务启动的时候就去加载 自定义的Ribbon类
@RibbonClient(name="SPRINGCLOUD-PROVIDER-DEPT",configuration = RefrainRule.class)
public class DeptConsumer_80 {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_80.class,args);
    }
}
