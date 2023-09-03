package io.gaegul.websocketstompchatting.application.port.in;

/**
 * 메세지 전달 유스케이스
 */
public interface SendMessageUseCase {

	/**
	 * 메세지 전달
	 * @param request
	 */
	void sendMessage(ChatRequest request);
}
