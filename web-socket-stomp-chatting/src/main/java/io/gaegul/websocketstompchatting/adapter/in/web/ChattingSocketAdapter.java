package io.gaegul.websocketstompchatting.adapter.in.web;

import javax.validation.Valid;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.RestController;

import io.gaegul.websocketstompchatting.application.port.in.ChatRequest;
import io.gaegul.websocketstompchatting.application.port.in.SendMessageUseCase;
import lombok.RequiredArgsConstructor;

/**
 * 채팅 웹 소켓 어댑터
 */
@RestController
@RequiredArgsConstructor
class ChattingSocketAdapter {
	private final SendMessageUseCase sendMessageUseCase;

	/**
	 * 채팅 메세지 전달
	 * @param request
	 */
	@MessageMapping("/messages")
	public void chat(@Valid ChatRequest request) {
		sendMessageUseCase.sendMessage(request);
	}
}
