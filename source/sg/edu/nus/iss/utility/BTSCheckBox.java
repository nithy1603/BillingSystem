package sg.edu.nus.iss.utility;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JCheckBox;


public class BTSCheckBox extends JCheckBox {

	public BTSCheckBox() {
		super();
		setBackground(new Color(255, 255, 255));
        setForeground(Color.black);
        setFont(new Font("Dialog",Font.PLAIN,12));
	}
	
	public BTSCheckBox(String text) {
		this();
		setText(text);
	}
}
