package com.duming.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DmRule {
    @Bean
    public IRule myRule(){
        return  new RoundRobinRule();//默认是轮询
//        return  new DmRandomRule();//现在我们自定义为DmRandomRule
    }

}
