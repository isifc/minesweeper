package com.minesweeper;


import java.util.InputMismatchException;
import java.util.Scanner;

import com.minesweeper.game.IGame;
import com.minesweeper.game.GameConsole;

public class Main {
	
	public String nickname;
	private boolean bandera=true;
	
	
	public static void main(String[] args) {
		
		Scanner in= new Scanner(System.in);
        System.out.print("              Bienvenido al Buscaminas           ");
        System.out.print("\n");
        System.out.print("\n");
        System.out.print("Ingrese su nombre: ");
        String nickname = in.next();
        
        menuOfOptions();  
        
          try {	         
                
               int difficulty = in.nextInt();
               
               if (difficulty < 4 && difficulty > 0 ){
            	   IGame game= new GameConsole(nickname,difficulty);
                   game.play();
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
	

}
