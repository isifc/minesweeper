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
	private Scanner in;
	private String difficulty;
	private IBoard board;
	
	public void menu(){
		in= new Scanner(System.in);
		menuOfOptions();
		
		 try {	         
             
             int option = in.nextInt();
             
             if (option > 0  && option < 4 ){
            	 board= new BoardConsole(initialize(option));
            	 board.show();
                 play();
             } else{
          	   System.out.println("ingresa un numero del 1 al 3");
             }
             
   		} catch (InputMismatchException e) {
   			System.out.print("ingresa un numero cabezón.\nAhora tenes que arrancar el juego de nuevo -_-");
   		} 	
	}
	
	public static void menuOfOptions(){
		System.out.print("              Seleccione La dificultad (1,2 o 3)          ");
        System.out.print("\n");
        System.out.print("1] Easy   (10 minas)\n");
        System.out.print("2] Medium (20 minas)\n");
        System.out.print("3] Hard   (30 minas)");
        System.out.print("\n");
        System.out.print("opcion: ");
	}
	
	@Override
	public void play(){
		boolean bandera=true;
		while (bandera) {			
			try {
				in= new Scanner(System.in);
		        System.out.print("ingrese una columna: ");
		        int column = in.nextInt();
		        System.out.print("ingrese una fila: ");
		        int row = in.nextInt(); 		       	
				bandera= board.BoxDiscovered(row ,column );				
			} catch (IndexOutOfBoundsException e) {				
				System.out.print("ingreso invalido,numeros válidos del 1 al 9  \n");
			}catch(InputMismatchException e){
				System.out.print("ingreso invalido,solo ingrese números enteros por favor...  \n");
			}
			
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

	@Override
	public String initialize(int difficulty) {	
		
		if (difficulty==1){
			this.difficulty=EASY;
		}else if (difficulty==2){
			this.difficulty=MEDIUM;
		}else{
			this.difficulty=HARD;
		}		
		return this.difficulty;			
	}	
}
