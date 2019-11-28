package model;

public class Board {
	private char[][] mGrid;
	private int[] mSize;
	private int[][] mFrameValue;
	Board(int pSizeX,int pSizeY){
		mGrid = new char[pSizeY][pSizeX];
		mSize = new int[2];
		mSize[0] = pSizeY;
		mSize[1] = pSizeX;
		mFrameValue = new int [pSizeY][pSizeX];
		initFrameValue();
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
	
	public void setmFrameValue(int pY, int pX, int pValue) {
		mFrameValue[pY][pX] = pValue;
	}
	
	public void initFrameValue() {
		for(int i=0; i<mFrameValue.length; i++) {
			for(int j=0; j<mFrameValue[0].length; j++) {
				if((i == 0 || i == mFrameValue.length-1) && (j == 0 || j == mFrameValue[0].length-1)){
					setmFrameValue(i,j,10);
				}
				else if(i == (mFrameValue.length - 1) / 2 && j == (mFrameValue[0].length - 1) / 2) {
					setmFrameValue(i,j,5);
				}
			}
		}
	}
	
	public void displayFrameValue() {
		for(int i=0; i<mFrameValue.length; i++) {
			for(int j=0; j<mFrameValue[0].length; j++) {
				System.out.print(mFrameValue[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
}
