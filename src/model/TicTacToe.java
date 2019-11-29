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

	public boolean checkAnswer(String pValue, int i) {
		int value;
		if(pValue.isEmpty()) return false;
		try {value = Integer.parseInt(pValue);}
		catch(Exception e) {return false;}
		if(value > mBoard.getmSize()[1]*mBoard.getmSize()[0]|| value <= 0) return false;
		return true;
	}

	public boolean playTurn(Player pCurrent, int[] pValues) {
		char[][] grid = getGrid();
		if(grid[pValues[0]][pValues[1]] != '\u0000') return false;	
		else grid[pValues[0]][pValues[1]] = pCurrent.getPawn();
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


	/* Valeures des cases pour chaque joueur */

	// Initialisation

	public int[][] initFrameValue() {
		int[][] frameValue = new int [mBoard.getmSize()[0]][mBoard.getmSize()[1]];
		for(int i=0; i<mBoard.getmSize()[0]; i++) {
			for(int j=0; j<mBoard.getmSize()[1]; j++) {
				if((i == 0 || i == mBoard.getmSize()[0]-1) && (j == 0 || j == mBoard.getmSize()[1]-1)){
					frameValue[i][j] = 10;
				}
				else if(i == (mBoard.getmSize()[0]-1) / 2 && j == (mBoard.getmSize()[1]-1) / 2) {
					frameValue[i][j] = 5;
				}
			}
		}
		return frameValue;
	}


	// Mise à jour à chaque tour 
	public void setAllFrames(ArrayList<Player > pPlayers, int[] pFrame) {
		pPlayers.forEach((current) -> current.mFrameValue[pFrame[0]][pFrame[1]] = -1);
	}

	// Modification des valeures personnelles après son tour
	public void setSelfFrame(Player pCurrent, int[] pFrame, int pMax) {
		int countdown = 1;
		int counter = pMax *-1;
		for(int i = 1 ; i<=pMax && i>0; i+= countdown) {
			pCurrent.setFrame(pFrame[1], (pFrame[0] + counter), i);
			pCurrent.setFrame((pFrame[1] + counter), pFrame[0], i);
			pCurrent.setFrame((pFrame[1] + counter), (pFrame[0] + counter), i);
			pCurrent.setFrame((pFrame[1] + counter*-1), (pFrame[0] + counter), i);

			if(i+1 > pMax) countdown = -1;
			counter ++;
		}

		// Calcul si une case peut être gagnante
		int calc = 1;
		for(int i = pMax*-1; i<=pMax; i++) {
			if(i!= 0 ) {
				calcWin(pCurrent, pFrame[0], (pFrame[1] + i), pFrame[0], (pFrame[1] + i + calc));
				calcWin(pCurrent, (pFrame[0] + i), pFrame[1], (pFrame[0] + i + calc), pFrame[1]);
				calcWin(pCurrent, (pFrame[0] + i), (pFrame[1] + i), (pFrame[0] + i + calc), (pFrame[1] + i + calc));
				calcWin(pCurrent, (pFrame[0] + i), (pFrame[1] + i*-1), (pFrame[0] + i + calc), (pFrame[1] + i*-1+ calc));
			}
			else {
				calcWin(pCurrent, pFrame[0], (pFrame[1] - calc), pFrame[0], (pFrame[1] + calc));
				calcWin(pCurrent, (pFrame[0] - calc), pFrame[1], (pFrame[0] +  calc), pFrame[1]);
				calcWin(pCurrent, (pFrame[0] + calc), (pFrame[1] + calc), (pFrame[0] - calc), (pFrame[1] - calc));
				calcWin(pCurrent, (pFrame[0] - calc), (pFrame[1] + calc), (pFrame[0] + calc), (pFrame[1] - calc));
				if(calc == 1) i--;
			}
			calc *=-1;
		}
	}

	// Si [Y1][X1] a été jouée par le joueur actuelle, et [Y2][X2] est vide, celle-ci est gagnante.
	private void calcWin(Player pPlayer, int pY1, int pX1, int pY2, int pX2) {
		char[][] grid = getGrid();
		if(0 <= pY1 && pY1 < grid.length && 0 <= pX1 && pX1 < grid[0].length && 0 <= pY2 && pY2 < grid.length && 0 <= pX2 && pX2 < grid[0].length ) {
			if(grid[pY1][pX1] == pPlayer.getPawn() && grid[pY2][pX2] ==  '\u0000' ) {
				pPlayer.setFrame(pX2, pY2, 1000);
			}
		}
	}





	// Concernant l'IA 



	// Calcule les coordonnées de la meilleure case de chaque grille de valeurs, tout joueur confondu.
	public int[] calcFrameValue(int[][] pFrameValue) {
		int max = 0;
		int[] result = new int [2];
		for(int i = 0; i<pFrameValue.length; i++) {
			int[] currentY = pFrameValue[i];
			for(int j=0 ; j<pFrameValue[0].length; j++) {	
				if(currentY[j] > max) {
					result[0] = i;
					result[1] = j;
				}
			}
		}
		return result;
	}

	// Calcule la valeur de la meilleure case de chaque grille de valeurs, tout joueur confondu.
	public int getBest(int[][] pFrameValue) {
		int max = 0;
		int result = 0;
		for(int i = 0; i<pFrameValue.length; i++) {
			int[] currentY = pFrameValue[i];
			for(int j=0 ; j<pFrameValue[0].length; j++) {	
				if(currentY[j] > max) {
					result = max;
				}
			}
		}
		return result;
	}

	// Récupère l'index de la meilleure grille de valeur.
	public int returnIndexOfBest(ArrayList<Integer> pValues ) {
		int max = 0;
		int result = 0;
		for(int i = 0; i<pValues.size(); i++) {
			if(pValues.get(i) > max) {
				result = i;
			}
		}
		return result;
	}
}
