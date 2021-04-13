package com.fwd.backend.tictactoe.entity;

import com.fwd.backend.tictactoe.abstraction.AbstractGame;
import com.fwd.backend.tictactoe.enums.StatusType;

public class Game extends AbstractGame {

	private Board board;
	
	private int dimensionNumber;
	
	public Game() {
		
	}

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
	
	/*************************************************************************/
							  /* IMPLEMENTATION */
	
	/**
	 * Implement Initialize Game
	 */
	@Override
	public void initializeGame() {
		
	}

	/**
	 * Get game status
	 */
	@Override
	public StatusType getGameStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * change player turn
	 */
	@Override
	public void changePlayerTurn() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * check is game draw
	 */
	@Override
	public boolean checkIsGameDraw() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * check is game win
	 */
	@Override
	public boolean checkIsGameWin() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * rematch the game
	 */
	@Override
	public void rematchGame() {
		// TODO Auto-generated method stub
		
	}
}
