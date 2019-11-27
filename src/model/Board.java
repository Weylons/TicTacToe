package model;

public class Board {
	private char[][] mGrid;

	Board(int pSizeX,int pSizeY){
		mGrid = new char[pSizeY][pSizeX];
	}
	
	char[][] getmGrid(){
		return mGrid;
	}
}
