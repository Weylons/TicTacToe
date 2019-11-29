package model;

public class Board {
	private char[][] mGrid;
	private int[] mSize;
	Board(int pSizeX,int pSizeY){
		mGrid = new char[pSizeY][pSizeX];
		mSize = new int[2];
		mSize[0] = pSizeY;
		mSize[1] = pSizeX;
	}
	
	char[][] getGrid(){
		return mGrid;
	}
	
	public int[] getmSize() {
		return mSize;
	}
	
	
}
