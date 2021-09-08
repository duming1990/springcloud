package com.duming.cloud.controller;

import com.duming.cloud.pojo.Dept;
import com.duming.cloud.service.DeptService;
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

    //获取一些配置的信息，得到具体的微服务！
    @Autowired
    DiscoveryClient client;

    @PostMapping("/dept/add")
    public  boolean addDept(@RequestBody Dept dept){
        return deptService.addDept(dept);
    }

    @GetMapping("/dept/query/{deptNo}")
    public Dept  querDeptByDeptno (@PathVariable("deptNo") Long deptNo){
        return deptService.queryDeptByDeptno(deptNo);
    }

    @GetMapping("/dept/queryAll")
    public List<Dept> getDept(){
        return deptService.queryAll();
    }

    //注册进来的微服务，获取一些信息
    @GetMapping("/dept/discovery")
    public Object discovery(){
        //获取微服务列表的清单
        List<String> services = client.getServices();
        System.out.println("discovert=>services:"+services);

        //得到一个具体的微服务信息，通过具体的微服务id，applicationName；
        List<ServiceInstance> instances = client.getInstances("springcloud-provider-dept");
        for (ServiceInstance instance : instances) {
            System.out.println(
                    instance.getHost()+"\t"+
                    instance.getPort()+"\t"+
                    instance.getUri()+"\t"+
                    instance.getServiceId()+"\t"
                    );
        }
        return  this.client;
    }

}
