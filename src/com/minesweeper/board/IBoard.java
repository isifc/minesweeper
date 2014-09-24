package com.minesweeper.board;

public interface IBoard {
	
	public void initialize(String difficulty);	
	public void show();
	public void putMines();
	public boolean BoxDiscovered(int column, int row);
	public void showMines();
	public void minesNear();	

}
