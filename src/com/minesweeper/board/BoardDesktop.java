package com.minesweeper.board;




import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import com.minesweeper.board.BoardConsole.Difficulty;


public class BoardDesktop extends JPanel implements IBoard{
	private JLabel labelP;
	private Box[][] boxes;
	private int quantity=0;
	private int count=81;
	
	public BoardDesktop(){
		setVisible(true);
		boxes= new Box[9][9];
		setSize(360, 310);
		//labelP= new JLabel();
		//labelP.setBounds(15, 15, 40, 15);
		//labelP.setBounds(30, 50, 40, 40);
		//this.add(labelP);
		initialize(3);
		
	}

	@Override
	public void initialize(int difficulty) {
		// TODO Auto-generated method stub
		int a = 0;
		for (int i = 0; i < boxes.length; i++) {	
				for (int j = 0; j < boxes.length; j++) {
					boxes[i][j]= new Box();					
					boxes[i][j].setBounds(30*i, 30*j+40, 30, 30);
					boxes[i][j].setBackground(Color.orange);
					boxes[i][j].setVisible(true);
					this.add(boxes[i][j]);
				}	
		}
		if (difficulty ==1){
			quantity= 10;	
		}else if(difficulty==2){
			quantity=20;
		}else{
			quantity=30;
		}
		count-=quantity;
		
	}

	@Override
	public void putMines() {
		// TODO Auto-generated method stub
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
	public boolean BoxDiscovered(int column, int row) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void showMines() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int minesNear(int column, int row) {
		// TODO Auto-generated method stub
		return 0;
	}
	


}
