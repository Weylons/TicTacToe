package view;
import java.util.Scanner;

import controller.Controller;


public class View {
	Scanner mScan = new Scanner(System.in);
	
	
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
	
}
