package view;

import model.Pawns;

public enum Texts {
	eLine("Choisissez une colonne"),
	eCol("Choisissez une ligne"),
	eTurn("Tour du joueur"),
	eWin("Victoire du joueur "),
	eError("Valeur erroné");
	
	public String mValue;
	
	private Texts(String pValue){
		mValue = pValue;
	}
}
