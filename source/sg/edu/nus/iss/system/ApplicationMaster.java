package sg.edu.nus.iss.system;

import java.lang.reflect.Method;
import java.util.ArrayList;

import sg.edu.nus.iss.utility.BTSInternalFrame;

public class ApplicationMaster {

	private static ApplicationMaster applicationMaster;
	private static MainScreen mainScreen;

	private ApplicationMaster() {
	}

	public static void main(String[] args) {		
		applicationMaster	= new ApplicationMaster();
		SystemProxy.getInstance().displayLogonView();
	}

	public static ApplicationMaster initialize() {
		return applicationMaster;
	}

	public static void addScreen(BTSInternalFrame screen) {
		mainScreen.addScreen(screen);
	}

	public static void addScreen(BTSInternalFrame screen, Integer layer) {
		mainScreen.addScreen(screen, layer);
	}

	public static void removeScreen(BTSInternalFrame screen) {
		mainScreen.removeScreen(screen);
	}

	public void initializeScreen() {
		try {
			mainScreen = MainScreen.initialize();
		}
		catch(Exception e) {
			log("Exception in ApplicationMaster initializeScreen");
		}
	}

	public MainScreen getMainScreen() {
		return mainScreen;
	}

	@SuppressWarnings("unchecked")
	public void logOff() {
		
		ArrayList<String> registeredModules = mainScreen.getRegisteredModules();
		
		for(String className : registeredModules) {
			try {
				
				Class invokingClass	= Class.forName(className);
				Method instanceMethod = invokingClass.getDeclaredMethod("getInstance");
				
				Object classInstance = instanceMethod.invoke(null);
				
				Method destroyMethod = invokingClass.getDeclaredMethod("destroy");
				destroyMethod.invoke(classInstance);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		mainScreen.destroy();
		SystemProxy.getInstance().displayLogonView();
	}
	
	public void exit() {
		System.exit(0);
	}
	
	private void log(Object message) {
		System.out.println(message);
	}	
}
