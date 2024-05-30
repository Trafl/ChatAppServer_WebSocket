package com.trafl.chat.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import com.trafl.chat.domain.Msg;
import com.trafl.chat.domain.MsgAddUserDTO;
import com.trafl.chat.domain.MsgDTO;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class ChatController {
	
	String timestamp = LocalDateTime.now().toString();

	@MessageMapping("/chat_send_message") // Manda msg no /app/chat_send_message
	@SendTo("/chat") // A mensagem e encaminhada ao /chat
	public Msg sendMessage(@Payload MsgDTO messageDTO) {
		
		log.info("[{}] - [ChatController] - Message received", timestamp);
		
		String time = createDateInStringFormat();
		
		var message = Msg.builder()
						.username(messageDTO.username())
						.message(messageDTO.message())
						.time(time)
						.type(messageDTO.type())
						.build();
		
		log.info("[{}] - [ChatController] - Message Build and send", timestamp);
		return message;
	}
	
	@MessageMapping("/chat_add_user") 
	@SendTo("/chat")
	 public MsgAddUserDTO addUser(@Payload MsgAddUserDTO messageDTO, SimpMessageHeaderAccessor headerAccessor) {
		// add username to session
		
		headerAccessor.getSessionAttributes().put("username", messageDTO.username());
		log.info("[{}] - [ChatController] - username: {}, add to headerAccessor", timestamp, messageDTO.username());
        return messageDTO;
	}

	private String createDateInStringFormat() {
		var dateFormat = new SimpleDateFormat("HH:mm");
		dateFormat.setTimeZone(TimeZone.getTimeZone("America/Sao_Paulo"));
		String time = dateFormat.format(new Date());
		return time;
	}
}
