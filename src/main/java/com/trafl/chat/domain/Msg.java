package com.trafl.chat.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Msg {
	private String name;
	private String message;
	private String time;
}
