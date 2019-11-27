package model;

public class Board {
	private char[][] mGrid;
	private int[] mSize;
	private int[][] mFrameValue;
	Board(int pSizeX,int pSizeY){
		mGrid = new char[pSizeY][pSizeX];
		mSize = new int[2];
		mSize[0] = pSizeX;
		mSize[1] = pSizeY;
		mFrameValue = new int [pSizeX][pSizeY];
	}
	
	char[][] getGrid(){
		return mGrid;
	}
	
	public int[] getmSize() {
		return mSize;
	}
	
	public int[][] getmFrameValue() {
		return mFrameValue;
	}
	
	public void setmFrameValue(int pX, int pY, int pValue) {
		mFrameValue[pX][pY] = pValue;
	}
}
