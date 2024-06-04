package com.trafl.chat.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Builder
public class Msg {
	private String username;
	private String message;
	private String time;
	private MsgType type;
}
