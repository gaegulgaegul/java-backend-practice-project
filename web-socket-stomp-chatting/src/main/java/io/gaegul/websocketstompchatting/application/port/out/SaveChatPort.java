package io.gaegul.websocketstompchatting.application.port.out;

import io.gaegul.websocketstompchatting.domain.Chat;

/**
 * 채팅 저장 포트
 */
public interface SaveChatPort {

	/**
	 * 채팅 저장
	 * @param chat
	 */
	void saveChat(Chat chat);
}
