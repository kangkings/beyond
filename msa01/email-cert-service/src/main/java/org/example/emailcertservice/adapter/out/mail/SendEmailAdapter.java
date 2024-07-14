package org.example.emailcertservice.adapter.out.mail;

import lombok.RequiredArgsConstructor;
import org.example.emailcertservice.application.port.out.SendEmailPort;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class SendEmailAdapter implements SendEmailPort {
    private final JavaMailSender emailSender;

    @Override
    public void sendEmail(String email, String uuid) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("[msa] 가입 환영");
        message.setText("http://localhost/emailcert/verify?email="+email+"&uuid="+uuid);
        emailSender.send(message);
    }
}
