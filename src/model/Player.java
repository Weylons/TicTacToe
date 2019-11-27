package ticTacToe;

public abstract class Player {
	private int mNumber;
	private char mPawn;
	
	Player(int pNumber){ 
		mPawn = Pawns.getValue(pNumber);
		mNumber = ++pNumber;
	}
	
	abstract void play();

	public int getmNumber() {
		return mNumber;
	}
}
