package sg.edu.nus.iss.utility;

import java.awt.Color;

import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;



public class BTSTextArea extends JTextArea{

	private EtchedBorder textAreaBorder = new EtchedBorder();

	public  BTSTextArea(int rows,int columns) {
		super(rows,columns);
		setBackground(new Color(255, 255, 255));
		setForeground(Color.black);
		setSelectionColor(new Color(192,192,192));
		setSelectedTextColor(new Color(0,51,102));
		setBorder(textAreaBorder);
		
		setLineWrap(true); 
		setWrapStyleWord(false); 
	}
	public void setEditable(boolean isEnabled) {
		super.setEditable(isEnabled);

		if(isEnabled) {
			setBackground(new Color(255, 255, 255));
			setForeground(Color.black);
			setSelectionColor(new Color(192,192,192));
			setSelectedTextColor(new Color(0,51,102));
		} else {
			setForeground(Color.red);
			setBackground(new Color(221,221,221));
			setSelectionColor(getBackground());
			setSelectedTextColor(getForeground());
		}
	}
	public void setMandatoryField(boolean isMandatory) {

		if (isEditable()) {
			setBackground(new Color(255,255,226));
			repaint();
		}
	}

}
