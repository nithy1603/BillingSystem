package sg.edu.nus.iss.system;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import sg.edu.nus.iss.utility.BTSButton;
import sg.edu.nus.iss.utility.BTSImageBundle;
import sg.edu.nus.iss.utility.BTSPasswordField;
import sg.edu.nus.iss.utility.BTSTextField;



class LogonView extends JDialog {

	private static final String OK_BUTTON = "OkButton";
	private static final String CLOSE_BUTTON = "CloseButton";
	
	private static JFrame logonScreen = null;	
	private Container logonContainer = null;

	private BTSButton okButton = null;
	private BTSButton closeButton = null;

	private LogonViewListener logonViewListener = null;
	private LogonKeyListener logonKeyListener = null;
	
	private String environmentName = null;
	
	private SystemController controller = null;
	
	private BTSTextField userNameTextField = null;
	private BTSPasswordField passwordTextField = null;

	/**
	 * This method is used to create the instance of LogonView Class.
	 */
	static LogonView getInstance() {
		logonScreen = new JFrame("LOGON");
		logonScreen.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				logonScreen.dispose();
				ApplicationMaster.initialize().exit();
			}
		});
		logonScreen.setState(JFrame.ICONIFIED);
		logonScreen.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		logonScreen.setResizable(false);
		logonScreen.requestFocus();
		logonScreen.setUndecorated(true);
		return new LogonView(logonScreen);
	}

	/**
	 * This method,constructor is used to create the instance of LogonView Class.
	 */
	LogonView(JFrame owner) {
		super(owner);
		setUndecorated(true);
		logonContainer = getContentPane();
		logonContainer.setLayout(null);

		((JComponent)getContentPane()).setOpaque(false);

		ImageIcon logonViewIcon = BTSImageBundle.getImage("logonView");
		JLabel backGroundLabel = new JLabel(logonViewIcon);
		getLayeredPane().add(backGroundLabel, new Integer(Integer.MIN_VALUE));
		backGroundLabel.setBounds(0,0,logonViewIcon.getIconWidth(),logonViewIcon.getIconHeight());

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screenSize.width - logonViewIcon.getIconWidth()) / 2;
		int y = (screenSize.height - logonViewIcon.getIconHeight()) / 2;
		setBounds(x,y,logonViewIcon.getIconWidth(),logonViewIcon.getIconHeight());
	}

	public void setEnvironmentDetails(String details, SystemController controller) {
		environmentName = details;
		this.controller = controller;
		
		createGUIComponents();
		addLogonViewListeners();
	}

	/**
	 * This method will create all the GUI components.
	 */
	private void createGUIComponents() {

		Font font = new Font("Dialog",Font.PLAIN,11);
		LineBorder lineBorder = new LineBorder(new Color(153,153,153));

		ImageIcon okIcon = BTSImageBundle.getImage("okButton");
		ImageIcon closeIcon = BTSImageBundle.getImage("closeButton");

		JLabel environmentNameLabel = new JLabel();
		environmentNameLabel.setFont(font);
		environmentNameLabel.setHorizontalAlignment(JLabel.RIGHT);

		if(environmentName!=null && environmentName.trim().length() > 0)
		{
			environmentNameLabel.setText(environmentName);
		}
		else
		{
			environmentNameLabel.setText("");
		}
		environmentNameLabel.setBounds(190,50,362,20);
		environmentNameLabel.setForeground(new Color(23,67,106));
		logonContainer.add(environmentNameLabel);

		JLabel userNameLabel = new JLabel();
		userNameLabel.setFont(font);
		userNameLabel.setText(controller.getValue("VALlblxxxxx015UserName"));
		userNameLabel.setBounds(390,200,60,20);
		userNameLabel.setForeground(new Color(23,67,106));
		logonContainer.add(userNameLabel);

		userNameTextField = new BTSTextField(8, 1);
		userNameTextField.setBorder(lineBorder);
		userNameTextField.setBounds(455,204,100,15);
		logonContainer.add(userNameTextField);
		
		JLabel passwordLabel = new JLabel();
		passwordLabel.setFont(font);
		passwordLabel.setText(controller.getValue("VALlblxxxxx015Password"));
		passwordLabel.setBounds(390,220,60,20);
		passwordLabel.setForeground(new Color(23,67,106));
		logonContainer.add(passwordLabel);

		passwordTextField = new BTSPasswordField(10);
		passwordTextField.setBorder(lineBorder);
		passwordTextField.setBounds(455,224,100,15);
		logonContainer.add(passwordTextField);

		okButton = new BTSButton();
		okButton.setBorderPainted(false);
		okButton.setContentAreaFilled(false);
		okButton.setIcon(okIcon);
		okButton.setBounds(410,250,57,22);
		logonContainer.add(okButton);

		closeButton = new BTSButton();
		closeButton.setBorderPainted(false);
		closeButton.setContentAreaFilled(false);
		closeButton.setIcon(closeIcon);
		closeButton.setBounds(485,250,57,22);
		logonContainer.add(closeButton);
	}
	
	private void addLogonViewListeners() {
		logonViewListener = new LogonViewListener();

		okButton.addActionListener(logonViewListener);
		okButton.setActionCommand(OK_BUTTON);
		
		closeButton.addActionListener(logonViewListener);
		closeButton.setActionCommand(CLOSE_BUTTON);
		
		logonKeyListener = new LogonKeyListener();
		passwordTextField.addKeyListener(logonKeyListener);
	}
	
	private void removeLogonViewListeners() {
		okButton.removeActionListener(logonViewListener);
		closeButton.removeActionListener(logonViewListener);
		
		passwordTextField.removeKeyListener(logonKeyListener);
		
		logonViewListener = null;
		logonKeyListener = null;
	}

	class LogonViewListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals(OK_BUTTON)) {
				controller.logon(userNameTextField.getText(), new String(passwordTextField.getPassword()));
			}
			else if(e.getActionCommand().equals(CLOSE_BUTTON)) {
				logonScreen.dispose();
				ApplicationMaster.initialize().exit();
			}			
		}
	}
	
	class LogonKeyListener extends KeyAdapter {
	
		public void keyPressed(KeyEvent ke) {
			
			if(ke.getSource() == passwordTextField) {
				if(ke.getKeyCode() == KeyEvent.VK_ENTER) {
					controller.logon(userNameTextField.getText(), new String(passwordTextField.getPassword()));
				}
			}
		}
	}

	/**
	 * This method will destroy the components in the class
	 */
	public void destroy() {
		removeLogonViewListeners();
		logonScreen.dispose();
		logonScreen = null;
	}
}
