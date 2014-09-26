package com.minesweeper;



import com.minesweeper.game.GameConsole;
import com.minesweeper.game.GameDesktop;
import com.minesweeper.game.IGame;


public class FactoryGame {
	
public static IGame getTypeGame(String TipoJuego){
		
		
		if(TipoJuego.equalsIgnoreCase("console")){
			return new GameConsole();
			
		}else if (TipoJuego.equalsIgnoreCase("desktop")){
			System.out.print("entro");
			return new GameDesktop();
			
		}
		
		return new GameConsole();
		
}
				

}
