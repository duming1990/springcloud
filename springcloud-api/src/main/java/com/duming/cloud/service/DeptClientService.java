package com.duming.cloud.service;

import com.duming.cloud.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Component
@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT",fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {
    @PostMapping("/dept/add")
    boolean addDept(Dept dept);

    @GetMapping("/dept/query/{deptNo}")
    Dept queryDeptByDeptno(Long deptno);

    @GetMapping("/dept/queryAll")
    List<Dept> queryAll();
}
