package com.fwd.backend.tictactoe.entity;

import com.fwd.backend.tictactoe.abstraction.AbstractBoard;


public class Board extends AbstractBoard {
	
	// X-Y Coordinate
	private String[][] square;
	
	public Board() {
		
	}
	
	public Board(int dimension) {
		square = new String[dimension][dimension];
	}

	public String[][] getSquare() {
		return square;
	}

	public void setSquare(String[][] square) {
		this.square = square;
	}

	/******************************************************/
	/* IMPLEMENTATION of ABSTRACT CLASS */
	
	@Override
	public void initializeBoard() {
		int size = square.length;
		
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				square[x][y] = "";
			}
		}
	}

	@Override
	public void drawSquare(int x, int y, String mark) {
		square[x][y] = mark;
	}
	
	/**
	 * 
	 * Check row board is dominating
	 */
	@Override
	public boolean checkRowPointDomination() {
		boolean isDominate = false;
		
		int size = square.length;
		
		for (int x = 0; x < size; x++) {
			isDominate = true;
			
			for (int y = 0; y < (size - 1); y++) {
				if (square[x][0] == "" || (square[x][y] != square[x][y + 1])) {
					isDominate = false;
					break;
				}
			}
			
			if (isDominate) {
				break;
			}
		}
		
		return isDominate;
	}

	/**
	 * 
	 * Check col board is dominating
	 */
	@Override
	public boolean checkColPointDomination() {
		boolean isDominate = false;
		
		int size = square.length;
		
		for (int y = 0; y < size; y++) {
			isDominate = true;
			
			for (int x = 0; x < (size - 1); x++) {
				if (square[0][y] == "" || (square[x][y] != square[x + 1][y])) {
					isDominate = false;
					break;
				}
			}
			
			if (isDominate) {
				break;
			}
		}
		
		return isDominate;
	}

	@Override
	public boolean checkDiagonalPointDomination() {
		boolean isDominate = true;
		
		int size = square.length;
		
		for (int xy = 0; xy < (size - 1); xy++) {
			if ((square[0][0] == "") || (square[xy][xy] != square[xy + 1][xy + 1])) {
				isDominate = false;
			}
		}
		
		if (!isDominate) {
			isDominate = true;
			int index = 0;
			
			for (int xy = (size - 1); xy > 0; xy--) {
				if ((square[size - size][size - 1] == "") || (square[index][xy] != square[index + 1][xy - 1])) {
					isDominate = false;
				}
				index++;
			}
		}
		
		return isDominate;
	}

	/**
	 * Check square on board is fully marked or not
	 */
	@Override
	public boolean checkSquareIsFullMarked() {
		boolean isFullMarked = true;
		
		for (int x = 0; x < square.length; x++) {
			for (int y = 0; y < square[x].length; y++) {
				if (square[x][y] == "") {
					isFullMarked = false;
				}
			}
		}
		
		return isFullMarked;
	}

	@Override
	public int getTotalCountByMarkType(String mark) {
		int markCount = 0;
		
		for (int x = 0; x < square.length; x++) {
			for (int y = 0; y < square.length; y++) {
				if (square[x][y] == mark) {
					markCount++;
				}
			}
		}
		
		return markCount;
	}

	@Override
	public boolean checkSquareIsMarkedByPosition(int x, int y) {
		boolean isMarked = false;
		
		if (square[x][y] != null && square[x][y] != "") {
			isMarked = true;
		}
		
		return isMarked;
	}
}
