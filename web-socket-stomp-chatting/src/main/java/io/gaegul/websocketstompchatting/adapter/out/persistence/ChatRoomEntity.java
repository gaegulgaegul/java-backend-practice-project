package io.gaegul.websocketstompchatting.adapter.out.persistence;

import java.util.HashSet;
import java.util.Set;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 채팅방 관리
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class ChatRoomEntity {
	private String id;
	private String name;
	private Set<String> sessionIds = new HashSet<>();
}
