package view;
import java.util.Scanner;

import controller.Controller;


public class View {
	Scanner mScan;
	
	public View() {
		mScan = new Scanner(System.in);
	}
	
	public void print(String pSentence) {
		System.out.println(pSentence);
	}
	
	public String getResponse(String pSentence) {
		System.out.println(pSentence);
		return mScan.nextLine();
	}
	
	public void displayBoard(char pValue) {
		System.out.print(pValue);
	}
	
}
