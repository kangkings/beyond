package org.example.tddbackend.member.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Builder
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class MemberCreateReq {

    private String email;
    private String password;


    public Member toMember(String passwordEncoded){
        return Member.builder()
                .email(email)
                .password(passwordEncoded)
                .build();
    }
}
