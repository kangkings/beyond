package org.example.day070302;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    @KafkaListener(topics = "a", groupId = "group_1")
    public void receive(String message) {
        System.out.println(message);
    }
}
