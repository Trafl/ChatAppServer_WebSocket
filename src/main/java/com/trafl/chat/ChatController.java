package com.trafl.chat;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.trafl.chat.domain.Msg;
import com.trafl.chat.domain.MsgDTO;

@Controller
public class ChatController {

	@MessageMapping("/chat_send_message") // Manda msg no /app/chat_send_message
	@SendTo("/chat") // A mensagem e encaminhada ao /chat
	public Msg sendMessage(@Payload MsgDTO messageDTO) {
		String time = new SimpleDateFormat("HH:mm").format(new Date());
		var message = new Msg(messageDTO.name(), messageDTO.message(), time);
		
		return message;
	}
}
