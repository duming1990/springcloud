package com.duming.cloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration //相当于spring中 applicationContext.xml
public class ConfigBean {
    //配置负载均衡实现RestTemplate
    //IRule
    //RoundRobinRule:轮询
    //RandomRule:随机
    //AvailabilityFilteringRule:会先过滤掉，跳闸，访问故障的服务，对剩下的经行轮询
    //WeightedResponseTimeRule:权重
    //RetryRule:重试，会先按照轮询获取服务，如果获取失败，则会在指定的时间内经行重试
    @LoadBalanced   //Ribbon
    @Bean
    public RestTemplate getRestTemplate(){
        return  new RestTemplate();
    }


}
