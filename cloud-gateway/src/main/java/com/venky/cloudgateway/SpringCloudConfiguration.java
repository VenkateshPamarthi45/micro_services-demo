package com.venky.cloudgateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfiguration {
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("departmentModule", r -> r.path("/api/departments/**")
                        .uri("lb://DEPARTMENT-SERVICE")
                )

                .route("usersModule", r -> r.path("/api/users/**")
                        .uri("lb://USER-SERVICE")
                )
                .build();
    }
}