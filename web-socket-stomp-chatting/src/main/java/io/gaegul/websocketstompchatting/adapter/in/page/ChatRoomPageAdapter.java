package io.gaegul.websocketstompchatting.adapter.in.page;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.RequiredArgsConstructor;

/**
 * 채팅방 페이지 어댑터
 */
@Controller
@RequiredArgsConstructor
class ChatRoomPageAdapter {
	private final AtomicInteger seq = new AtomicInteger(0);

	/**
	 * 채팅방 목록 페이지 전달
	 * @return
	 */
	@GetMapping("/chat/rooms")
	String rooms() {
		return "/chat/room-list";
	}

	/**
	 * 채팅장 페이지 전달
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/chat/rooms/{id}")
	String room(@PathVariable String id, Model model) {
		model.addAttribute("roomId", id);
		model.addAttribute("member", "member" + seq.incrementAndGet());
		return "/chat/room";
	}
}
