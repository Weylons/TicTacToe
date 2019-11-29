package model;

import java.util.ArrayList;

public abstract class Player {
	protected int mNumber;
	protected char mPawn;
	protected int[][] mFrameValue;
	protected Game mGame;
	
	Player(int pNumber, int[][] pFrameValue, Game pGame){ 
		mPawn = Pawns.getValue(pNumber);
		mNumber = ++pNumber;
		mFrameValue = pFrameValue;
		mGame = pGame;
	}

	public int getmNumber() {
		return mNumber;
	}
	
	public char getPawn() {
		return mPawn;
	}
	
	public int[][] getFrameValue(){
		return mFrameValue;
	}
	
	public void setFrame(int x, int y, int i) {
		if(mFrameValue.length > y && y >= 0 && mFrameValue[0].length > x && x >= 0 && mFrameValue[y][x] != -1) {
			mFrameValue[y][x] += 5*i;
		}
	}
	
	public void displayFrameValue() {
		for(int i=0; i<mFrameValue.length; i++) {
			for(int j=0; j<mFrameValue[0].length; j++) {
				System.out.print(mFrameValue[i][j]);
				System.out.print("          ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	
}
