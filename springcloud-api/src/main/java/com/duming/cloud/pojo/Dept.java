package com.duming.cloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors(chain = true) //链式写法：Dept dept=new Dept(); dept.setSeptNo().setDeptName().
public class Dept implements Serializable {
    private Long deptno;//主键
    private String dname;
    //这个数据存在那个数据库，微服务，一个服务对一个数据库，同一个信息可能存在不同的数据库
    private String dbsource;

    public Dept(String dname) {
        this.dname = dname;
    }
}
