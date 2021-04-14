package com.fwd.backend.tictactoe.entity;

import com.fwd.backend.tictactoe.enums.PlayerType;

public class Player {
	
	private PlayerType playerType;
	private boolean isPlayerTurn;
	private int totalPoint;
	
	public Player(PlayerType playerType, boolean isPlayerTurn, int totalPoint) {
		this.playerType = playerType;
		this.isPlayerTurn = isPlayerTurn;
		this.totalPoint = totalPoint;
	}

	public PlayerType getPlayerType() {
		return playerType;
	}

	public void setPlayerType(PlayerType playerType) {
		this.playerType = playerType;
	}

	public boolean getIsPlayerTurn() {
		return isPlayerTurn;
	}

	public void setIsPlayerTurn(boolean isPlayerTurn) {
		this.isPlayerTurn = isPlayerTurn;
	}

	public int getTotalPoint() {
		return totalPoint;
	}

	public void setTotalPoint(int totalPoint) {
		this.totalPoint = totalPoint;
	}
}
