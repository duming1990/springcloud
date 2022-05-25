package com.dm.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author D&M
 * @date 2022/5/25
 * @apiNote
 */
@Configuration
public class GateWayConfig {
    @Bean
    public RouteLocator customRoutelocato(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("path_routr_duming", r -> r.path("/guonei").uri("http://www.baidu.com/guonei")).build();
        return routes.build();
    }
}
