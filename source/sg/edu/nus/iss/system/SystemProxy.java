package sg.edu.nus.iss.system;


public class SystemProxy {

	private static SystemProxy proxy;
    private SystemController systemController;
    private LogonView logonView;
    private HelpContentView helpView = null;
    private AboutBTSView aboutBTSView = null;
    
	private SystemProxy(){
		if(systemController == null) {
			systemController = new SystemController();
		}
	}

    /**
	 * This method returns the instance of this class
     */
    public static SystemProxy getInstance()
    {
		if(proxy==null)
			proxy=new SystemProxy();
		return proxy;
    }
    
    /**
	 * This method restricts cloning this object -- Singleton
     */
    public Object clone() throws CloneNotSupportedException {
    	throw new CloneNotSupportedException();
	}

	/**
	 * This method, is used to display the logon screen when
	 * the application comes up.
	 */
	public void displayLogonView() {
		logonView = systemController.displayLogonView();
	}
	
	/**
	 * This method, is used to display the help screen
	 *
	 */
	public void displayHelpView() {
		helpView = systemController.displayHelpView();
	}
	
	/**
	 * This method, is used to display the help screen
	 *
	 */
	public void displayAboutBTSView() {
		aboutBTSView = systemController.displayAboutBTSView();
	}
		
    /**
     * This function sets all the object data members to null.
     */
    public void destroy()
    {
    	systemController = null;
		proxy = null;
		logonView = null;
		aboutBTSView = null;
    }
}
