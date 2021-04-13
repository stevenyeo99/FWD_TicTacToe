package com.fwd.backend.tictactoe.entity;

import com.fwd.backend.tictactoe.abstraction.AbstractBoard;

public class Board extends AbstractBoard {
	
	private static final String DEFAULT_VALUE = "-";
	
	// X-Y Coordinate
	private String[][] square;
	
	public Board() {
		
	}

	public String[][] getSquare() {
		return square;
	}

	public void setSquare(String[][] square) {
		this.square = square;
	}

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
}
