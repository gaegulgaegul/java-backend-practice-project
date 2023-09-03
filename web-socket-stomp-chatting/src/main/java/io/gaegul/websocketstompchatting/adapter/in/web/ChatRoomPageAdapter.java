package io.gaegul.websocketstompchatting.adapter.in.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import io.gaegul.websocketstompchatting.application.port.in.GetChatRoomUseCase;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
class ChatRoomPageAdapter {
	private final GetChatRoomUseCase getChatRoomUseCase;

	@GetMapping("/rooms")
	String rooms(Model model) {
		model.addAttribute("rooms", getChatRoomUseCase.getChatRooms());
		return "/chat/room-list";
	}
}
