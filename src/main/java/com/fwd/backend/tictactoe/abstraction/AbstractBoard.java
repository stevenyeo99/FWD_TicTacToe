package com.fwd.backend.tictactoe.abstraction;

public abstract class AbstractBoard {
	
	public abstract void initializeBoard();
	public abstract void drawSquare(int x, int y, String mark);
	public abstract boolean checkRowPointDomination();
	public abstract boolean checkColPointDomination();
	public abstract boolean checkDiagonalPointDomination();
	public abstract boolean checkSquareIsFullMarked();
	public abstract int getTotalCountByMarkType(String mark);
	public abstract boolean checkSquareIsMarkedByPosition(int x, int y);
}
