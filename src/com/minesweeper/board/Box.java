package com.minesweeper.board;

public class Box {
	
	
	private int MinesNear;
	private Boolean mine;
	private Boolean showing;	
	public Box(){
		
	}

	public Boolean getMine() {
		return mine;
	}
	public void setMine(Boolean mine) {
		this.mine = mine;
	}
	public Boolean getShowing() {
		return showing;
	}
	public void setShowing(Boolean showing) {
		this.showing = showing;
	}
	
	
}