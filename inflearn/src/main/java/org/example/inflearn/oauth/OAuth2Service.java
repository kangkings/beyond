package org.example.inflearn.oauth;

import lombok.RequiredArgsConstructor;
import org.example.inflearn.member.model.Member;
import org.example.inflearn.member.repository.MemberRepository;
import org.example.inflearn.member.service.EmailVerifiyService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OAuth2Service extends DefaultOAuth2UserService {

    private final MemberRepository memberRepository;
    private final EmailVerifiyService emailVerifiyService;
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);
        Map<String, Object> attributes = oAuth2User.getAttributes();
        Map<String, Object> properties = (Map<String, Object>) attributes.get("properties");
        String name = (String) properties.get("nickname");
        System.out.println(properties);

        // nickName으로 DB 확인
        Optional<Member> res = memberRepository.findByName(name);
        Member member;
        if (!res.isPresent()){
            member = memberRepository.save(Member.builder().email(name+"@kakao.com")
                            .createdAt(LocalDateTime.now())
                            .name(name)
                            .enabled(true)
                    .build());
            emailVerifiyService.saveUuid(name+"@kakao.com");
        }else {
            member = res.get();
        }

        System.out.println(member.getRole());

        // 없으면 가입
        return new DefaultOAuth2User(
                Collections.singleton(new SimpleGrantedAuthority(member.getRole())),
                attributes,
                "id"
        );
    }
}
