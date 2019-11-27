package model;

public class Machine extends Player{


	Machine(int pNbPlayer){
		super(pNbPlayer);
	}

	public int[] autoPlay(Board pBoard, int pMax, int pSizeX, int pSizeY) {
		char[][] grid = pBoard.getGrid();
		int[] result = new int[2];
		for(int i = 0; i<pSizeX-pMax; i++ ) {
			for(int j = 0; j<pSizeY; j++) {
				if(grid[i][j] == '\u0000') {
					pBoard.setmFrameValue(i, j, testFrame(grid, i, j, pSizeX, pSizeY, pMax));
				}
				else pBoard.setmFrameValue(i, j, -1);
			}
		}
		int[][] frameValue = pBoard.getmFrameValue();
		for(int i=0; i<frameValue.length; i++) {
			for(int j = 0; j < frameValue.length ; j++) {
				int current = frameValue[i][j];
			}
		}
		
		return new int[2];
	}


	public int testFrame(char[][] pGrid, int pX, int pY, int pSizeX, int pSizeY, int pMax) {

		int horizontal = clockWork(pGrid, pX, pY, pSizeX, pMax*-1,pMax, 0, 0, 1 , 1, 3);
		int vertical = clockWork(pGrid, pY, pX, pSizeY, pMax*-1, pMax, 0, 0, 1  , 1, 3);
		System.out.println(horizontal);
		return 0;
	}

	public int clockWork(char[][] pGrid, int pX, int pY, int pSize, int pCurrent, int pMax, int pAttack, int pDefense,int pCounter, int pSum, int pImportant) {
		if(pX + pCurrent >= 0 && pX+pCurrent < pSize) {
			if(pGrid[pX+pCurrent][pY] != '\u0000') {
				if(pGrid[pX+pCurrent][pY] == getPawn()) {
					pAttack += pSum;
					if(pAttack == pImportant) {
						return 15;
					}
				}
				else 
				{
					pDefense +=pSum;
					if(pDefense == pImportant) {
						return 14;
					}
				}
				if(pCurrent<pMax) {
					if(pCurrent + 1 == 0) pCurrent++;
					pAttack = clockWork(pGrid, pX, pY, pSize, pCurrent+1,pMax, pAttack,pDefense, pCounter++,  pSum*2, pImportant*2);
				}
			}
		}
		
		return 0;
	}
}
