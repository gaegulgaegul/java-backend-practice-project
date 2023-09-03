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
	private String sender;		// 송신자
	private String roomId;		// 채팅방 ID
	private String message;		// 메세지

	public static Chat send(String senderId, String roomId, String message) {
		return new Chat(senderId, roomId, message);
	}

	public static Chat join(String senderId, String roomId) {
		return new Chat(senderId, roomId, senderId + "님이 입장하셨습니다.");
	}

	public String toJsonMessage() {
		return "{"
			+ "\"sender\": \"" + sender + "\","
			+ "\"message\": \"" + message + "\""
			+ "}";
	}
}
