package io.gaegulgaegul.websocketchatting.adapter.in.view;

import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 채팅 화면 접근 entry api
 */
@Controller
class ChatViewAdapter {

	@GetMapping("/chat")
	String chat(Model model) {
		model.addAttribute("name", UUID.randomUUID().toString());
		return "chat";
	}
}
