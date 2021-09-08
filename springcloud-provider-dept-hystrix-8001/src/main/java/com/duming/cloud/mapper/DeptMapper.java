package com.duming.cloud.mapper;

import com.duming.cloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Repository
@Mapper
public interface DeptMapper {
    @PostMapping("/dept/add")
    boolean addDept(Dept dept);

    @GetMapping("/dept/query/{deptNo}")
    Dept queryDeptByDeptno(@Param("deptno") Long deptno);

    @GetMapping("/dept/queryAll")
    List<Dept> queryAll();

}
