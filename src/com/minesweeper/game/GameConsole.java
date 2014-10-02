package com.minesweeper.game;

import java.sql.Time;
import java.util.IllegalFormatException;
import java.util.InputMismatchException;
import java.util.Scanner;





import com.minesweeper.board.BoardConsole;
import com.minesweeper.board.IBoard;

public class GameConsole implements IGame{
	
	
	private Scanner in;
	private IBoard board;
	private int option;
	
	public void menu(){
		in= new Scanner(System.in);
		System.out.print("              Seleccione La dificultad (1,2 o 3)          ");
        System.out.print("\n");
        System.out.print("1] Easy   (10 minas)\n");
        System.out.print("2] Medium (20 minas)\n");
        System.out.print("3] Hard   (30 minas)");
        System.out.print("\n");
        System.out.print("opcion: ");   
        try {	         
        	option = in.nextInt();
            if (option > 0  && option < 4 ){
           	 //initialize(option);
           	 board= new BoardConsole(option);
           	 board.show();
             play();
            } else{
         	   System.out.println("ingresa un numero del 1 al 3");
            }    
  		} catch (InputMismatchException e) {
  			System.out.print("ingresa un numero cabez�n.\nAhora tenes que arrancar el juego de nuevo -_-");
  		} 	
	}
	
	
	
	@Override
	public void play(){
		boolean bandera=true;
		
		while (bandera) {			
			
			in= new Scanner(System.in);
		    System.out.print("ingrese una columna: ");
		    int column = in.nextInt();
		    System.out.print("ingrese una fila: ");
		    int row = in.nextInt(); 		       	
		    bandera= board.BoxDiscovered(row ,column );				
			board.show();
					
		}
		if (((BoardConsole) board).getCount()==0){
			System.out.print("Groso Ganaste \n");
		}else{
			System.out.print("pelotudo le pegaste a una mina\n");
		}
		
		board.showMines();
		board.show();
	}

	
}
