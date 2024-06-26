package org.example.security01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    //웹 소켓을 사용하면 요청1 - 응답1의 HTTP에선 할 수 없는
    //요청1로 연결확보하여 지속적인 응답을 구현할 수 있다

    //webflux -> 네티라는 서버쓰고 병렬처리에 특화

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        //세션 로그인 방식일 때 사용하는 공격기법으로, jwt사용할거기 때문에 꺼둔다.
        //스프링 시큐리티는 기본적으로 세샨로그인 방식을 디폴트로 사용하고 이에 대한 대책이 기본으로 구현되어있다.
        //세션 안쓸거면 커스텀해서 바꿔줘야함
        http.csrf((auth) -> auth.disable());
        //http의 여러 기본 인증방식 중 하나
        http.httpBasic((auth)-> auth.disable());

        //*은각각 하위 한 단계를 의미 **는 하위에 있는 모든 것을 의미
        //필요에 따라 여러개의 requestMathers를 추가할 수 있다.
        //mathers안에는 여러개의 값(페이지)를 한번에 나열해서 할당할 수 있다.
        //컨트롤러 단위, 메소드 단위로 제한을 전부 걸 수 있다.
        http.authorizeHttpRequests((auth) ->
                auth
                        .requestMatchers("/role/**").hasRole("ADMIN")
                        .requestMatchers("/test/**","/mypage").authenticated()
                        .requestMatchers("/user/**").permitAll()
                        .anyRequest().authenticated()
        );
        //특정 페이지를 차단하고 나머지 다 허용 -> 블랙리스트
        //특정 페이지를 허용하고 나머지 다 차단 -> 화이트리스트
        return http.build();
    }
}
