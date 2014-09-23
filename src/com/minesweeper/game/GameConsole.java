package com.minesweeper.game;

import java.sql.Time;
import java.util.IllegalFormatException;
import java.util.InputMismatchException;
import java.util.Scanner;


import com.minesweeper.board.BoardConsole;
import com.minesweeper.board.IBoard;

public class GameConsole implements IGame{
	
	private static final String EASY="EASY";
	private static final String MEDIUM="MEDIUM";
	private static final String HARD="HARD";
	private String nickname;
	private Time time;
	private String difficulty;
	private IBoard board;
	
	public GameConsole(String nickname,int difficulty){
		
			
		initialize(nickname,difficulty);	
		
		board= new BoardConsole(this.difficulty);		
		board.show();
		play();	
	}
	
	public void play(){
		boolean bandera=true;
		while (bandera) {			
			try {
				Scanner in= new Scanner(System.in);
		        System.out.print("ingrese una columna: ");
		        int column = in.nextInt();
		        System.out.print("ingrese una fila: ");
		        int row = in.nextInt(); 		       	
				bandera= board.BoxDiscovered(column, row);				
			} catch (IndexOutOfBoundsException e) {				
				System.out.print("ingreso invalido,numeros válidos del 0 al 8  \n");
			}catch(InputMismatchException e){
				System.out.print("ingreso invalido,solo ingrese números enteros por favor...  \n");
			}
			
			board.show();
					
		}	    
		System.out.print("pelotudo le pegaste a una mina\n");
		board.showMines();
		board.show();
	}

	@Override
	public void initialize(String nickname,int difficulty) {
		
		this.nickname=nickname;
		
		if (difficulty==1){
			this.difficulty=EASY;
		}else if (difficulty==2){
			this.difficulty=MEDIUM;
		}else{
			this.difficulty=HARD;
		}
	
					
	}	
}
