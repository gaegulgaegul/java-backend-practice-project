package io.gaegul.websocketstompchatting.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 채팅
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
public class Chat {
	private Long senderId;			// 송신자 ID
	private Long receiverId;		// 수신자 ID
	private Long roomId;			// 채팅방 ID
	private String message;			// 메세지

	public String getRoomUri() {
		return "/subscribe/rooms/" + roomId;
	}
}
