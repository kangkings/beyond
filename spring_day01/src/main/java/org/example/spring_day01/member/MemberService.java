package org.example.spring_day01.member;

import org.example.spring_day01.member.model.MemberLoginReq;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private MemberRepository memberRepository;

    public String method01() {
        System.out.println("메소드 실행됨");
        return "Member Service Method01";
    }

    public String login(MemberLoginReq memberLoginReq) {
        if (memberLoginReq.getEmail().equals("test01") && memberLoginReq.getPassword().equals("qwer1234")){
            return "로그인 성공";
        }else {
            return "로그인 실패";
        }

    }
}
