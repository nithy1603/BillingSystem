package sg.edu.nus.iss.utility;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;



public class BTSPanel extends JPanel {

	public BTSPanel()
	{
		super();
		setFont(new Font("Dialog",Font.BOLD,12));
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
			"", 0,0, new Font("Dialog",Font.BOLD,12),new Color(0,51,102)));
		setLayout(null);
		setBackground(new Color(255,255,255));
  	}
	
	public BTSPanel(String sTitle)
	{
		this();
		((TitledBorder)getBorder()).setTitle(sTitle);
	}
	
	public void removeBorder()
	{
		setBorder(new EmptyBorder(0,0,0,0));
	}
}
