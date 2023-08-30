package io.gaegul.websocketstompchatting.adapter.out.broker;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import io.gaegul.websocketstompchatting.application.port.out.SendMessagePort;
import lombok.RequiredArgsConstructor;

/**
 * 채팅 전달 포트 메시지 브로커 어뎁터
 */
@Component
@RequiredArgsConstructor
class ChatMessageBrokerAdapter implements SendMessagePort {
	private final SimpMessagingTemplate simpMessagingTemplate;

	@Override
	public void sendMessage(String uri, String message) {
		simpMessagingTemplate.convertAndSend(uri, message);
	}
}
