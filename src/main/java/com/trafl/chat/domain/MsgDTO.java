package com.trafl.chat.domain;

public record MsgDTO(String username, String message, String time, MsgType type) {
}
