package sg.edu.nus.iss.utility;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JButton;



public class BTSButton extends JButton {

    public BTSButton() {
        super();
    	
        setMargin(new Insets(2, 1, 2, 1));
    	setFont(new Font("Dialog",Font.BOLD,12));
    	setBackground(new Color(192,192,192));
    }
    
	/**
     * This method sets the passed text in the button. 
     * The letter following '&' symbol will be set as the Mnemonic for the button.
     */
	public void setText(String buttonText) {
		int iIndex = buttonText.indexOf('&');
		if(iIndex < 0 || iIndex == (buttonText.length() - 1)) { //if '&' is not specified or if there is no char after that
			super.setText(buttonText);
		}
		else {
			super.setText(buttonText.substring(0,iIndex)+buttonText.substring(iIndex+1));
			super.setMnemonic(buttonText.charAt(iIndex+1));
		}
    }

	public void setEnabled(boolean enabled) {
		super.setEnabled(enabled);
		
		if(enabled) {
			setForeground(Color.BLACK);
		}
		else {
			setForeground(new Color(0,51,102));
		}
	}
}
