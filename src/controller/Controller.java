package controller;
import java.util.ArrayList;
import model.*;
import view.*;

public class Controller {
	Game mGame;
	View mView;
	int[] mValues;
	int[] mPreviousPlay = new int [] {-1,-1};

	public Controller(){
		mView = new View(this);
	}

	public void newGame(GameTypes type) {
		switch(type) {
		case eTicTacToe:
			mGame = new TicTacToe(2, 3, 3, new boolean[] {false, true}, this);
			mView.createButton(3,3);
		}
		mValues = new int[mGame.nbValue()];
		mPreviousPlay = new int[2];
		beginTurn();
	}

	public void newGame(GameTypes pType, int pNbPlayer, int pSizeX, int pSizeY, boolean[] pMachines) {
		switch(pType) {
		case eTicTacToe:
			mGame = new TicTacToe(pNbPlayer, pSizeX, pSizeY, pMachines, this);
		}
	}


	private void beginTurn() {
		Player current = mGame.calcTurn();
		mView.print(Texts.eTurn.mValue + current.getmNumber());

		// Est-ce que le joueur est humain ?
		if(mGame.isHuman(current)) {
			mView.setBegin(current);
		}

		// Sinon, c'est une machine
		else {
			Machine automate = (Machine) current;
			int[] values =  automate.autoPlay(mGame.getPlayers(),mGame.getBoard());
			mView.changeButtonValue(values, current);
			mGame.playTurn(current, values);	
		}
	}

	public void endTurn(Player pCurrent) {
		mView.setEnd();
		displayBoard();
		// Si le joueur actuel a gagné
		if(mGame.didHeWin(pCurrent)){
			mGame.setOver(true);
			// Affichage du joueur victorieux
			mView.print(Texts.eWin.mValue + pCurrent.getmNumber());
		}

		// Si c'est un match nul
		else if(mGame.itsADraw()) {
			mGame.setOver(true);
			mView.print(Texts.eDraw.mValue);
		}

		// Sinon, fin de tour
		else {
			beginTurn();
		}
	}

	public void getTranslateAndPlay(int pNum, Player pCurrent) {
		mGame.playTurn(pCurrent, mGame.translateValue(pNum));
	}

	private void displayBoard() {
		char[][] grid = mGame.getGrid();
		for(int i = 0; i < grid.length; i++) {
			for (int j = 0 ; j<grid[i].length; j++) {
				if(grid[i][j] == '\u0000' ) mView.displayBoard(' ');
				else mView.displayBoard(grid[i][j]);
			}
			mView.print("");
		}
	}

}
