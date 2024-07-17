package org.example.emailcertservice.adapter.in.kafka;

import lombok.RequiredArgsConstructor;
import org.example.emailcertservice.application.port.in.SendEmailCommand;
import org.example.emailcertservice.application.port.in.SendEmailUseCase;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class EmailKafkaConsumer {
    private final SendEmailUseCase useCase;

    @KafkaListener(groupId = "2", topics = "member_signup")
    public void receive(String message) throws IOException {
        SendEmailCommand command = SendEmailCommand.builder()
                .email(message)
                .build();

        useCase.sendEmail(command);
    }

}
