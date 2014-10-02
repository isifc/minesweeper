package com.minesweeper.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.minesweeper.FactoryGame;
import com.minesweeper.game.GameConsole;
import com.minesweeper.game.IGame;

public class FactoryGameTest {
	private IGame Game;
	private String type;
	
	@Before
	public void initConsole(){
		type="console";
	}

	@Test
	public void getTypeGameConsoleTest(){
		Game= FactoryGame.getTypeGame(type);
		assertTrue(Game instanceof GameConsole);
	}

	
	
}
