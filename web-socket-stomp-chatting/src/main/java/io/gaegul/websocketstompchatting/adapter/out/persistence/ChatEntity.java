package io.gaegul.websocketstompchatting.adapter.out.persistence;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 채팅 저장소
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
public class ChatEntity {
	private Long id;			// ID
	private String sender;		// 송신자 ID
	private String roomId;		// 채팅방 ID
	private String message;		// 메세지
}
