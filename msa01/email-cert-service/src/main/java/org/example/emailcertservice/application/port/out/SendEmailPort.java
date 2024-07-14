package org.example.emailcertservice.application.port.out;

public interface SendEmailPort {
    void sendEmail(String email, String uuid);
}
