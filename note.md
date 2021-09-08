1.导入依赖
2.编写配置
3.开启这个功能@EnableXXXXX
4.配置类

```sql
CREATE TABLE `dept` (
  `deptno` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '部门编号',
  `dname` varchar(255) DEFAULT NULL COMMENT '部门名称',
  `dbsource` varchar(255) DEFAULT NULL COMMENT '表名',
  UNIQUE KEY `deptno` (`deptno`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
```

