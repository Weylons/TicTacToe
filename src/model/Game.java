package ticTacToe;

import java.util.ArrayList;

public abstract class Game {
	private ArrayList<Player> mPlayers;
	private Board mBoard;
	private int mNbPlayer;
	private int mTurn;
	private boolean mOver;
	private int mMaxTurn;
	private int mCurrentPlayer;
	private boolean mDraw;

	protected Game(int pNbPlayer, int pSizeX, int pSizeY, boolean[] pMachines) {
		mBoard = new Board(pSizeX, pSizeY);
		mTurn = 1;
		mNbPlayer = 2;
		mOver = false;
		mMaxTurn = pSizeX*pSizeY;

		for(int i = 0; i < mNbPlayer; i++) {
			if(pMachines[i]) mPlayers.add(new Machine(i-1));
			else mPlayers.add(new Human(i-1));
		}
	}

	public boolean ismOver() {
		return mOver;
	}
	
	public void newTurn(Player pCurrent){
		
	}
	
	public Player calcTurn() {
		return mPlayers.get((mTurn + 1)% mNbPlayer);
	}

	public char[][] getBoard() {
		return mBoard.getmGrid();
	}
	
	
	






}
