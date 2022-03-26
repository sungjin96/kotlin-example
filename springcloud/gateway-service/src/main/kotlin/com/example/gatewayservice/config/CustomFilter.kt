package com.example.gatewayservice.config

import org.apache.commons.lang.ObjectUtils
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.rsocket.RSocketProperties.Server
import org.springframework.cloud.gateway.filter.GatewayFilter
import org.springframework.cloud.gateway.filter.GatewayFilterChain
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory
import org.springframework.http.server.reactive.ServerHttpRequest
import org.springframework.http.server.reactive.ServerHttpResponse
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono

/**
 * Created by marathoner on 2022/03/26
 */
@Component
class CustomFilter : AbstractGatewayFilterFactory<Any>() {
    private val log = LoggerFactory.getLogger(CustomFilter::class.java)

    override fun apply(config: Any) = GatewayFilter { exchange: ServerWebExchange, chain: GatewayFilterChain ->
        val request: ServerHttpRequest = exchange.request
        val response: ServerHttpResponse = exchange.response

        log.info("Custom PRE filter: request uri -> {}", request.id)

        chain.filter(exchange).then(Mono.fromRunnable {
            log.info("Custom POST filter: response code -> {}", response.statusCode)
        })
    }
}
