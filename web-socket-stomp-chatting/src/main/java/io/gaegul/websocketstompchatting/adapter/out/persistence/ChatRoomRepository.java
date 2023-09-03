package io.gaegul.websocketstompchatting.adapter.out.persistence;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.web.socket.WebSocketSession;

/**
 * 채팅방 저장소
 */
@Repository
public class ChatRoomRepository {
	private final Map<String, ChatRoomEntity> chatRoomMap = new HashMap<>();
	private final Map<String, WebSocketSession> sessionMap = new HashMap<>();

	public ChatRoomEntity getChatRoom(String id) {
		return chatRoomMap.get(id);
	}

	public Collection<ChatRoomEntity> getChatRooms() {
		return chatRoomMap.values();
	}
}
