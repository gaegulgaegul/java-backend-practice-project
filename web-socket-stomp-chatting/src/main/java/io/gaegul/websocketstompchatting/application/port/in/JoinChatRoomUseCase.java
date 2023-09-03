package io.gaegul.websocketstompchatting.application.port.in;

/**
 * 채팅방 입장 유스케이스
 */
public interface JoinChatRoomUseCase {

	void join(JoinRequest request);
}
