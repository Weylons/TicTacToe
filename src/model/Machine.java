package model;

import java.util.ArrayList;

public class Machine extends Player{


	Machine(int pNbPlayer, int[][] pFrameValue, Game pGame){
		super(pNbPlayer, pFrameValue, pGame);
	}	
	
	// Sélectionne une casen, met à jour son jeu et envoie le résultat
	public int[] autoPlay(ArrayList<Player> pPlayers, int[] pPreviousPlay, Board pBoard, int pMax, int pSizeX, int pSizeY) {
		char[][] grid = pBoard.getGrid();
		int[] result = getBestFrame(pPlayers);
		mGame.setAllFrames(pPlayers, result);
		mGame.setSelfFrame(this, result, pMax);
		return result;
	}
	
	// Récupère les coordonnées de la meilleure case à jouer.
	public int[] getBestFrame(ArrayList<Player> pPlayers) {
		ArrayList<int[]> xyResults = new ArrayList<int[]>();
		ArrayList<Integer> valResults = new ArrayList<Integer>();
		pPlayers.forEach((current) -> {
			xyResults.add(mGame.calcFrameValue(current.getFrameValue()));
			valResults.add(mGame.getBest(current.getFrameValue()));
		});
		return xyResults.get(mGame.returnIndexOfBest(valResults));
	}
}
