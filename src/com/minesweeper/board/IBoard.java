package com.minesweeper.board;

public interface IBoard {
	
	public int initialize(String difficulty);	
	public void show();
	public void putMines(int quantity);
	public boolean BoxDiscovered(int column, int row);
	public void showMines();
		

}
