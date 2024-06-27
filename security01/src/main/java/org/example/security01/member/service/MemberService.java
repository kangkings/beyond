package org.example.security01.member.service;

import lombok.RequiredArgsConstructor;
import org.example.security01.member.model.Member;
import org.example.security01.member.reposiroty.MemberRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void signup(String email, String password){

        Member member = Member.builder()
                .email(email)
                .password(bCryptPasswordEncoder.encode(password))
                .role("ROLE_ADMIN")
                .build();

        memberRepository.save(member);

        System.out.println("저장 성공");
    }
}
