package model;

import java.util.ArrayList;

import controller.Controller;

public abstract class Game {
	protected ArrayList<Player> mPlayers;
	protected Board mBoard;
	private int mNbPlayer;
	protected int mTurn;
	private boolean mOver;
	private int mMaxTurn;
	private int mCurrentPlayer;
	private boolean mDraw;
	protected int mMax;
	protected Controller mController;

	protected Game(int pNbPlayer, int pSizeX, int pSizeY, boolean[] pMachines, Controller pController) {
		mBoard = new Board(pSizeX, pSizeY);
		mTurn = 1;
		mNbPlayer = pNbPlayer;
		mOver = false;
		mMaxTurn = pSizeX*pSizeY;
		mPlayers = new ArrayList<Player>();
		mController = pController;
		for(int i = 0; i < mNbPlayer; i++) {
			if(pMachines[i]) mPlayers.add(new Machine(i, initFrameValue(), this));
			else mPlayers.add(new Human(i, initFrameValue(), this));
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
	
	abstract public boolean checkAnswer(String pValue);
	
	public void playTurn(Player pCurrent, int[] pValues) {
		
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
	
	public ArrayList<Player> getPlayers() {
		return mPlayers;
	}
	
	public boolean itsADraw() {
		if(mTurn == (mBoard.getmSize()[0] * mBoard.getmSize()[1])+1){
			return true;
		}
		return false;
	}
	
	public int getTurn() {
		return mTurn;
	}
	
	
	abstract public int[][] initFrameValue();
	
	abstract public void setAllFrames(int[] pFrame);
	
	abstract public void setSelfFrame(Player pCurrent, int[] pFrame);
	
	abstract public int returnIndexOfBest(ArrayList<Integer> pValues);
	
	abstract public int[] calcFrameValue(int[][] pFrameValue);
	
	abstract public int getBest(int[][] pFrameValue);
	
	abstract public int[] translateValue(int pValue);
	
}
