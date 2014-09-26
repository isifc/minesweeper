package com.minesweeper.board;

import javax.swing.JButton;

public class Box extends JButton{
	
	
	private int MinesNear=0;
	private Boolean mine;
	private Boolean showing;	
	public Box(){
	
	}

	public int getMinesNear() {
		return MinesNear;
	}

	public void setMinesNear(int minesNear) {
		MinesNear = minesNear;
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