package view;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class Button extends JButton implements MouseListener{
	int mIndex;
	String mTitle;
	Window mWindow;
	boolean mEmpty = true;
	
	Button(Window pWindow,int pIndex, String pTitle){
		super(pTitle);
		mTitle = pTitle;
		mIndex = pIndex;
		pWindow.add(this);
		mWindow = pWindow;
		this.addMouseListener(this);
	}

	void setTextButton(String pText) {
		mTitle = pText;
		this.setText(mTitle);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(mEmpty) {
			notEmpty();
			this.setTextButton(String.valueOf(mWindow.getCurrentPawn()));
			mWindow.buttonGetClicked(mIndex);
		}
	}

	public void notEmpty() {
		mEmpty = false;
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
