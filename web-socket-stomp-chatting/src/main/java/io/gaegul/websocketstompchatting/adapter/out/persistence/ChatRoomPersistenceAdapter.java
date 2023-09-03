package io.gaegul.websocketstompchatting.adapter.out.persistence;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import io.gaegul.websocketstompchatting.application.port.out.GetChatRoomListPort;
import io.gaegul.websocketstompchatting.domain.ChatRoom;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
class ChatRoomPersistenceAdapter implements GetChatRoomListPort {
	private final ChatRoomRepository chatRoomRepository;

	@Override
	public List<ChatRoom> getChatRooms() {
		Collection<ChatRoomEntity> chatRooms = chatRoomRepository.getChatRooms();
		if (chatRooms.isEmpty()) {
			List.of();
		}
		return chatRooms.stream()
			.map(item -> new ChatRoom(
				item.getId(),
				item.getName(),
				item.getSessionIds()
			))
			.collect(Collectors.toList());
	}
}
