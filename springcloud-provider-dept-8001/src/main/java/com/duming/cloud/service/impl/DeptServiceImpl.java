package com.duming.cloud.service.impl;

import com.duming.cloud.mapper.DeptMapper;
import com.duming.cloud.pojo.Dept;
import com.duming.cloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    DeptMapper deptMapper;

    public boolean addDept(Dept dept) {
        return deptMapper.addDept(dept);
    }

    public Dept queryDeptByDeptno(Long deptno) {
        return deptMapper.queryDeptByDeptno(deptno);
    }

    public List<Dept> queryAll() {
        return deptMapper.queryAll();
    }
}
