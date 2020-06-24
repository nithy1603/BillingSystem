package sg.edu.nus.iss.utility;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;



public class BTSTable extends JTable {
  	
	public BTSTable()
  	{
		super();
		setCustomProperties();
	}

  	public BTSTable(TableModel model)
  	{
		super(model);
		setCustomProperties();
	}

	private void setCustomProperties() {
		
		setRowHeight((getRowHeight()*3)/2);
		getTableHeader().setBackground(new Color(0,51,102));
		getTableHeader().setForeground(Color.WHITE);
	    getTableHeader().setReorderingAllowed(false);
	    
		setSelectionBackground(new Color(192,192,192));
		setSelectionForeground(Color.black);
		
		getTableHeader().setFont(new Font("Dialog",Font.PLAIN,12));
		((DefaultTableCellRenderer)(getDefaultRenderer(java.util.Date.class))).setHorizontalAlignment(JLabel.CENTER);
		((DefaultTableCellRenderer)(getDefaultRenderer(Number.class))).setHorizontalAlignment(JLabel.RIGHT);
		((DefaultTableCellRenderer)(getDefaultRenderer(Object.class))).setHorizontalAlignment(JLabel.LEFT);
		getTableHeader().setDefaultRenderer(new HeaderRenderer());
	}
	
	class HeaderRenderer extends DefaultTableCellRenderer
	{
		public Component getTableCellRendererComponent(JTable theTable, Object oValue, boolean fHasFocus, boolean fIsSelected, int iRow, int iColumn)
		{

			super.getTableCellRendererComponent(theTable, null, fHasFocus, fIsSelected, iRow, iColumn);

			JButton btnTest = new JButton();
			btnTest.setBackground(new Color(0,51,102));
			btnTest.setForeground(Color.WHITE);
			btnTest.setHorizontalTextPosition(SwingConstants.LEFT);
			if ((theTable.getTableHeader() != null)&&(theTable.getTableHeader().getFont() != null))
			{
				btnTest.setFont(getTableHeader().getFont());
			}
			else
			{
				btnTest.setFont(new Font("Dialog",Font.PLAIN,12));
			}
			btnTest.setMargin(new java.awt.Insets(1,0,0,1));
			btnTest.setText(oValue.toString());
			return btnTest;
		}
	}

}
