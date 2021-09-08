package com.duming.cloud.controller;

import com.duming.cloud.pojo.Dept;
import com.duming.cloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//提供restful服务
@RestController
public class DeptController {
    @Autowired
    DeptService deptService;


    @HystrixCommand(fallbackMethod = "hystrixQuerDeptByDeptno")
    @GetMapping("/dept/query/{deptNo}")
    public Dept  querDeptByDeptno (@PathVariable("deptNo") Long deptNo){
        System.out.println("=======querDeptByDeptno===========");
        Dept dept= deptService.queryDeptByDeptno(deptNo);
        if(null == dept){
            throw  new  RuntimeException("deptNo=>"+deptNo+",不存在该用户，或者信息无法找到！");
        }
        return dept;
    }

    //备选方法
    public Dept  hystrixQuerDeptByDeptno (@PathVariable("deptNo") Long deptNo){
        return new Dept()
                .setDeptno(deptNo)
                .setDname("deptNo=>"+deptNo+"没有对应信息，null--@Hystrix")
                .setDbsource("no this dbsource in MySql");
    }

}
