package io.gaegul.websocketstompchatting.adapter.in.socket;

import javax.validation.Valid;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.RestController;

import io.gaegul.websocketstompchatting.application.port.in.ChatRequest;
import io.gaegul.websocketstompchatting.application.port.in.JoinChatRoomUseCase;
import io.gaegul.websocketstompchatting.application.port.in.JoinRequest;
import io.gaegul.websocketstompchatting.application.port.in.SendMessageUseCase;
import lombok.RequiredArgsConstructor;

/**
 * 채팅 웹 소켓 어댑터
 */
@RestController
@RequiredArgsConstructor
class ChatRoomSocketAdapter {
	private final SendMessageUseCase sendMessageUseCase;
	private final JoinChatRoomUseCase joinChatRoomUseCase;

	/**
	 * 채팅 메세지 전달
	 * @param request
	 */
	@MessageMapping("/chat/message")
	void chat(@Valid ChatRequest request) {
		sendMessageUseCase.sendMessage(request);
	}

	/**
	 * 채팅장 입장
	 * @param request
	 */
	@MessageMapping("/chat/join")
	void join(@Valid JoinRequest request) {
		joinChatRoomUseCase.join(request);
	}
}
