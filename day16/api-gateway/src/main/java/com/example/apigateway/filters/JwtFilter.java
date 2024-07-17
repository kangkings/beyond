package com.example.apigateway.filters;

import com.example.apigateway.util.JwtUtil;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Indexed;


@Component
public class JwtFilter extends AbstractGatewayFilterFactory<JwtFilter.Config> {
    private final JwtUtil jwtUtil;

    public JwtFilter(JwtUtil jwtUtil) {
        super(Config.class);
        this.jwtUtil = jwtUtil;
    }

    public static class Config{
        //게이트웨이는 필터는 기본제공안함
        //만들어 쓸 수 있는 도움을 줌(틀)
        //정해진 틀의 메소드(apply)를 구현하면 -> 이걸 토대로 필터를 만들고 등록까지 해줌
        //필터로 등록됨
        // 게이트웨이도 필터가 있으면 실행하는 기능을 최초에 실행함

        //d요청 접수

        //필터가 있으면
        //최초 필터 호출
        //다음필터 호출
        //끝나면 매핑

        //게이트웨이 필수 기본 기능


        // 게이트웨이 필터나 글로벌필터를 상속받아서 apply 구현한거 있어?> 있으면 필터로 만들어둬
        //요청 접수 -> 필터 호출하고 실행 -> 매핑 -> 나갈때 필터 실행 -> 응답
        //            (JwtFilter,GatewayFilter)                (빔)
        //                 특정 라우터에만 적용
        //                  post
        //



    }
    @Override
    public GatewayFilter apply(Config config) {
        return (((exchange, chain) -> {
            String authorization = exchange.getRequest().
                    getHeaders().getFirst(HttpHeaders.AUTHORIZATION);

            if (authorization == null || !authorization.startsWith("Bearer")){
                System.out.println("토큰없음");
                ServerHttpResponse response = exchange.getResponse();
                response.setStatusCode(HttpStatus.UNAUTHORIZED);
                return response.setComplete();
            }

            String token = authorization.split(" ")[1];

            if (jwtUtil.isExpired(token)){
                System.out.println("토큰 만료됨");
                ServerHttpResponse response = exchange.getResponse();
                response.setStatusCode(HttpStatus.UNAUTHORIZED);
                return response.setComplete();
            }

            exchange.getRequest().mutate()
                    .header("X-User-Username", ""+jwtUtil.getUsername(token))
                    .header("X-User-Role", ""+jwtUtil.getRole(token))
                    .build();


            return chain.filter(exchange);
        }));
    }


}
