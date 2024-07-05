package org.example.websocketchat.websocket;


import org.kurento.client.KurentoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;

@Configuration
@EnableWebSocket
public class WevSocketcojfig implements WebSocketConfigurer {

    @Bean
    public CallHandler callHandler(){return new CallHandler();}

    @Bean
    public KurentoClient kurentoClient(){return KurentoClient.create("ws://localhost:8888/kurento");}

    @Bean
    public ServletServerContainerFactoryBean servletServerContainerFactoryBean(){
        ServletServerContainerFactoryBean container = new ServletServerContainerFactoryBean();
        container.setMaxTextMessageBufferSize(32768);
        return container;
    }
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new ChatWebSocketHandler(), "/path").setAllowedOrigins("*");
        registry.addHandler(new CallHandler(), "/call").setAllowedOrigins("*");
    }
}
