package controller;
import ticTacToe.*;
import view.*;

public class Controller {
	Game mGame;
	View mView;
	
	Controller(){
		mView = new View();
	}
	public void newGame(GameTypes type) {
		switch(type) {
		case eTicTacToe:
			mGame = new TicTacToe();
		}
		gameManager();
	}

	public void newGame(GameTypes pType, int pNbPlayer, int pSizeX, int pSizeY, boolean[] pMachines) {
		switch(pType) {
		case eTicTacToe:
			mGame = new TicTacToe(pNbPlayer, pSizeX, pSizeY, pMachines);
		}
	}
	
	private void gameManager() {
		while(!mGame.ismOver()) {
			Player current = mGame.calcTurn();
			display(current);
			mGame.newTurn(current);
		}
	}
	
	private void display(Player pCurrent) {
		mView.print(Texts.eTurn.mValue + pCurrent.getmNumber());
		char[][] grid = mGame.getBoard();
		for(int i = 0; i < grid.length; i++) {
			for (int j = 0 ; j<grid[i].length; j++) {
				if(grid[i][j] == '\u0000' ) mView.displayBoard(' ');
				else mView.displayBoard(grid[i][j]);
			}
			mView.print("");
		}
	}
}
