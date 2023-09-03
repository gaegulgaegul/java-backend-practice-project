package io.gaegul.websocketstompchatting.adapter.in.web;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import io.gaegul.websocketstompchatting.application.port.in.GetChatRoomUseCase;
import lombok.RequiredArgsConstructor;

/**
 * 채팅방 페이지 어댑터
 */
@Controller
@RequiredArgsConstructor
class ChatRoomPageAdapter {
	private final GetChatRoomUseCase getChatRoomUseCase;
	private final AtomicInteger seq = new AtomicInteger(0);

	/**
	 * 채팅방 목록 페이지 전달
	 * @param model
	 * @return
	 */
	@GetMapping("/chat/rooms")
	String rooms(Model model) {
		model.addAttribute("rooms", getChatRoomUseCase.getChatRooms());
		return "/chat/room-list";
	}

	/**
	 * 채팅장 페이지 전달
	 * @param roomId
	 * @param model
	 * @return
	 */
	@GetMapping("/chat/rooms/{id}")
	String room(@PathVariable("id") String roomId, Model model) {
		model.addAttribute("room", getChatRoomUseCase.getChatRoom(roomId));
		model.addAttribute("member", "member" + seq.incrementAndGet());
		return "/chat/room";
	}
}
