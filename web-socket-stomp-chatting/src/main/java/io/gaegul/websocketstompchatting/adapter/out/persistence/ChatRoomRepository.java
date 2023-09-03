package io.gaegul.websocketstompchatting.adapter.out.persistence;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

/**
 * 채팅방 저장소
 */
@Repository
public class ChatRoomRepository {
	private final Map<String, ChatRoomEntity> chatRoomMap = new HashMap<>();

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
	public Optional<ChatRoomEntity> findById(String id) {
		ChatRoomEntity entity = chatRoomMap.get(id);
		if (entity == null) {
			return Optional.empty();
		}
		return Optional.of(entity);
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
