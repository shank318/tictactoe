package com.hiver.tictactoe.models;


import com.hiver.tictactoe.Board;

public class Player {
	public Player(CellValue player_type) {
		this.player_type = player_type;
	}

	public CellValue getPlayer_type() {
		return player_type;
	}

	public void setPlayer_type(CellValue player_type) {
		this.player_type = player_type;
	}

	private CellValue player_type;

}