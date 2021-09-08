package com.duming.cloud.mapper;

import com.duming.cloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface DeptMapper {

    boolean addDept(Dept dept);

    Dept queryDeptByDeptno(@Param("deptno") Long deptno);

    List<Dept> queryAll();

}
