package io.gaegul.websocketstompchatting.adapter.in.web;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.gaegul.websocketstompchatting.application.port.in.GetChatRoomUseCase;
import io.gaegul.websocketstompchatting.domain.ChatRoom;
import lombok.RequiredArgsConstructor;

/**
 * 채팅방 웹 어뎁터
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ChatRoomWebAdapter {
	private final GetChatRoomUseCase getChatRoomUseCase;

	/**
	 * 채팅방 목록 페이지 전달
	 * @return
	 */
	@GetMapping("/chat/rooms")
	ResponseEntity<List<ChatRoom>> rooms() {
		return ResponseEntity.ok(getChatRoomUseCase.getChatRooms());
	}

	/**
	 * 채팅장 페이지 전달
	 * @param roomId
	 * @return
	 */
	@GetMapping("/chat/rooms/{id}")
	ResponseEntity<ChatRoom> room(@PathVariable("id") String roomId) {
		return ResponseEntity.ok(getChatRoomUseCase.getChatRoom(roomId));
	}
}
