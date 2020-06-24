package sg.edu.nus.iss.utility;

import javax.swing.JScrollBar;



public class BTSScrollBar extends JScrollBar {
	
	public BTSScrollBar()
	{
		super();
	}

	public BTSScrollBar(int orientation)
	{
		super(orientation);
		setUnitIncrement(15);
		setBlockIncrement(80);
	}
}
