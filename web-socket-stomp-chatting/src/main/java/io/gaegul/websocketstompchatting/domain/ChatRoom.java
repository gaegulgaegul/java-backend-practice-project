package io.gaegul.websocketstompchatting.domain;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 채팅방 관리
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
public class ChatRoom {
	private String id;
	private String name;
	private Set<String> sessionIds;

	public static ChatRoom create(String name) {
		return new ChatRoom(
			UUID.randomUUID().toString(),
			name,
			new HashSet<>()
		);
	}
}
