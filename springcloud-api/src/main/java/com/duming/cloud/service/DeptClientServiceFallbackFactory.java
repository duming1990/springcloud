package com.duming.cloud.service;

import com.duming.cloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;
//降级~
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory {
    @Override
    public DeptClientService create(Throwable cause) {
       return new DeptClientService() {
           @Override
           public boolean addDept(Dept dept) {
               return false;
           }

           @Override
           public Dept queryDeptByDeptno(Long deptno) {
               return new Dept().setDeptno(deptno).setDname("降级，服务已关闭！");
           }

           @Override
           public List<Dept> queryAll() {
               return null;
           }
       };
    }
}
