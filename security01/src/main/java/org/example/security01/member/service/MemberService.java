package org.example.security01.member.service;

import org.example.security01.member.model.Member;
import org.example.security01.member.reposiroty.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void signup(Member member) {

        memberRepository.save(member);
        System.out.println("저장 성공");
    }
}
