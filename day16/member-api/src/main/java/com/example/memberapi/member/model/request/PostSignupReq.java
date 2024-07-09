package com.example.memberapi.member.model.request;

import com.example.memberapi.member.model.Member;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;


@Builder
@Getter
public class PostSignupReq {

    private String email;

    private String password;

    private String name;
    public Member toEntity(String passwordEncoded){
        return Member.builder()
                .email(email)
                .password(passwordEncoded)
                .build();
    }
}
