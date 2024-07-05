package org.example.kakao.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.example.kakao.util.JwtUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import java.io.IOException;

import java.util.Map;


@Component
@RequiredArgsConstructor
public class OAuth2AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private final JwtUtil jwtUtil;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {

        System.out.println("들어옴");
        OAuth2User oAuth2User = (OAuth2User)authentication.getPrincipal();

        Map<String, Object> properties = (Map<String,Object>)oAuth2User.getAttributes().get("properties");
        String nickname = ""+properties.get("nickname");

        String token = jwtUtil.createToken(nickname, "ROLE_USER");
        response.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + token);

        Cookie aToken = new Cookie("aToken", token);
        //response.setHeader(HttpHeaders.SET_COOKIE, "aToken = Bearer " + token);
        getRedirectStrategy().sendRedirect(request, response, "avcd");

    }

}
