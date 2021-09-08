package com.duming.cloud.service;

import com.duming.cloud.pojo.Dept;

import java.util.List;

public interface DeptService {
    boolean addDept(Dept dept);

    Dept queryDeptByDeptno(Long deptno);

    List<Dept> queryAll();
}
