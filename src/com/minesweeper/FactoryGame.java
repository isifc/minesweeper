package com.minesweeper;



import com.minesweeper.game.GameConsole;
import com.minesweeper.game.GameDesktop;
import com.minesweeper.game.IGame;
//debe tener un test

public class FactoryGame {
	
public static IGame getTypeGame(String TipoJuego){
		if(TipoJuego.equalsIgnoreCase("console")){
			return new GameConsole();
		}else if (TipoJuego.equalsIgnoreCase("desktop")){
			return new GameDesktop();
			
		}	
		return new GameConsole();
		
}
				

}
