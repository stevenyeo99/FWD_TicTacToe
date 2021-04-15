package com.fwd.backend.tictactoe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fwd.backend.tictactoe.entity.Game;
import com.fwd.backend.tictactoe.interfaces.IGameProcess;

@Controller
@SessionAttributes("game")
public class GameController {
	
	@Autowired
	private IGameProcess ticTacToeRulesImpl;
	
	@RequestMapping("/ticTacToe")
	public String displayForm(@ModelAttribute("game") Game game) {
		
		if (game.getStatusType() == null) {
			game.initializeGame();
		}
		
		return "tic_tac_toe";
	}
	
	@RequestMapping("/quitGame")
	public String quickGame() {
		return "redirect:/";
	}
	
	@RequestMapping("/rematch")
	public String rematch(@ModelAttribute("game") Game game) {
		
		game.rematchGame();
		
		return "redirect:/ticTacToe";
	}
	
	@RequestMapping("/ticTacToe/markSquare")
	public @ResponseBody ResponseEntity<Game> markSquare(@ModelAttribute("game") Game game, @RequestParam(required = true) int x, @RequestParam(required = true) int y) {
		
		if (game.getBoard().checkSquareIsMarkedByPosition(x, y)) {
			return ResponseEntity.badRequest().body(game);
		} else {
			ticTacToeRulesImpl.processingGame(game, x, y);
		}
		
		return ResponseEntity.ok(game);
	}
}
