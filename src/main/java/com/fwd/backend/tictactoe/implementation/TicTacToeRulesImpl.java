package com.fwd.backend.tictactoe.implementation;

import org.springframework.stereotype.Service;

import com.fwd.backend.tictactoe.entity.Board;
import com.fwd.backend.tictactoe.entity.Game;
import com.fwd.backend.tictactoe.enums.StatusType;
import com.fwd.backend.tictactoe.interfaces.IGameProcess;

@Service
public class TicTacToeRulesImpl implements IGameProcess {

	/**
	 * processing tig tag game
	 * 
	 * @param game
	 * @param x
	 * @param y
	 */
	public void processingGame(Game game, int x, int y) {
		
		// 1. draw the field base square selected.
		Board board = game.getBoard();
		board.drawSquare(x, y, game.getPlayerTurn().toString());
		
		// 2. count each player point
		game.countEachPlayerPoint();
		
		// 3. define game status
		game.defineGameStatus();
		
		// 4. change player turn if game still in progress
		if (game.getStatusType() == StatusType.PROGRESS) {
			game.changePlayerTurn();
		}
	}
}
