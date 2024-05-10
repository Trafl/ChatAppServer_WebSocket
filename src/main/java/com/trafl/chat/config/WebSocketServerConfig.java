package com.trafl.chat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketServerConfig implements WebSocketMessageBrokerConfigurer {

   @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/chat"); //Canal para receber as mensagens
        registry.setApplicationDestinationPrefixes("/app"); //Prefixo mapeado para cada rota
    }
	
	@Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("conect_websocket").setAllowedOrigins("*"); //Conecta ao WebSocket (Servidor)
		registry.addEndpoint("conect_websocket").setAllowedOrigins("*").withSockJS(); //Conecta ao WebSocket (Servidor)
    }

}
