package io.gaegul.websocketstompchatting.adapter.out.persistence;

import org.springframework.stereotype.Component;

import io.gaegul.websocketstompchatting.application.port.out.SaveChatPort;
import io.gaegul.websocketstompchatting.domain.Chat;
import lombok.RequiredArgsConstructor;

/**
 * 채팅 정보 관리 영속성 어댑터
 */
@Component
@RequiredArgsConstructor
class ChatPersistenceAdapter implements SaveChatPort {
	private final ChatRepository chatRepository;

	@Override
	public void saveChat(Chat chat) {
		ChatEntity entity = new ChatEntity(
			Long.valueOf(chatRepository.count() + 1),
			chat.getSenderId(),
			chat.getReceiverId(),
			chat.getRoomId(),
			chat.getMessage()
		);
		chatRepository.save(entity);
	}
}
