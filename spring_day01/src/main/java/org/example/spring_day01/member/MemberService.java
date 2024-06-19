package org.example.spring_day01.member;

import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private MemberRepository memberRepository;

    public String method01() {
        System.out.println("메소드 실행됨");
        return "Member Service Method01";
    }
}
