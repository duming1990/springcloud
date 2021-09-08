package com.duming.cloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;

//启动类
@SpringBootApplication
@EnableEurekaClient //在服务启动后，自动注册到Eureka中
@EnableDiscoveryClient //服务发现
@EnableCircuitBreaker   //添加对熔断的支持
public class DeptProviderHystrix_8001 {
    public static void main(String[] args) {
        SpringApplication.run(DeptProviderHystrix_8001.class, args);
    }

    //增加一个Servlet
    @Bean
    public ServletRegistrationBean HystrixMetricsStreamServlet(){
        ServletRegistrationBean registrBean = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
        registrBean.addUrlMappings("/actuator/hystrix.stream");
        return  registrBean;
    }
}
