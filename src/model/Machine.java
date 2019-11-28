package model;

public class Machine extends Player{


	Machine(int pNbPlayer){
		super(pNbPlayer);
	}

	public int[] autoPlay(int[] pPreviousPlay, Board pBoard, int pMax, int pSizeX, int pSizeY) {
		char[][] grid = pBoard.getGrid();
		int[] result = new int[2];
		recalcValue(pBoard, pPreviousPlay[0], pPreviousPlay[1], pMax, pPreviousPlay[0]-pMax, pPreviousPlay[1]-pMax);
		for(int i = 0; i<pSizeY; i++ ) {
			for(int j = 0; j<pSizeX; j++) {
				if(pBoard.getmFrameValue()[i][j] == -1) {
				}
				else {
					pBoard.setmFrameValue(i, j, testFrame(grid, i, j, pSizeX, pSizeY, pMax));
				}
			}
		}
		
		int[][] frameValue = pBoard.getmFrameValue();
		
		for(int i=0; i<frameValue.length; i++) {
			int test = 0;
			for(int j = 0; j < frameValue.length ; j++) {
				int current = frameValue[i][j];
					if(current > test) {
						test = current;
						result[0] = i;
						result[1] = j;
					}
			}
		}
		
		return result;
	}


	public int testFrame(char[][] pGrid, int pY, int pX, int pSizeX, int pSizeY, int pMax) {

		int horizontal = clockWork(pGrid, pY, pX, pSizeX, pMax*-1,pMax, 0, 0, 1 , 1, 3);
		int vertical = clockWork(pGrid, pX, pY, pSizeY, pMax*-1, pMax, 0, 0, 1  , 1, 3);
		
		if(horizontal>vertical) return horizontal;
		return vertical;
	}

	public int clockWork(char[][] pGrid, int pY, int pX, int pSize, int pCurrent, int pMax, int pAttack, int pDefense,int pCounter, int pSum, int pImportant) {
		if(pY + pCurrent >= 0 && pY+pCurrent < pSize) {
			if(pGrid[pY+pCurrent][pX] != '\u0000') {
				if(pGrid[pY+pCurrent][pX] == getPawn()) {
					pAttack += pSum;
					if(pAttack == pImportant) {
						return 1000;
					}
				}
				else 
				{
					pDefense +=pSum;
					if(pDefense == pImportant) {
						return 999;
					}
				}
				if(pCurrent<pMax) {
					if(pCurrent + 1 == 0) pCurrent++;
					if(pCounter > 2) pImportant*=2;
					pAttack = clockWork(pGrid, pY, pX, pSize, pCurrent+1,pMax, pAttack,pDefense, pCounter++,  pSum*2, pImportant);
				}
			}
		}
		if(pAttack > pDefense) return pAttack;
		return pDefense;
	}
	
	private void recalcValue(Board pBoard, int pCurrentX, int pCurrentY, int pMax, int pY, int pX) {
		int countdown = 1;
		for(int i = 1; i <= pMax && i > 0; i+=countdown) {
			
		}
	}

}
