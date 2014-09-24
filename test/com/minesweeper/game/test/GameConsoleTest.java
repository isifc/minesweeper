package com.minesweeper.game.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.minesweeper.game.GameConsole;

public class GameConsoleTest {
	static GameConsole gameConsole;
	static String nickname="facu";
	static int difficulty=3;

	@BeforeClass
	public static void initGameConsoleTest(){
		gameConsole= new GameConsole(nickname, difficulty);
	}
	
	
	@Test
	public void initializeTest(){
		assertEquals("HARD",gameConsole.initialize(nickname, difficulty));
		
	}

}
