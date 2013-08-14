package br.com.tagview.wiki;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WikiController {
	
	@RequestMapping("/")
	public String list(Model model) {
		model.addAttribute("message", "hai lol!");
		return "listTodos";
	}
}
