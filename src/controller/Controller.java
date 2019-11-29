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
		mView = new View();
	}

	public void newGame(GameTypes type) {
		switch(type) {
		case eTicTacToe:
			mGame = new TicTacToe(2, 3, 3, new boolean[] {false, true});
		}
		mValues = new int[mGame.nbValue()];
		mPreviousPlay = new int[2];
		gameManager();
	}

	public void newGame(GameTypes pType, int pNbPlayer, int pSizeX, int pSizeY, boolean[] pMachines) {
		switch(pType) {
		case eTicTacToe:
			mGame = new TicTacToe(pNbPlayer, pSizeX, pSizeY, pMachines);
		}
	}

	private void gameManager() {
		
		// Du moment que jeu n'est pas terminé
		while(!mGame.ismOver()) {
			Player current = mGame.calcTurn();
			mView.print(Texts.eTurn.mValue + current.getmNumber());
			boolean turnChecked = false;
			
			// Du moment que le tour n'est pas validé
			while(!turnChecked){

				// Est-ce que le joueur est humain ?
				if(mGame.isHuman(current)) {	
					for(int i = 0; i < mValues.length; i++) {
						String enter = mView.getInt(Texts.values()[i].mValue); 	
						if(!mGame.checkAnswer(enter, i)) {
							mView.print(Texts.eError.mValue);
							i--;
						}
						else {
							mValues[i] = Integer.parseInt(enter) - 1;
							
						}
					}	
				}
				
				// Sinon, c'est une machine
				else {
					Machine automate = (Machine) current;
					mValues = automate.autoPlay(mGame.getPlayers(), mPreviousPlay, mGame.getBoard(), mGame.getMax(), mGame.getBoard().getmSize()[0], mGame.getBoard().getmSize()[1]);	
				}
		
				// Si la case sélectionnée est déjà utilisée : erreur
				if(!mGame.playTurn(current, mValues)) {
					mView.print(Texts.eError.mValue);
				}
				else displayBoard();
				// Si le joueur vient de gagner
				if(mGame.didHeWin(current)){
					
					// Fin de la boucle
					mGame.setOver(true);
					turnChecked = true;
					// Affichage du joueur victorieux
					mView.print(Texts.eWin.mValue + current.getmNumber());
				}
				
				// Si c'est un match nul
				else if(mGame.itsADraw()) {
					mGame.setOver(true);
					turnChecked = true;
					mView.print(Texts.eDraw.mValue);
				}
				
				// Sinon, fin de tour
				else {
					mPreviousPlay = mValues;
					mGame.nextTurn();
					turnChecked = true;
				}
			}
			
		}
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
