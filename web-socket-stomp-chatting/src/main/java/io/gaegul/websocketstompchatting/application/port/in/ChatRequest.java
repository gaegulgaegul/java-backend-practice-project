package io.gaegul.websocketstompchatting.application.port.in;

import javax.validation.constraints.NotBlank;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 채팅 요청
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
public class ChatRequest {
	@NotBlank
	private String sender;		// 송신자 ID
	@NotBlank
	private String roomId;		// 채팅방 ID
	@NotBlank
	private String message;		// 메세지
}
