package com.duming.cloud.controller;

import com.duming.cloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptController {
    //理解：消费者，不应该有service层
    //RestTemplate.... 供我们直接调用就可以了!注册到spring中
    //(url,实体：Map,Class<T> responseType)

    @Autowired
    RestTemplate restTemplate;//提供多种便捷访问远程http服务的方法，简单的Restful服务模板

    //Ribbon,我们这里的地址，应该是一个变量，通过服务名来访问
    //private static String REST_URL_PREFIX="http://localhost:8001";
    private static String REST_URL_PREFIX="http://SPRINGCLOUD-PROVIDER-DEPT";

    @RequestMapping("/consumer/dept/add")
    public Boolean getDept(Dept dept){
        return  restTemplate.postForObject(REST_URL_PREFIX+"/dept/add", dept, Boolean.class);
    }

    @RequestMapping("/consumer/dept/queryAll")
    public List<Dept> queryAll(){
//        return (List<Dept>) restTemplate.getForObject(REST_URL_PREFIX+"/dept/queryAll", Dept.class);
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/queryAll", List.class);
    }

    @RequestMapping("/consumer/dept/query/{deptNo}")
    public Dept getDept(@PathVariable("deptNo") Long deptNo){
//        return  restTemplate.getForObject(REST_URL_PREFIX+"/dept/query/", Dept.class, deptNo);
        return  restTemplate.getForObject(REST_URL_PREFIX+"/dept/query/"+deptNo, Dept.class);
    }


}
