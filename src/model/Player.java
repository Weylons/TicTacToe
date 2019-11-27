package model;

public abstract class Player {
	private int mNumber;
	private char mPawn;
	
	Player(int pNumber){ 
		mPawn = Pawns.getValue(pNumber);
		mNumber = ++pNumber;
	}

	public int getmNumber() {
		return mNumber;
	}
	
	public char getPawn() {
		return mPawn;
	}
}
