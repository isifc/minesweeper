package com.minesweeper.board;


public interface IBoard {
	
	public void initialize(int difficulty);	
	public void show();
	public void putMines();
	public boolean BoxDiscovered(int column, int row) ;
	public void showMines();
	public int minesNear(int column,int row);
	

}
