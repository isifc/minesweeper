package com.minesweeper.game;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


import com.minesweeper.board.BoardDesktop;

public class GameDesktop extends JFrame implements IGame{
	
	private JMenuBar mnbMenuPrincipal;
	private JMenu mnbArchivo;
	private JMenuItem mnbEasy;
	private JMenuItem mnbMedium;
	private JMenuItem mnbHard;
	private JMenuItem mnbExit;

	private BoardDesktop board;
	
	public GameDesktop() {
		// TODO Auto-generated constructor stub
		setTitle("Buscaminas");
		setResizable(false);
		setSize(350,450);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		mnbMenuPrincipal = new JMenuBar();
		mnbMenuPrincipal.setVisible(true);
		mnbArchivo= new JMenu("Archivo");
		mnbEasy= new JMenuItem("Facil");
		mnbMedium= new JMenuItem("Medio");
		mnbHard= new JMenuItem("Dificil");
		mnbExit= new JMenuItem("Salir");
		mnbArchivo.add(mnbEasy);
		mnbArchivo.add(mnbMedium);
		mnbArchivo.add(mnbHard);
		mnbArchivo.add(mnbExit);
		mnbMenuPrincipal.add(mnbArchivo);
		setJMenuBar(mnbMenuPrincipal);
		
		board=new BoardDesktop();
		board.setVisible(true);
		board.setLocation(35, 50);
		add(board);
		
		
	}

	

	@Override
	public void play() {
		// TODO Auto-generated method stub
		
	}
	
	

}
