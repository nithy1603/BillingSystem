package sg.edu.nus.iss.utility;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;



public class BTSScrollPane extends JScrollPane {

	private BTSScrollBar horizontalScrollbar = new BTSScrollBar(java.awt.Adjustable.HORIZONTAL);
	private BTSScrollBar verticalScrollbar = new BTSScrollBar(java.awt.Adjustable.VERTICAL);
	private EtchedBorder scrollbarBorder = new EtchedBorder();

	public BTSScrollPane()	{
		super();
		setProperties();
	}

	public BTSScrollPane(Component component)	{
		super(component);
		setProperties();
	}

	public void addComponent(Component component)	{
		addComponent(component,null);
	}
	
	public void addComponent(Component component,Object constraints)	{
		getViewport().add(component, constraints);
	}

	private void setProperties()	{
		setHorizontalScrollBar(horizontalScrollbar);
		setVerticalScrollBar(verticalScrollbar);
		getHorizontalScrollBar().setBorder(scrollbarBorder);
		getVerticalScrollBar().setBorder(scrollbarBorder);
		getViewport().setBackground(new Color(255,255,255));
		setBackground(Color.BLACK);
	}

}
