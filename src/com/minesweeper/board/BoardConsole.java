package com.minesweeper.board;

import java.util.InputMismatchException;



public class BoardConsole implements IBoard{
	private Box[][] boxes;
	private int quantity=0;
	private int count=81;
	private Difficulty dificulty;
		
	public BoardConsole(int difficulty){		
		this.boxes = new Box[9][9];	
		initialize(difficulty);
		putMines();
		countMines();
	}
	
	public Box[][] getBoxes() {
		return boxes;
	}

	public void setBoxes(Box[][] boxes) {
		this.boxes=boxes;
		
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public void initialize(int difficulty) {
		int a = 0;
		for (int i = 0; i < boxes.length; i++) {	
				for (int j = 0; j < boxes.length; j++) {
					boxes[i][j]= new Box();					
					
				}	
		}
		if (difficulty == 1){
			this.quantity= 10;
			this.dificulty=Difficulty.EASY;
		}else if(difficulty==2){
			this.quantity=20;
			this.dificulty=Difficulty.MEDIUM;
		}else{
			this.quantity=30;
			this.dificulty=Difficulty.HARD;
		}
		count-=quantity;
		
	}
	
	@Override
	public void show(){
		//numeros arriba del tablero
		System.out.print(" | 1   2   3   4   5   6   7   8   9");
		System.out.print("\n--------------------------------------\n");	
		for (int i = 0; i < boxes.length; i++) {
		
			for (int j = 0; j < boxes.length; j++) {
				//pongo los numeros al costado del tablero
				if (j==0){
					System.out.print(i+1);
				}
				if (j==8){
					if (boxes[i][j].getShowing()==true){
						if (boxes[i][j].getMine()==true){
							System.out.print("| "+"X "+"|");
						}else{
							System.out.print("| "+ boxes[i][j].getMinesNear()+"|");
						}
					}else{	
							System.out.print("| "+ "  "+"|" );
					}		
				}else{
					if (boxes[i][j].getShowing()==true){
						if (boxes[i][j].getMine()==true){
							System.out.print("| "+"X ");
						}else{
							System.out.print("| "+ boxes[i][j].getMinesNear()+" ");
						}
					}else{	
							System.out.print("| "+ "  " );
					}		
				}				
			}
			System.out.print("\n--------------------------------------\n");				
		}
	}
	
	@Override
	public void putMines(){
		 	
		 	while (quantity > 0) {
		 		int column=100;
			 	int row=100;
		 		while (column>8 || column <0 ) {
			 		column=(int)(Math.random()*10);
				}
		        while (row>8 || column <0 ) {
		        	 row=(int)(Math.random()*10);
				}
		        if(boxes[column][row].getMine()==false){
		           boxes[column][row].setMine(true);
		           quantity--;
		        }
		            
		        
			}
		 	
	        
	    }
	
	public void countMines(){
		
		for (int i = 0; i < this.boxes.length; i++) {
			for (int j = 0; j < this.boxes.length; j++) {
				this.boxes[i][j].setMinesNear(minesNear(i,j));
			}
		}
	}
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override 
	public boolean BoxDiscovered(int column,int row){
		 column--;
		 row--;	
		 //ver como meto la exception
		 try {
			 if  (boxes[column][row].getShowing()==false){
				 boxes[column][row].setShowing(true);
				 count--;
			 }
			 
			 if (boxes[column][row].getMine()==true){
				 return false;
			 }else{
				 return true;
			 }
		} catch (IndexOutOfBoundsException e) {				
			System.out.print("ingreso invalido,numeros válidos del 1 al 9  \n");
			return true;
		}catch(InputMismatchException e){
			System.out.print("ingreso invalido,solo ingrese números enteros por favor...  \n");
			 return true;
		}
		
		
	 }
	
	
	

	@Override
	public void showMines() {
		for (int i = 0; i < boxes.length; i++) {
			
			for (int j = 0; j < boxes.length; j++) {
				 if (boxes[i][j].getMine()==true){
					 boxes[i][j].setShowing(true);
				 }
			}
			
		}
		
	}

	@Override
	public int minesNear(int x,int y) {
		
		/*	
		 *	x Coordenada filas
		 *	y Coordenada columnas
		 *
		 *	numeroMinas: devuelve el número de minas de la posición
		 */
		 
        int quantityMines=0;
        for(int i=y-1;i<=y+1;i++){
        	//En horizontal
            if(i>-1 && i<8){
                if(this.boxes[x][i].getMine()==true){
             		quantityMines++;
                }
            }
        }
        //	En vertical
            for(int j=x-1;j<=x+1;j++){
                		if(j>-1 && j<8)
                			if(this.boxes[j][y].getMine()==true){
                			quantityMines++;
                			}
                	}
        //	En diagonal
        //	Posición de la esquina superior izquierda
        int x1=x;
        int y1=y;
        x1--;
        y1--;
        	for(int i=x1;i<x1+3;i++)
        		{
        			if(i>-1 && i<8 && y1>-1 && y1<8)
        			 if(this.boxes[i][y1].getMine()==true){
             		quantityMines++;
                	}
                	y1++;
        		}
        //	Posición de la esquina superior derecha
        x1=x;
        y1=y;
        x1--;
        y1++;
        	for(int i=x1;i<x1+3;i++)
        		{
        			if(i>-1 && i<8 && y1>-1 && y1<8)
        			 if(this.boxes[i][y1].getMine()==true){
             		quantityMines++;
                	}
                	y1--;
        		}
        return quantityMines;
}

	enum Difficulty{
		EASY,
		MEDIUM,
		HARD;
	}


}
