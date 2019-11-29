package view;
import java.util.ArrayList;

import javax.swing.JFrame;

import model.Player;

public class Window extends JFrame {
	ArrayList<Button> mButtons;
	Player mCurrent;
	View mView;

	Window(View pView){
		mView = pView;
		mButtons = new ArrayList<Button>();
		this.setTitle("TicTacToe");
		this.setSize(300, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		//Ajout du bouton à notre content pane
		this.setVisible(true);
	}     

	void createButton(int pIndex){
		mButtons.add(new Button(this, pIndex, ""));
		this.setVisible(false);
		this.setVisible(true);
	}

	ArrayList<Button> getButtons(){
		return mButtons;
	}
	
	void setCurrent(Player pCurrent) {
		mCurrent = pCurrent;
	}
	
	void buttonGetClicked(int pIndex) {
		mView.sendValue(pIndex);
	}

	char getCurrentPawn() {
		return mCurrent.getPawn();
	}
	

}

