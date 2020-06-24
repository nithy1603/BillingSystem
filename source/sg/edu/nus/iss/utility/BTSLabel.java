package sg.edu.nus.iss.utility;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;



public class BTSLabel extends JLabel {
	
	public BTSLabel() {
		this("");
	}
	
	public BTSLabel(String label) {
		super(label);
		setFont(new Font("Dialog",Font.PLAIN,12));
		setHorizontalAlignment(JLabel.RIGHT);
		setForeground(Color.black);
		setBackground(new Color(255,255,255));
	}

	public void setText(String text) {
		super.setText(text);
	}
}
