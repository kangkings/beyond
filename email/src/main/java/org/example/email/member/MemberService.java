package org.example.email.member;

import org.example.email.member.model.Member;
import lombok.RequiredArgsConstructor;
import org.example.email.member.model.Member;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final JavaMailSender emailSender;

    public void signup(String username, String password) {

        Member member = Member.builder()
                .email(username)
                .password(password)
                .role("ROLE_USER")
                .active(false)
                .build();
        memberRepository.save(member);
    }


    public Member getMemberByEmail(String nickName) {
        Optional<Member> result = memberRepository.findByEmail(nickName);
        if(result.isPresent()) {
            Member member = result.get();
            return member;
        }
        return null;
    }

    public String sendEmail(String username){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(username);
        message.setSubject("[내 사이트] 가입 환영");
        String uuid = UUID.randomUUID().toString();
        message.setText("http://localhost/member/verify?email="+username+"&uuid="+uuid);
        emailSender.send(message);
        return uuid;
    }
}
