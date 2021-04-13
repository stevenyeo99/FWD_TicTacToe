package com.fwd.backend.tictactoe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class GameController {
	
	@RequestMapping("/TicTacToe")
	public String displayForm() {
		return "tic_tac_toe";
	}
	
	@RequestMapping("/QuitGame")
	public String quickGame() {
		return "redirect:/";
	}
}
