package com.minesweeper;

import com.minesweeper.game.GameConsole;
import com.minesweeper.game.IGame;

public class Main {
	
	public static void main(String[] args) {
		
		IGame conextion= FactoryGame.getTypeGame(args[0]);
		if (conextion instanceof GameConsole){
			((GameConsole) conextion).menu();
		}
		
	}	
	

}
