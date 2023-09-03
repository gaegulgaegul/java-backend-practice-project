package io.gaegul.websocketstompchatting;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import io.gaegul.websocketstompchatting.adapter.out.persistence.ChatRoomEntity;
import io.gaegul.websocketstompchatting.adapter.out.persistence.ChatRoomRepository;

/**
 * 초기 채팅방 생성
 */
@Component
public class InitChatRoom implements CommandLineRunner {

	@Autowired
	private ChatRoomRepository chatRoomRepository;

	@Override
	public void run(String... args) {
		List<ChatRoomEntity> chatRoomEntities = List.of(
			new ChatRoomEntity(UUID.randomUUID().toString(), "1번방"),
			new ChatRoomEntity(UUID.randomUUID().toString(), "2번방"),
			new ChatRoomEntity(UUID.randomUUID().toString(), "3번방")
		);
		chatRoomRepository.saveAll(chatRoomEntities);
	}
}
