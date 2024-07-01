package org.example.inflearn.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.example.inflearn.member.model.Member;
import org.example.inflearn.member.repository.MemberRepository;
import org.example.inflearn.util.JwtUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestRedirectFilter;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;


@Component
@RequiredArgsConstructor
public class OAuth2AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private final JwtUtil jwtUtil;
    private final MemberRepository memberRepository;



    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        System.out.println("들어옴");
        OAuth2User oAuth2User = (OAuth2User)authentication.getPrincipal();
        System.out.println(oAuth2User.getAttributes().keySet());

        Map<String, Object> properties = (Map<String,Object>)oAuth2User.getAttributes().get("properties");
        System.out.println(properties);
        String nickname = ""+properties.get("nickname");
        String role = ""+authentication.getAuthorities().iterator().next();
        Member member = memberRepository.findByName(nickname).get();


        String token = jwtUtil.createToken(nickname,role , member.getId());
        response.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + token);

        Cookie aToken = new Cookie("aToken", token);
        aToken.setPath("/");
        aToken.setMaxAge(60*60*24);
        response.addCookie(aToken);
        getRedirectStrategy().sendRedirect(request, response, "http://localhost:3000/member/login/callback");

//        PrintWriter out = response.getWriter();
//        out.println(\"isSuccess\": true, \"accessToken\":\""+token+);

    }
}
