package com.minesweeper.board;

import javax.swing.JButton;

public class Box extends JButton{
	
	
	private int minesNear;
	private Boolean mine;
	private Boolean showing;	
	
	//constructor por defecto... 
	public Box(){//tengo que probar los constructores
		setMinesNear(0);
		setMine(false);
		setShowing(false);
	
	}
	
	public Box(Boolean mine, Boolean shwing){//tengo que probar los constructores
		setMinesNear(0);
		setMine(mine);
		setShowing(shwing);
	
	}
	

	public int getMinesNear() {
		return minesNear;
	}



	public void setMinesNear(int minesNear) {
		this.minesNear = minesNear;
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