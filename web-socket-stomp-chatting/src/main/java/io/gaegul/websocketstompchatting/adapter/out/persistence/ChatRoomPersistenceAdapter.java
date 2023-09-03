package io.gaegul.websocketstompchatting.adapter.out.persistence;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import io.gaegul.websocketstompchatting.application.port.out.GetChatRoomPort;
import io.gaegul.websocketstompchatting.domain.ChatRoom;
import lombok.RequiredArgsConstructor;

/**
 * 채팅방 정보 관리 영속성 어댑터
 */
@Component
@RequiredArgsConstructor
class ChatRoomPersistenceAdapter implements GetChatRoomPort {
	private final ChatRoomRepository chatRoomRepository;

	@Override
	public List<ChatRoom> getChatRooms() {
		Collection<ChatRoomEntity> chatRooms = chatRoomRepository.findAll();
		if (chatRooms.isEmpty()) {
			return List.of();
		}
		return chatRooms.stream()
			.map(item -> toDomain(item))
			.collect(Collectors.toList());
	}

	@Override
	public ChatRoom getChatRoom(String id) {
		ChatRoomEntity entity = chatRoomRepository.findById(id)
			.orElseThrow(NoSuchElementException::new);
		return toDomain(entity);
	}

	/**
	 * 도메인 객체 매핑
	 * @param entity
	 * @return
	 */
	private ChatRoom toDomain(ChatRoomEntity entity) {
		return new ChatRoom(
			entity.getId(),
			entity.getName()
		);
	}
}
