package model;
import controller.Controller;

import java.util.ArrayList;

public class TicTacToe extends Game{

	
	public TicTacToe(int pNbPlayer, int pSizeX, int pSizeY, boolean[] pMachines) {
		super(2, pSizeX, pSizeY, pMachines);
	}

	public TicTacToe(){ 
		this(2, 3, 3, new boolean[2]);
	}
	
	








}
