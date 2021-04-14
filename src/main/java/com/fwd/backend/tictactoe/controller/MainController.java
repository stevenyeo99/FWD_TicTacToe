package com.fwd.backend.tictactoe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fwd.backend.tictactoe.entity.Game;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String initializeFirstPage(Model model) {
		Game game = new Game();
		
		model.addAttribute("game", game);
		
		return "index";
	}
	
	@PostMapping("/startGame")
	public String startGame(@ModelAttribute("game") Game game, RedirectAttributes redirectAttributes) {
		
		redirectAttributes.addFlashAttribute("game", game);
		
		return "redirect:TicTacToe";
	}
}
