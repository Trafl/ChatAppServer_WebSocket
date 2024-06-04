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
        registry.enableSimpleBroker("/chat"); //Channel to receive messages
        registry.setApplicationDestinationPrefixes("/app"); //Prefix mapped to each route
    }
	
	@Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("conect_websocket").setAllowedOrigins("*"); //Connected to WebSocket (Server)
		registry.addEndpoint("conect_websocket").setAllowedOrigins("*").withSockJS(); //Connected to WebSocket (Server)
    }

}
