package io.gaegulgaegul.websocketchatting.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import io.gaegulgaegul.websocketchatting.adapter.in.socket.ChatSocketAdapter;
import lombok.RequiredArgsConstructor;

/**
 * 웹소켓 등록 설정
 */
@Configuration
@EnableWebSocket
@RequiredArgsConstructor
public class WebSocketConfiguration implements WebSocketConfigurer {

	private final ChatSocketAdapter chatSocketAdapter;

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		/*
		 * 1. chatSocketAdapter에 접근할 수 있는 웹소켓 endpoint는 /chat 이다.
		 * 2. 도메인이 다른 서버에서 접근할 수 있도록 모든 접근에 허용되도록 CORS 설정한다.
		 */
		registry.addHandler(chatSocketAdapter, "ws/chat")
			.setAllowedOriginPatterns("*");
	}
}
