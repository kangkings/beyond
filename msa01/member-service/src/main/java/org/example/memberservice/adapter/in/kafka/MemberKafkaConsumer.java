package org.example.memberservice.adapter.in.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class MemberKafkaConsumer {

    @KafkaListener(groupId = "1", topics = "member_signup")
    public void receive(String message) throws IOException {
        System.out.println(message);
    }

}
