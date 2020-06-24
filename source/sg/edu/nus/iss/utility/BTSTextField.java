package sg.edu.nus.iss.utility;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;


public class BTSTextField extends JTextField {

	public static final int NORMAL = 0;
	public static final int UPPER = 1;
	public static final int INTEGER = 2;
	
	private int cols = 0;
	private int type = 0;
	
	public BTSTextField(int columns) {
		this(columns, NORMAL);
	}
	
	public BTSTextField(int columns, int type) {
		super(columns > 0 ? columns : 0);
		cols = columns > 0 ? columns : 0;
		
		this.type = type;
		
		setCustomProperties();
	}
	
	private void setCustomProperties() {
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
			try
			{
				if (string == null)
					return;

				if(type == UPPER) {
					string = string.toUpperCase();
				}
				else if(type == INTEGER) {
					Long.decode(string);
				}
				
				if ((getLength() + string.length()) <= cols) {
					super.insertString(offset, string, attribute);
				}
			}
			catch (NumberFormatException ex)
			{
				Toolkit.getDefaultToolkit().beep();
			}			
		}
	}
}
