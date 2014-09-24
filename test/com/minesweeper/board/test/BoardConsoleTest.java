package com.minesweeper.board.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.minesweeper.board.BoardConsole;
import com.minesweeper.board.Box;

public class BoardConsoleTest {
	
	static String HARD="HARD";
	static BoardConsole board;
	
	
	@BeforeClass
	public static void init(){
		board=new BoardConsole(HARD);
	}
	
	
	//pruebo si asigne la cantidad de minas que quiero segun la dificultad esperada
	@Test
	public void initializeTest(){
		int quantity=30;
		board.initialize(HARD);
		assertEquals("son iguales",board.getQuantity(), quantity);
	}
	
	
	
	//pruebo si efectivamente pone 30 minas como quiero
	@Test
	public void putMinesTest(){
		
		board.putMines();
		int count=0;
		Box[][] boxes = board.getBoxes();
		for (int i = 0; i < boxes.length; i++) {
			for (int j = 0; j < boxes.length; j++) {				
				if (boxes[i][j].getMine()==true){
					count+=1;
				}
			}
		}
		assertEquals(30, count);
		
	}
	
	
	
	
	
	

}
