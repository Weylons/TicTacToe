package ticTacToe;

public enum Pawns {
	eX('X'),
	eO('O');
	
	char mValue;
	
	private Pawns(char pValue){
		mValue = pValue;
	}
	
	static char getValue(int pIndex) {
		return Pawns.values()[pIndex].mValue;
	}
}
