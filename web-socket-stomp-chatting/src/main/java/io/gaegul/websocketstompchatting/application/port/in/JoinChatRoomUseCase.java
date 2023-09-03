package io.gaegul.websocketstompchatting.application.port.in;

/**
 * 채팅방 입장 유스케이스
 */
public interface JoinChatRoomUseCase {

	/**
	 * 채팅방 입장
	 * @param request
	 */
	void join(JoinRequest request);
}
