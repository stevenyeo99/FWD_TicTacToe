package com.fwd.backend.tictactoe.interfaces;

import com.fwd.backend.tictactoe.entity.Game;

public interface IGameProcess {
	
	void processingGame(Game game, int x, int y);
}
