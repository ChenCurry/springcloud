package com.gfpz.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;


@EnableDiscoveryClient//服务发现
@EnableFeignClients
@EnableEurekaClient//自动注册到eureka中
@SpringBootApplication
@EnableHystrix
@EnableHystrixDashboard
@EnableCircuitBreaker//添加对熔断的支持
public class DeptProviderHystrix_8001 {
    public static void main(String[] args) {
        SpringApplication.run(DeptProviderHystrix_8001.class, args);
    }

    //增加一个servletHystrixMetricsStreamServlet
    @Bean
    public ServletRegistrationBean hystrixMetricsStreamServlet() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
        registrationBean.setLoadOnStartup(1);// /actuator/hystrix.stream   /hystrix.stream
        registrationBean.addUrlMappings("/hystrix.stream");//搜索 HystrixStreamEndpoint HystrixMetricsStreamServlet “Adding the following to web.xml”
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
