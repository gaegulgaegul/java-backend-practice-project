package io.gaegul.websocketstompchatting.application.port.out;

import java.util.List;

import io.gaegul.websocketstompchatting.domain.ChatRoom;

/**
 * 채팅방 조회 포트
 */
public interface GetChatRoomListPort {

	List<ChatRoom> getChatRooms();
}
