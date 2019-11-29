package view;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Window extends JFrame {
	ArrayList<Button> mButton;
	
	  Window(){
		mButton = new ArrayList<Button>();
	    this.setTitle("TicTacToe");
	    this.setSize(300, 150);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    //Ajout du bouton à notre content pane
	    this.setVisible(true);
	  }      
	  
	  void createButton(int pIndex){
		  mButton.add(new Button(this, pIndex));
		  this.setVisible(false);
		  this.setVisible(true);
	  }
	  
	  
	}

