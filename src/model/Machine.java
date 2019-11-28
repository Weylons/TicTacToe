package model;

import java.util.ArrayList;

public class Machine extends Player{


	Machine(int pNbPlayer, int[][] pFrameValue){
		super(pNbPlayer, pFrameValue);
	}	

	public int[] autoPlay(ArrayList<Player> pPlayers, int[] pPreviousPlay, Board pBoard, int pMax, int pSizeX, int pSizeY) {
		char[][] grid = pBoard.getGrid();
		int[] result = getBestFrame(pPlayers);
		setAllFrames(pPlayers, result);
		setSelfFrame(result, pMax);
		return result;
		
	}

	public int[] getBestFrame(ArrayList<Player> pPlayers) {
		ArrayList<int[]> xyResults = new ArrayList<int[]>();
		ArrayList<Integer> valResults = new ArrayList<Integer>();
		pPlayers.forEach((current) -> {
			xyResults.add(calcFrameValue(current.getFrameValue()));
			valResults.add(getBest(current.getFrameValue()));
		});
		return xyResults.get(returnIndexOfBest(valResults));
	}

	private int returnIndexOfBest(ArrayList<Integer> pValues ) {
		int max = 0;
		int result = 0;
		for(int i = 0; i<pValues.size(); i++) {
			if(pValues.get(i) > max) {
					result = i;
			}
		}
		return result;
	}

	private int[] calcFrameValue(int[][] pFrameValue) {
		int max = 0;
		int[] result = new int [2];
		for(int i = 0; i<mFrameValue.length; i++) {
			int[] currentY = mFrameValue[i];
			for(int j=0 ; j<mFrameValue[0].length; j++) {	
				if(currentY[j] > max) {
					result[0] = i;
					result[1] = j;
				}
			}
		}
		return result;
	}

	private int getBest(int[][] pFrameValue) {
		int max = 0;
		int result = 0;
		for(int i = 0; i<mFrameValue.length; i++) {
			int[] currentY = mFrameValue[i];
			for(int j=0 ; j<mFrameValue[0].length; j++) {	
				if(currentY[j] > max) {
					result = max;
				}
			}
		}
		return result;
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
