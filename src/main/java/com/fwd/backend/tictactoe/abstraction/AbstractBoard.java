package com.fwd.backend.tictactoe.abstraction;

public abstract class AbstractBoard {
	
	public abstract void initializeBoard();
	public abstract void drawSquare(int x, int y, String mark);
}
