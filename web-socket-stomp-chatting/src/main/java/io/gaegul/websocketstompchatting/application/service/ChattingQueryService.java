package io.gaegul.websocketstompchatting.application.service;

import org.springframework.stereotype.Service;

import io.gaegul.websocketstompchatting.application.port.in.ChatRequest;
import io.gaegul.websocketstompchatting.application.port.in.SendMessageUseCase;
import io.gaegul.websocketstompchatting.application.port.out.SaveChatPort;
import io.gaegul.websocketstompchatting.application.port.out.SendMessagePort;
import io.gaegul.websocketstompchatting.domain.Chat;
import lombok.RequiredArgsConstructor;

/**
 * 채팅 서비스
 */
@Service
@RequiredArgsConstructor
class ChattingQueryService implements SendMessageUseCase {
	private final SaveChatPort saveChatPort;
	private final SendMessagePort sendMessagePort;

	@Override
	public void sendMessage(ChatRequest request) {
		Chat chat = new Chat(
			request.getSenderId(),
			request.getReceiverId(),
			request.getRoomId(),
			request.getMessage()
		);
		saveChatPort.saveChat(chat);
		sendMessagePort.sendMessage(chat.getRoomUri(), chat.getMessage());
	}
}
