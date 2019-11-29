package model;

import java.util.ArrayList;

public abstract class Game {
	private ArrayList<Player> mPlayers;
	protected Board mBoard;
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
	
	abstract public boolean checkAnswer(String pValue, int i);
	
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
	
	public ArrayList<Player> getPlayers() {
		return mPlayers;
	}
	
	abstract public int[][] initFrameValue();
	
	abstract public void setAllFrames(ArrayList<Player > pPlayers, int[] pFrame);
	
	
	abstract public void setSelfFrame(Player pCurrent, int[] pFrame, int pMax);
	
	abstract public int returnIndexOfBest(ArrayList<Integer> pValues ) ;
	
	abstract public int[] calcFrameValue(int[][] pFrameValue);
	abstract public int getBest(int[][] pFrameValue);
	
	
	
}
