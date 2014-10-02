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
	public static void initBoardConsoleTest(){
		board=new BoardConsole(3);
	}
	
	
	//pruebo si asigne la cantidad de minas que quiero segun la dificultad esperada
	@Test
	public void initializeTest(){
		
		board.initialize(3);
		assertEquals(board.getQuantity(), 30);
	}
	
	
	//pruebo si efectivamente pone 30 minas como quiero
	@Test
	public void putMinesTest(){
		board.initialize(3);
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
	
	
	@Test
	public void BoxDiscoveredTest(){
		
		Box[][] boxes=new Box[9][9];
		for (int i = 0; i < boxes.length; i++) {	
			for (int j = 0; j < boxes.length; j++) {
				boxes[i][j]= new Box();
				
			}	
		}
		boxes[2][2].setMine(true);
		board.setBoxes(boxes);
		assertEquals(false, board.BoxDiscovered(3,3));// si tiene mina retorna false, xq asi corto el while del juego. 
		
	}
	
	//voy a probar si lanza la excepcion que necesito

	@Test(expected=IndexOutOfBoundsException.class)
	public void BoxDiscoveredExceptionTest(){
		
		Box[][] boxes=new Box[9][9];
		for (int i = 0; i < boxes.length; i++) {	
			for (int j = 0; j < boxes.length; j++) {
				boxes[i][j]= new Box();
				
			}	
		}
		board.setBoxes(boxes);
		board.BoxDiscovered(50,200); 
		
	}
	
	
	
	//pruebo que cuente bien la cantidad de minas
	@Test 
	public void minesNearTest(){
		
		Box[][] boxes=new Box[9][9];
		for (int i = 0; i < boxes.length; i++) {	
			for (int j = 0; j < boxes.length; j++) {
				boxes[i][j]= new Box();
				
			}	
		}
		
		boxes[1][1].setMine(true);
		board.setBoxes(boxes);
		board.countMines();
		boxes[1][2].setMinesNear(1);
		boxes[2][2].setMinesNear(1);
		boxes[2][1].setMinesNear(1);
		assertEquals(boxes, board.getBoxes());
	}
	
	
	@Test
	public void countMinesTest(){
		Box[][] boxes=new Box[9][9];
		for (int i = 0; i < boxes.length; i++) {	
			for (int j = 0; j < boxes.length; j++) {
				if (i==0){
					boxes[i][j]= new Box(true,false);
				}else{
					boxes[i][j]= new Box();
				}		
			}	
		}
		
		board.setBoxes(boxes);
		
		for (int i = 0; i < boxes.length; i++) {
			if (i == 0 || i== 8){
				boxes[0][i].setMinesNear(1);
			}else{
				boxes[0][i].setMinesNear(2);
			}
			
		}
		board.countMines();
		assertEquals(boxes, board.getBoxes());
	}
	
	

	
	
	
	
	

}
