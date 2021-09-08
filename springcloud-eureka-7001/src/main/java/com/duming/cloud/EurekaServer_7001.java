package com.duming.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

//启动之后访问 localhost:7001
@SpringBootApplication
@EnableEurekaServer //EnableEurekaServer服务端的启动类，可以接受别人注册进来！
public class EurekaServer_7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer_7001.class, args);
    }
}
