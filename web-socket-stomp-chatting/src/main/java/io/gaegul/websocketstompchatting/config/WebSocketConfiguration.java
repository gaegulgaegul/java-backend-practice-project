package io.gaegul.websocketstompchatting.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * 메세지 브로커가 지원하는 WebSocket 설정
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		/* 해당 주소로 메세지를 전달 */
		registry.enableSimpleBroker("/subscribe");

		/* 클라이언트에서 서버로 전달하는 메세지에 붙이는 prefix 설정 */
		registry.setApplicationDestinationPrefixes("/publish");
	}

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		/* 웹 소켓 통신 endpoint 설정 */
		registry.addEndpoint("/ws-connection")
			.setAllowedOrigins("chrome-extension://ggnhohnkfcpcanfekomdkjffnfcjnjam")
			.withSockJS();
	}
}
