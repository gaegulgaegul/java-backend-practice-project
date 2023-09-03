package io.gaegul.websocketstompchatting.adapter.out.persistence;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * 채팅 정보 저장소
 */
@Repository
public class ChatRepository {
	private final List<ChatEntity> chats = new ArrayList<>();

	/**
	 * 채팅 정보 저장
	 * @param entity
	 * @return
	 */
	public ChatEntity save(final ChatEntity entity) {
		chats.add(entity);
		return entity;
	}

	/**
	 * 채팅 개수 반환
	 * @return
	 */
	public long count() {
		return chats.stream().count();
	}
}
