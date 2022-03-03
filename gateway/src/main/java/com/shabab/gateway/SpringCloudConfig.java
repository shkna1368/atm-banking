package com.shabab.gateway;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/bank-service/**")
                        .uri("lb://bank-service")
                       )

                .route(r -> r.path("/atm-service/**")
                        .uri("lb://atm-service")
                       )
                .build();
    }

}