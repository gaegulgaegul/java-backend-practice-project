package io.gaegul.websocketstompchatting.application.service;

import org.springframework.stereotype.Service;

import io.gaegul.websocketstompchatting.application.port.in.ChatRequest;
import io.gaegul.websocketstompchatting.application.port.in.JoinChatRoomUseCase;
import io.gaegul.websocketstompchatting.application.port.in.JoinRequest;
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
class ChattingQueryService implements SendMessageUseCase, JoinChatRoomUseCase {
	private final SaveChatPort saveChatPort;
	private final SendMessagePort sendMessagePort;

	@Override
	public void sendMessage(ChatRequest request) {
		Chat chat = Chat.send(
			request.getSenderId(),
			request.getRoomId(),
			request.getMessage()
		);
		saveChatPort.saveChat(chat);
		sendMessagePort.sendMessage(chat.getRoomUri(), chat.toJsonMessage());
	}

	@Override
	public void join(JoinRequest request) {
		Chat chat = Chat.join(
			request.getSenderId(),
			request.getRoomId()
		);
		sendMessagePort.sendMessage(chat.getRoomUri(), chat.toJsonMessage());
	}
}
