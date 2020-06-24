package sg.edu.nus.iss.system;

import javax.swing.JOptionPane;


import sg.edu.nus.iss.utility.BTSKeyWords;
import sg.edu.nus.iss.utility.BTSPropertyBundle;

class SystemController {
	
	private static final String MODULE = "System";
	
    public static final int MSG_INFORMATION 	= 0;
    public static final int MSG_ERROR			= 1;
    public static final int MSG_WARNING 		= 2;
    public static final int MSG_QUESTION		= 3;

	private LogonView logonView = null;
	private ApplicationMaster master = null;
	private HelpContentView helpView=null;
	private AboutBTSView aboutBTSView = null;
	
	private BTSPropertyBundle propertyBundle = null;

	SystemController() {
		propertyBundle = new BTSPropertyBundle(MODULE);
		
		if (master == null) {
			master = ApplicationMaster.initialize();
		}
	}
	/**
	 * This method, is used to display the logon screen when the application
	 * comes up.
	 *
	 * @return LogonView
	 */
	public LogonView displayLogonView() {
		logonView = LogonView.getInstance();
		logonView.setEnvironmentDetails(getValue("VALlblxxxxx015EnvironmentName"), this);
		logonView.setVisible(true);
		logonView.toFront();

		return logonView;
	}
	
	public String getValue(String key) {
		return propertyBundle.getValue(key);
	}
	
	/**
	 * This method, is used to dispose the logonView screen after the
	 * application comes up.
	 */
	private void disposeLogonView() {
		logonView.destroy();
		logonView = null;
	}
	
	public void logon(String userId, String password) {
		
		if(userId == null || userId.trim().length() == 0
				|| password == null || password.trim().length() == 0) {
			showMessage(MSG_ERROR, getValue("ERRmsgxxxxx100INVALIDLOGON"));
			return;
		}
				
			disposeLogonView();
			master.initializeScreen();
			master.getMainScreen().setInitialDetails();
			master.getMainScreen().setVisible(true);
			master.getMainScreen().toFront();

	}
	
	public HelpContentView displayHelpView() {
		
		if(helpView == null) {
			helpView = new HelpContentView() {
				public void cancelAction() {
					disposeHelpView();
				}
			};
			
			ApplicationMaster.addScreen(helpView);
		}
		
		helpView.setTitle("Help");
		helpView.setController(this);
		
		helpView.setVisible(true);
		
		return helpView;
	}	
	
	public void disposeHelpView() {
		if(helpView != null) {
			helpView.setVisible(false);
			ApplicationMaster.removeScreen(helpView);
			
			helpView.destroy();
			helpView = null;
		}
	}
	
	public AboutBTSView displayAboutBTSView() {
		if(aboutBTSView == null) {
			aboutBTSView = new AboutBTSView() {
				public void cancelAction() {
					disposeAboutBTSView();
				}
			};
			
			ApplicationMaster.addScreen(aboutBTSView);
		}
		
		aboutBTSView.setVisible(true);
		
		return aboutBTSView;
	}
	
	public void disposeAboutBTSView() {
		if(aboutBTSView != null) {
			
			aboutBTSView.setVisible(false);
			ApplicationMaster.removeScreen(aboutBTSView);
			
			aboutBTSView.destroy();
			aboutBTSView = null;
		}
	}
	
    public int showMessage(int type, String message)
    {
        int optionType = 0;
        int messageType = 0;

        switch (type)
        {
            case MSG_INFORMATION:
                messageType = JOptionPane.INFORMATION_MESSAGE;
                optionType = JOptionPane.DEFAULT_OPTION;
                break;
            case MSG_ERROR:
                messageType = JOptionPane.ERROR_MESSAGE;
                optionType = JOptionPane.DEFAULT_OPTION;
                break;
            case MSG_WARNING:
                messageType = JOptionPane.WARNING_MESSAGE;
                optionType = JOptionPane.DEFAULT_OPTION;
                break;
            case MSG_QUESTION:
                messageType = JOptionPane.QUESTION_MESSAGE;
                optionType = JOptionPane.YES_NO_OPTION;
                break;
            default:
                messageType = JOptionPane.PLAIN_MESSAGE;
                optionType = JOptionPane.DEFAULT_OPTION;
                break;
        }

        int selectedOption = JOptionPane.showOptionDialog(logonView,
																message,
																"LOGON",
																optionType,
																messageType,
																null,
																null,
																null);
		return selectedOption;
    }
	
}
