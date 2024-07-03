package org.example.kafkawebsocket;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
@Component
public class ChatWebSocketHandler extends TextWebSocketHandler {

    //세션들 저장할 변수
    private  final Set<WebSocketSession> sessions = new HashSet<>();
    private final KafkaTemplate<String, String> kafkaTemplate;

    //클라이언트가 연결하면 세션 저장 변수에 클라이언트 세션을 추가

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        //연결이 성공했을 때 세션 추가
        sessions.add(session);
        System.out.println(session.getId()+"클라이언트가 접속");
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessions.remove(session);
        System.out.println(session.getId()+"클라이언트가 접속을 해제");

    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        for(WebSocketSession s : sessions){
            kafkaTemplate.send("chat",message.getPayload());
        }
    }

    //메시지를 받으면 다른 사람들에게 메시지를 전송
    @KafkaListener(topics = "chat", groupId = "group_1")
    public void receive(String message) throws IOException {
        for(WebSocketSession s : sessions){
            s.sendMessage(new TextMessage(message));
        }
    }

    //클라이언트가 연결을 끊으면 세션 저장 변수에서 클라이언트 세션을 삭제
}
