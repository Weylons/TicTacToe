package model;

import java.util.ArrayList;

public abstract class Player {
	protected int mNumber;
	protected char mPawn;
	protected int[][] mFrameValue;
	
	Player(int pNumber, int[][] pFrameValue){ 
		mPawn = Pawns.getValue(pNumber);
		mNumber = ++pNumber;
		mFrameValue = pFrameValue;
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
	
	public void setAllFrames(ArrayList<Player > pPlayers, int[] pFrame) {
		pPlayers.forEach((current) -> current.mFrameValue[pFrame[0]][pFrame[1]] = -1);
	}
	
	public void setSelfFrame(int[] pFrame, int pMax) {
		int countdown = 1;
		int counter = pMax *-1;
		for(int i = 1 ; i<=pMax && i>0; i+= countdown) {
			setFrame(pFrame[1], (pFrame[0] + counter), i);
			setFrame((pFrame[1] + counter), pFrame[0], i);
			setFrame((pFrame[1] + counter), (pFrame[0] + counter), i);
			setFrame((pFrame[1] + counter*-1), (pFrame[0] + counter), i);
			
			if(i+1 > pMax) {
				countdown = -1;
			}
			counter ++;
		}
	}
	
	public void setFrame(int x, int y, int i) {
		if(mFrameValue.length > y && y >= 0 && mFrameValue[0].length > x && x >= 0 && mFrameValue[y][x] != -1) {
			mFrameValue[y][x] += 5*i;
		}
	}

	
	
}
