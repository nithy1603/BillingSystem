package sg.edu.nus.iss.system;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;

import sg.edu.nus.iss.utility.BTSImageBundle;
import sg.edu.nus.iss.utility.BTSInternalFrame;
import sg.edu.nus.iss.utility.BTSPropertyBundle;


public class AboutBTSView extends BTSInternalFrame {
	
	private static final String MODULE = "System";
	
	private BTSPropertyBundle propertyBundle = null;

	public AboutBTSView() {
		
		propertyBundle = new BTSPropertyBundle(MODULE);
		setTitle(getValue("VALmnuxxxxx015AboutBTS"));
		
		createGUIComponents();
	}
	
	/**
	 * This method will create all the GUI components.
	 */
	private void createGUIComponents() {
		
		ImageIcon logonViewIcon = BTSImageBundle.getImage("logonView");
		JLabel backGroundLabel = new JLabel(logonViewIcon);
		add(backGroundLabel);
		backGroundLabel.setBounds(0,0,logonViewIcon.getIconWidth(),logonViewIcon.getIconHeight());
		
		setSize(logonViewIcon.getIconWidth(),logonViewIcon.getIconHeight());
	}
	
	private String getValue(String key) {
		return propertyBundle.getValue(key);
	}

	/**
	 * @Description Cleans up resources 
	 */
	public void destroy() {
		super.dispose();
	}
}
