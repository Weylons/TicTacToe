package view;
import java.awt.GridLayout;
import controller.Controller;
import java.util.Scanner;

import controller.Controller;


public class View {
	Scanner mScan = new Scanner(System.in);
	Window mWindow;

	public View() {
		mWindow = new Window();
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
}
