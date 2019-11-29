package view;

public enum Texts {
	eLine("Choisissez une colonne"),
	eCol("Choisissez une ligne"),
	eTurn("Tour du joueur"),
	eWin("Victoire du joueur "),
	eDraw("Match nul"),
	eError("Valeur erroné");
	
	public String mValue;
	
	private Texts(String pValue){
		mValue = pValue;
	}
}
