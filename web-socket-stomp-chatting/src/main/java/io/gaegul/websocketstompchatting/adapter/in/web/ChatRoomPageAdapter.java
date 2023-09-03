package io.gaegul.websocketstompchatting.adapter.in.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import io.gaegul.websocketstompchatting.application.port.in.GetChatRoomUseCase;
import lombok.RequiredArgsConstructor;

/**
 * 채팅방 페이지 어댑터
 */
@Controller
@RequiredArgsConstructor
class ChatRoomPageAdapter {
	private final GetChatRoomUseCase getChatRoomUseCase;

	/**
	 * 채팅방 목록 페이지 전달
	 * @param model
	 * @return
	 */
	@GetMapping("/rooms")
	String rooms(Model model) {
		model.addAttribute("rooms", getChatRoomUseCase.getChatRooms());
		return "/chat/room-list";
	}
}
