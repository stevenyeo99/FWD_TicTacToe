package com.fwd.backend.tictactoe.abstraction;

import java.util.ArrayList;
import java.util.List;

import com.fwd.backend.tictactoe.entity.Player;
import com.fwd.backend.tictactoe.enums.StatusType;

public abstract class AbstractGame {
	
	private List<Player> listOfPlayers = new ArrayList<Player>();
	private StatusType statusType;
	
	public abstract void initializeGame();
	public abstract void defineGameStatus();
	public abstract void changePlayerTurn();
	public abstract boolean checkIsGameDraw();
	public abstract boolean checkIsGameWin();
	public abstract void rematchGame();
	
	public List<Player> getListOfPlayers() {
		return listOfPlayers;
	}

	public void setListOfPlayers(List<Player> listOfPlayers) {
		this.listOfPlayers = listOfPlayers;
	}

	public StatusType getStatusType() {
		return statusType;
	}

	public void setStatusType(StatusType statusType) {
		this.statusType = statusType;
	}
}
