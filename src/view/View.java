package view;
import java.awt.GridLayout;
import controller.Controller;
import model.Player;

import java.util.Scanner;

import controller.Controller;


public class View {
	Scanner mScan = new Scanner(System.in);
	Window mWindow;
	Controller mController;

	public View(Controller pController) {
		mWindow = new Window(this);
		mController = pController;
	}
	public void print(String pSentence) {
		System.out.println(pSentence);
	}

	public String getInt(String pSentence) {

		print(pSentence);
		String mValue = mScan.nextLine();
		return mValue;
	}

	public void displayBoard(char pValue) {
		System.out.print(pValue);
	}

	public void createButton(int pY, int pX) {
		mWindow.setLayout(new GridLayout(pY, pX));
		for(int i = 1; i <= pY*pX; i++) {
			mWindow.createButton(i);
		}
	}
	
	public void setBegin(Player pCurrent) {
		mWindow.setCurrent(pCurrent);
		}

	public void setEnd() {
		mWindow.repaint();
	}
	
	public void sendValue(int pNum) {
		mController.getTranslateAndPlay(pNum, mWindow.mCurrent);
	}
	
	public void changeButtonValue(int[] pValues, Player pCurrent) {
		mWindow.setCurrent(pCurrent);
		Button button = mWindow.getButtons().get(pValues[0]*3 + pValues[1]);
		button.setTextButton(String.valueOf(mWindow.getCurrentPawn()));
		button.notEmpty();
	}
}
