package com.minesweeper.board.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.minesweeper.board.Box;

public class BoxTest {
	
	private Box box,boxtest;
	
	
	@Test
	public void BoxTest(){
		box= new Box();
		assertTrue(box.getMinesNear()==0 && box.getMine()==false && box.getShowing()== false);	
	}


}
