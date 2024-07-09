package com.example.apigateway.filters;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class CustomGlobalFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("인바운드 시점에서 커스텀 글로벌 필터 실행"+System.currentTimeMillis());
        return chain.filter(exchange)
                .then(Mono.fromRunnable(() -> {
                    // 아웃바운드 처리
                    System.out.println("아웃바운드 시점에서 커스텀 글로벌 필터 실행"+System.currentTimeMillis());
                }));
        //인바운드 1720515549 049
        //시큐리티 1720515549 513
        //아웃바운드 1720515549 517
    }
}
