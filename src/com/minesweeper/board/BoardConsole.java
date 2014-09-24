package com.minesweeper.board;

public class BoardConsole implements IBoard{
	private Box[][] boxes;
	private int quantity=0;
		
	public BoardConsole(String difficulty){		
		this.boxes = new Box[9][9];	
		initialize(difficulty);
		putMines();				
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
	public void initialize(String difficulty) {
			int a = 0;
			for (int i = 0; i < boxes.length; i++) {	
				for (int j = 0; j < boxes.length; j++) {
					boxes[i][j]= new Box();					
					boxes[i][j].setMine(false);
					boxes[i][j].setShowing(false);
				}	
		}
		if (difficulty == "EASY"){
			quantity= 10;	
		}else if(difficulty=="MEDIUM"){
			quantity=20;
		}else{
			quantity=30;
		}
		
	}
	
	@Override
	public void show(){
		for (int i = 0; i < boxes.length; i++) {
			
			for (int j = 0; j < boxes.length; j++) {
				if (boxes[i][j].getShowing()==true){
					if (boxes[i][j].getMine()==true){
						System.out.print(" | "+"X");
					}else{
						System.out.print(" | "+"0");
					}
				}else{
					System.out.print(" | "+" " );
				}				
			}
			System.out.print("\n------------------------------------\n");				
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
	
	@Override 
	public boolean BoxDiscovered(int column,int row){
		 if  (boxes[column][row].getShowing()==false){
			 boxes[column][row].setShowing(true);
		 }
		 
		 if (boxes[column][row].getMine()==true){
			 return false;
		 }else{
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
	public void minesNear() {
		// TODO Auto-generated method stub
		
	}



}
