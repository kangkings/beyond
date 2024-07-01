package org.example.inflearn.member.service;

import lombok.RequiredArgsConstructor;
import org.example.inflearn.member.model.Member;
import org.example.inflearn.member.model.request.PostSignupReq;
import org.example.inflearn.member.model.response.PostSignupRes;
import org.example.inflearn.member.repository.MemberRepository;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

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


    public void editEnable(String email) {
        Member member = memberRepository.findByEmail(email).get();
        member.setEnabled(true);
        memberRepository.save(member);
    }
}
