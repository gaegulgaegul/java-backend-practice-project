package io.gaegul.websocketstompchatting.application.port.out;

import java.util.List;

import io.gaegul.websocketstompchatting.domain.ChatRoom;

/**
 * 채팅방 조회 포트
 */
public interface GetChatRoomPort {

	/**
	 * 채팅방 목록 조회
	 * @return
	 */
	List<ChatRoom> getChatRooms();

	/**
	 * 채팅방 조회
	 * @param id
	 * @return
	 */
	ChatRoom getChatRoom(String id);
}
