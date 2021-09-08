package com.duming.cloud.controller;

import com.duming.cloud.pojo.Dept;
import com.duming.cloud.service.DeptClientService;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptController {
    @Autowired
    DeptClientService deptClientService;

    @RequestMapping("/consumer/dept/add")
    public Boolean addDept(Dept dept){
        return deptClientService.addDept(dept);
    }

    @RequestMapping("/consumer/dept/queryAll")
    public List<Dept> queryAll(){
        return deptClientService.queryAll();
    }

    @RequestMapping(value = "/consumer/dept/query/{deptNo}")
    public Dept getDept(@PathVariable("deptNo") Long deptNo){
        Dept dept=deptClientService.queryDeptByDeptno(deptNo);
        System.out.println("===================="+dept);
        return dept;
    }


}
