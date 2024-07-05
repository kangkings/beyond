package org.example.inflearn.member.model.request;

import lombok.*;
import org.example.inflearn.member.model.Member;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;


@Builder
@Getter
public class PostSignupReq {

    private String email;

    private String password;

    private String name;
    public Member toEntity(String passwordEncoded){
        return Member.builder()
                .createdAt(LocalDateTime.now())
                .name(name)
                .email(email)
                .password(passwordEncoded)
                .build();
    }
}
