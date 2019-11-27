package model;

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
	protected int mMax;

	protected Game(int pNbPlayer, int pSizeX, int pSizeY, boolean[] pMachines) {
		mBoard = new Board(pSizeX, pSizeY);
		mTurn = 1;
		mNbPlayer = 2;
		mOver = false;
		mMaxTurn = pSizeX*pSizeY;
		mPlayers = new ArrayList<Player>();

		for(int i = 0; i < mNbPlayer; i++) {
			if(pMachines[i]) mPlayers.add(new Machine(i));
			else mPlayers.add(new Human(i));
		}
	}

	public boolean ismOver() {
		return mOver;
	}
	
	public boolean isHuman(Player pCurrent){
		return pCurrent instanceof Human;
	}
	
	public Player calcTurn() {
		return mPlayers.get((mTurn + 1)% mNbPlayer);
	}

	public Board getBoard() {
		return mBoard;
	}
	
	public char[][] getGrid() {
		return mBoard.getGrid();
	}
	
	public int nbValue() {
		return 0;
	}
	
	public boolean checkAnswer(String pValue, int i) {
		int value;
		if(pValue.isEmpty()) return false;
		try {value = Integer.parseInt(pValue);}
		catch(Exception e) {return false;}
		if(value > mBoard.getmSize()[i]|| value <= 0) return false;
		return true;
	}
	
	public boolean playTurn(Player pCurrent, int[] pValues) {
		return true;
	}
	
	public void nextTurn() {
		mTurn++;
	}
	
	public boolean didHeWin(Player pCurrent) {
		return true;
	}
	
	public void setOver(boolean pValue) {
		mOver = pValue;
	}
	
	public int getMax() {
		return mMax;
	}
	






}
