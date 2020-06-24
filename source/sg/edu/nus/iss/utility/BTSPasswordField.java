package sg.edu.nus.iss.utility;

import java.awt.Color;

import javax.swing.JPasswordField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

import sg.edu.nus.iss.utility.BTSTextField.BTSPlainDocument;



public class BTSPasswordField extends JPasswordField {

	private int cols = 0;
	
	public BTSPasswordField(int columns) {
		super(columns);
		cols = columns;
		
        setBackground(new Color(255, 255, 255));
        setForeground(Color.black);
        setSelectionColor(new Color(192,192,192));
        setSelectedTextColor(new Color(0,51,102));
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
	
	protected Document createDefaultModel() {
		return new BTSPlainDocument();
	}	
	
	class BTSPlainDocument extends PlainDocument {

		public void insertString(int offset, String string, AttributeSet attribute) throws BadLocationException {
			if (string == null)
				return;
			
			if ((getLength() + string.length()) <= cols) {
				super.insertString(offset, string, attribute);
			}
		}
	}	

}
