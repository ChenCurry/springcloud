package com.gfpz.springcloud.controller;

import com.gfpz.springcloud.pojo.Dept;
import com.gfpz.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//提供restful服务
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping("/dept/get/{id}")
    @HystrixCommand(fallbackMethod = "hystrixGet")//此方法失败了就去调用指定的方法，注意注解顺序！！
    public Dept get(@PathVariable("id") Long id){
        Dept dept = deptService.queryById(id);
        if(null==dept){
            throw new RuntimeException("id==>" + id + "，不存在该用户或信息无法找到~");
        }
        return dept;
    }

    //备选方案
    public Dept hystrixGet(@PathVariable("id") Long id){
        return new Dept()
                .setDeptno(id)
                .setDname("id==>" + id + "，没有对应的信息，null~@Hystix")
                .setDb_source("has no this db in mysql");
    }

}
