package com.example.memberapi.member;

import com.example.memberapi.member.model.Member;
import com.example.memberapi.member.model.request.PostSignupReq;
import com.example.memberapi.member.model.response.PostSignupRes;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder encoder;

    public PostSignupRes signup(PostSignupReq req){
        Member member = req.toEntity(encoder.encode(req.getPassword()));
        member = memberRepository.save(member);
        return member.toPostSignupRes();
    }

}
