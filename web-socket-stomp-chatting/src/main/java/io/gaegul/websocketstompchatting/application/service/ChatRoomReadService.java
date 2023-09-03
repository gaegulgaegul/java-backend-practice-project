package io.gaegul.websocketstompchatting.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import io.gaegul.websocketstompchatting.application.port.in.GetChatRoomUseCase;
import io.gaegul.websocketstompchatting.domain.ChatRoom;
import lombok.RequiredArgsConstructor;

/**
 * 채팅방 조회 유스케이스 구현체
 */
@Service
@RequiredArgsConstructor
public class ChatRoomReadService implements GetChatRoomUseCase {

	@Override
	public List<ChatRoom> getChatRooms() {
		return null;
	}

	@Override
	public ChatRoom getChatRoom(String roomId) {
		return null;
	}
}
