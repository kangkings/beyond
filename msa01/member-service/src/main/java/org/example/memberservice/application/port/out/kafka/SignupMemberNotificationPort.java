package org.example.memberservice.application.port.out.kafka;

public interface SignupMemberNotificationPort {
    void sendSignupMessage(String Message);
}
