package com.fwd.backend.tictactoe.entity;

import com.fwd.backend.tictactoe.abstraction.AbstractGame;
import com.fwd.backend.tictactoe.enums.PlayerType;
import com.fwd.backend.tictactoe.enums.StatusType;

public class Game extends AbstractGame {

	private Board board;
	private int dimensionNumber;
	private PlayerType playerTurn;

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public int getDimensionNumber() {
		return dimensionNumber;
	}

	public void setDimensionNumber(int dimensionNumber) {
		this.dimensionNumber = dimensionNumber;
	}
	
	public PlayerType getPlayerTurn() {
		return playerTurn;
	}

	public void setPlayerTurn(PlayerType playerTurn) {
		this.playerTurn = playerTurn;
	}
	
	/*************************************************************************/
							  /* PERSONAL METHOD */
	
	/**
	 * Count each player point
	 */
	public void countEachPlayerPoint() {
		for (Player player : this.getListOfPlayers()) {
			player.setTotalPoint((board.getTotalCountByMarkType(player.getPlayerType().toString())));
		}
	}
	
	
	/*************************************************************************/
						/* IMPLEMENTATION of ABSTRACT CLASS */
	
	/**
	 * Implement Initialize Game
	 */
	@Override
	public void initializeGame() {
		Board board = new Board(this.dimensionNumber);
		board.initializeBoard();
		this.board = board;
		this.playerTurn = PlayerType.X;
		
		// Player on game
		boolean firstPlayer = true;
		for (int i = 0; i < PlayerType.values().length; i++) {
			// if enhancement need to choose which user as player can put if statement during loop.
			this.getListOfPlayers().add(new Player(PlayerType.values()[i], firstPlayer, 0));
			firstPlayer = false;
		}
		
		// Game status
		this.setStatusType(StatusType.PROGRESS);
	}

	/**
	 * define game status
	 */
	@Override
	public void defineGameStatus() {
		
		StatusType status = StatusType.PROGRESS;
		
		if (checkIsGameWin()) {
			status = StatusType.WIN;
		} else if (checkIsGameDraw()) {
			status = StatusType.DRAW;
		}

		this.setStatusType(status);
	}

	/**
	 * change player turn
	 */
	@Override
	public void changePlayerTurn() {
		for (Player player : this.getListOfPlayers()) {
			if (player.getIsPlayerTurn()) {
				player.setIsPlayerTurn(false);
			} else {
				player.setIsPlayerTurn(true);
				
				playerTurn = player.getPlayerType();
			}
		}
	}

	/**
	 * check is game draw
	 */
	@Override
	public boolean checkIsGameDraw() {
		boolean isGameDraw = false;
		
		if (board.checkSquareIsFullMarked()) {
			isGameDraw = true;
		}
		
		return isGameDraw;
	}

	/**
	 * check is game win
	 */
	@Override
	public boolean checkIsGameWin() {
		boolean isGameWin = false;
		
		// check point is dominating row, col, diag
		if (board.checkRowPointDomination() || board.checkColPointDomination() || board.checkDiagonalPointDomination()) {
			isGameWin = true;
		}
		
		return isGameWin;
	}

	/**
	 * rematch the game
	 */
	@Override
	public void rematchGame() {
		this.setStatusType(null);
	}
}
