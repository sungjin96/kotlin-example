package com.example.gatewayservice.config

import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Created by marathoner on 2022/03/26
 */
//@Configuration
class FilterConfiguration {

//    @Bean
    fun gatewayRoutes(builder: RouteLocatorBuilder): RouteLocator {
        return builder.routes()
            .route { it ->
                it.path("/first-service/**")
                    .filters { f ->
                        f.addRequestHeader("first-request", "first-request-header")
                            .addResponseHeader("first-response", "first-response-header")
                    }
                    .uri("http://127.0.0.1:8081/")
            }
            .route { it ->
                it.path("/second-service/**")
                    .filters { f ->
                        f.addRequestHeader("second-request", "second-request-header")
                            .addResponseHeader("second-response", "second-response-header")
                    }
                    .uri("http://127.0.0.1:8082/")
            }
            .build()
    }
}
