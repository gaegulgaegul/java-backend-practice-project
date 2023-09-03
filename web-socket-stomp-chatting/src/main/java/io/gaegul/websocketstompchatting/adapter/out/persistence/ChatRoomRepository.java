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

	/**
	 * 채팅방 목록 조회
	 * @return
	 */
	public Collection<ChatRoomEntity> findAll() {
		return chatRoomMap.values();
	}

	/**
	 * 채팅방 조회
	 * @param id
	 * @return
	 */
	public ChatRoomEntity findById(String id) {
		return chatRoomMap.get(id);
	}

	/**
	 * 채팅방 목록 저장
	 * @param list
	 */
	public void saveAll(Collection<ChatRoomEntity> list) {
		for (ChatRoomEntity entity : list) {
			this.chatRoomMap.put(entity.getId(), entity);
		}
	}
}
