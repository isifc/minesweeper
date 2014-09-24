package com.minesweeper.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.minesweeper.board.BoardConsole;

public class BoardConsoleTest {
	


	@Test
	public void initializeTest(){
		int a;
		String HARD="HARD";
		BoardConsole board= new BoardConsole(HARD);
		a=board.initialize(HARD);
		assertEquals("son iguales",30, a);
	}
	
	/*@Test
	public void putMinesTest(){
		int quantity=30;
	
		
	}*/

}
