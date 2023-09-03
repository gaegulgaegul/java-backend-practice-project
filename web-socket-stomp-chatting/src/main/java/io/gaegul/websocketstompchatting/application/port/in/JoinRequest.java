package io.gaegul.websocketstompchatting.application.port.in;

import javax.validation.constraints.NotBlank;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 채팅방 입장 요청
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
public class JoinRequest {
	@NotBlank
	private String sender;		// 송신자
	@NotBlank
	private String roomId;		// 채팅방 ID
}
