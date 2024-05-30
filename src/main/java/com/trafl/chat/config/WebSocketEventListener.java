package com.trafl.chat.config;

import java.time.LocalDateTime;

import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import com.trafl.chat.domain.Msg;
import com.trafl.chat.domain.MsgType;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class WebSocketEventListener {
	
	String timestamp = LocalDateTime.now().toString();
	
	private final SimpMessageSendingOperations messageSendingOperations;

	@EventListener
	public void handleWebSocketDisconnectListener(SessionDisconnectEvent  event) {
	
		StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
  
		String username = (String) headerAccessor.getSessionAttributes().get("username");
        
		if (username != null) {
            log.info("[{}] - [WebSocketEventListener] - user disconnected: {}",timestamp, username);
            var chatMessage = Msg.builder()
                    .type(MsgType.LEAVER)
                    .username(username)
                    .build();
            
            messageSendingOperations.convertAndSend("/chat", chatMessage);
        }
		
	}
}
