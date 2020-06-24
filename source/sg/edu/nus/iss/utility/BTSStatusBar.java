package sg.edu.nus.iss.utility;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;



public class BTSStatusBar extends JPanel {
	
	private final static Font font = new Font("Dialog",Font.BOLD,12);
	private final static Color foreground = new Color(0,51,102);
	private final static Color background = new Color(192,192,192);
	private final static Dimension rightLabelSize = new Dimension(200,22);

	private JLabel leftSideMessage;
	private JLabel rightSideMessage;

	public BTSStatusBar()
	{
		this.setBackground(background);
		this.setBorder(new EtchedBorder(0));
		setLayout(new BorderLayout(3,2));

		leftSideMessage = new JLabel();
		leftSideMessage.setFont(font);
		leftSideMessage.setOpaque(true);
		leftSideMessage.setHorizontalAlignment(JLabel.LEFT);
		leftSideMessage.setBorder(new SoftBevelBorder(1));
		leftSideMessage.setForeground(foreground);
		leftSideMessage.setBackground(background);
		add(leftSideMessage,BorderLayout.CENTER);

		rightSideMessage = new JLabel();
		rightSideMessage.setFont(font);
		rightSideMessage.setOpaque(true);
		rightSideMessage.setHorizontalAlignment(JLabel.RIGHT);
		rightSideMessage.setBorder(new SoftBevelBorder(1));
		rightSideMessage.setForeground(foreground);
		rightSideMessage.setBackground(background);		
		rightSideMessage.setPreferredSize(rightLabelSize);
		add(rightSideMessage,BorderLayout.EAST);
	}

	/**
	 * This function sets the message to be displayed in the Left Side of status bar.
	 */
	public void setLeftMessage(String sMessage)
	{
		leftSideMessage.setText(sMessage);
	}

	/**
	 * This function sets the message to be displayed in the Right Side of status bar.
	 */
	public void setRightMessage(String sMessage)
	{
		rightSideMessage.setText(sMessage);
	}
}
