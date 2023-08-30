package io.gaegul.websocketstompchatting.application.port.out;

/**
 * 메세지 전달 포트
 */
public interface SendMessagePort {

	/**
	 * 메세지 전달
	 * @param uri
	 * @param message
	 */
	void sendMessage(String uri, String message);
}
