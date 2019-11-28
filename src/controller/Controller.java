package controller;
import java.util.ArrayList;
import model.*;
import view.*;

public class Controller {
	Game mGame;
	View mView;
	int[] mValues;
	int[] mPreviousPlay;

	public Controller(){
		mView = new View();
	}

	public void newGame(GameTypes type) {
		switch(type) {
		case eTicTacToe:
			mGame = new TicTacToe(2, 3, 3, new boolean[] {false, false});
		}
		mValues = new int[mGame.nbValue()];
		gameManager();
	}

	public void newGame(GameTypes pType, int pNbPlayer, int pSizeX, int pSizeY, boolean[] pMachines) {
		switch(pType) {
		case eTicTacToe:
			mGame = new TicTacToe(pNbPlayer, pSizeX, pSizeY, pMachines);
		}
	}

	private void gameManager() {
		
		// Du moment que jeu n'est pas termin�
		while(!mGame.ismOver()) {
			Player current = mGame.calcTurn();
			boolean turnChecked = false;
			display(current);
			
			// Du moment que le tour n'est pas valid�
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
					mValues = automate.autoPlay(mPreviousPlay, mGame.getBoard(), mGame.getMax(), mGame.getBoard().getmSize()[0], mGame.getBoard().getmSize()[1]);	
				}
		
				// Si la case s�lectionn�e est d�j� utilis�e : erreur
				if(!mGame.playTurn(current, mValues)) {
					mView.print(Texts.eError.mValue);
				}
				
				// Si le joueur vient de gagner
				else if(mGame.didHeWin(current)){
					
					// Fin de la boucle
					mGame.setOver(true);
					turnChecked = true;
					// Affichage du joueur victorieux
					mView.print(Texts.eWin.mValue + current.getmNumber());
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

	private void display(Player pCurrent) {
		mView.print(Texts.eTurn.mValue + pCurrent.getmNumber());
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
