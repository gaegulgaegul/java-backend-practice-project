package io.gaegulgaegul.websocketchatting.adapter.in.socket;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.slf4j.Slf4j;

/**
 * 채팅 메시지 전달 웹소켓
 */
@Slf4j
@Component
public class ChatSocketAdapter extends TextWebSocketHandler {

	private final List<WebSocketSession> sessions = new ArrayList<>();

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		/* 클라이언트가 보낸 메세지를 처리하는 메서드 */
		log.info("{} : {}", session.getId(), message.getPayload());

		for (WebSocketSession webSocketSession : sessions) {
			webSocketSession.sendMessage(message);
		}
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) {
		/* 클라이언트가 접속 시 호출되는 메서드 */
		sessions.add(session);
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
		/* 클라이언트가 접속 해제 시 호출되는 메서드 */
		sessions.remove(session);
	}
}
