package model;
import controller.Controller;

import java.util.ArrayList;

public class TicTacToe extends Game{

	
	public TicTacToe(int pNbPlayer, int pSizeX, int pSizeY, boolean[] pMachines) {
		super(2, pSizeX, pSizeY, pMachines);
		mMax = 2;
	}

	public TicTacToe(){ 
		this(2, 3, 3, new boolean[2]);
	}
	
	public int nbValue() {
		return 2;
	}
	
	public boolean playTurn(Player pCurrent, int[] pValues) {
		char[][] grid = getGrid();
		if(grid[pValues[0]][pValues[1]] != '\u0000') return false;	
		else grid[pValues[0]][pValues[1]] = pCurrent.getPawn();
//		mBoard.setmFrameValue(pValues[0],pValues[1],-1);
//		mBoard.displayFrameValue();
		return true;
	}

	public boolean didHeWin(Player pCurrent) {
		char[][] grid = getGrid();
		for(int i = 0; i<grid.length-mMax; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				if(grid[i][j] == pCurrent.getPawn() && grid[i][j] == grid[i+1][j] && grid[i+1][j] == grid[i+2][j]) 
					return true;
				else if(grid[j][i] == pCurrent.getPawn() && grid[j][i] == grid[j][i+1] && grid[j][i+1] == grid[j][i+2]) 
					return true;
				
				else if(j<grid.length-mMax) {
					if(grid[j][i] == pCurrent.getPawn() && grid[i][j] == grid[i+1][j+1] && grid[i+1][j+1] == grid[i+2][j+2]) 
						return true;
					else if(grid[mMax][j] == pCurrent.getPawn() && grid[mMax][j] == grid[mMax-1][j+1] && grid[mMax-1][j+1] == grid[mMax-2][j+2]) 
						return true;
				}
			}
		}
		return false;
	}
}
