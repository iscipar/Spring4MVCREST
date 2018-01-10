package api.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.domain.Message;

@RestController
public class MyRestController {

	@RequestMapping("/welcome")
	public String welcome() {
		return "Welcome to Spring4MVCREST Example.";
	}

	@RequestMapping("/hello/{player}")
	public Message message(@PathVariable String player) {
		Message msg = new Message(player, "Hello " + player);
		return msg;
	}
}