package org.example.inflearn.member.service;

import lombok.RequiredArgsConstructor;
import org.example.inflearn.member.model.EmailVerify;
import org.example.inflearn.member.repository.EmailVerifyRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmailVerifiyService {
    private final EmailVerifyRepository emailVerifyRepository;
    private final JavaMailSender emailSender;
    public String sendEmail(String username, String uuid){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(username);
        message.setSubject("[InflearnFake] 가입 환영");
        message.setText("http://localhost/member/verify?email="+username+"&uuid="+uuid);
        emailSender.send(message);
        return uuid;
    }

    public String saveUuid(String email){
        String uuid = UUID.randomUUID().toString();
         emailVerifyRepository.save(EmailVerify.builder().email(email)
                .uuid(uuid).build());

         return uuid;
    }

    public boolean checkUuid(String email, String uuid){
        Optional<EmailVerify> res = emailVerifyRepository.findByUuid(uuid);
        if (res.isEmpty()){
            return false;
        }else {
            return true;
        }
    }
}
