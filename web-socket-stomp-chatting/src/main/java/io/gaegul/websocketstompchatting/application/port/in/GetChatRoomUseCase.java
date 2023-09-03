package io.gaegul.websocketstompchatting.application.port.in;

import java.util.List;

import io.gaegul.websocketstompchatting.domain.ChatRoom;

/**
 * 채팅방 조회 유스케이스
 */
public interface GetChatRoomUseCase {

	/**
	 * 채팅방 목록 조회
	 * @return
	 */
	List<ChatRoom> getChatRooms();

	/**
	 * 채팅방 조회
	 * @param roomId
	 * @return
	 */
	ChatRoom getChatRoom(String roomId);
}
