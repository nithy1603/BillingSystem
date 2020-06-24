package sg.edu.nus.iss.system;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

import sg.edu.nus.iss.customer.CustomerProxy;
import sg.edu.nus.iss.subscription.Account;
import sg.edu.nus.iss.subscription.Subscription;
import sg.edu.nus.iss.subscription.SubscriptionProxy;

import sg.edu.nus.iss.utility.BTSPropertyBundle;


public class MenuHandler extends JMenuBar{

	private static final String MODULE = "System";
	
	private String SEPARATOR = "Separator";
	private BTSPropertyBundle propertyBundle = null;
	
	private String loginRole = null;
	
	MenuHandler() {

		setBackground(new Color(255,255,255));
		propertyBundle = new BTSPropertyBundle(MODULE);
		
		setMenuItems();
	}
	
	private void setMenuItems() {
		
		HashMap<String, ArrayList<String>> mainMenu = new HashMap<String, ArrayList<String>>();
		ArrayList<String> mainMenuOrder = new ArrayList<String>();
		
		ArrayList<String> adminMenus = new ArrayList<String>();
	
		
		adminMenus.add(getValue("VALmnuxxxxx015LogOff"));
		adminMenus.add(getValue("VALmnuxxxxx015Exit"));
		
		mainMenuOrder.add(getValue("VALmnuxxxxx015Admin"));
		mainMenu.put(getValue("VALmnuxxxxx015Admin"), adminMenus);
		
		ArrayList<String> servicesMenus = new ArrayList<String>();
		servicesMenus.add(getValue("VALmnuxxxxx015Customer"));
		
		mainMenuOrder.add(getValue("VALmnuxxxxx015Services"));
		mainMenu.put(getValue("VALmnuxxxxx015Services"), servicesMenus);
		
		ArrayList<String> helpMenus = new ArrayList<String>();
		helpMenus.add(getValue("VALmnuxxxxx015HelpContents"));
		helpMenus.add(getValue("VALmnuxxxxx015AboutBTS"));
		
		mainMenuOrder.add(getValue("VALmnuxxxxx015Help"));
		mainMenu.put(getValue("VALmnuxxxxx015Help"), helpMenus);
		
		addMenuItems(mainMenu, mainMenuOrder);		
	}
	
	private void addMenuItems(HashMap<String, ArrayList<String>> mainMenu, ArrayList<String> mainMenuOrder) {
		
		MenuActionListener menuActionListener = new MenuActionListener();
		//Set<String> menus = mainMenu.keySet(); //removed to maintain order in main menu
		for(String key : mainMenuOrder) {
			JMenu menu = new JMenu(key);
			add(menu);
			
			ArrayList<String> menuItems = mainMenu.get(key);			
			for(String value : menuItems) {
				if(SEPARATOR.equals(value)) {
					menu.add(new JSeparator());
				}
				else {
					JMenuItem menuItem = new JMenuItem(value);
					menuItem.addActionListener(menuActionListener);
					menuItem.setActionCommand(value);
					menu.add(menuItem);
				}
			}
		}
	}
	
	private String getValue(String key) {
		return propertyBundle.getValue(key);
	}
	
	private	class MenuActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {

        	if(e.getActionCommand().equals(getValue("VALmnuxxxxx015Customer"))) {
        		CustomerProxy.getInstance().displaySearchView();  
        	}
        	else if(e.getActionCommand().equals(getValue("VALmnuxxxxx015LogOff"))) {
        		ApplicationMaster.initialize().logOff();
        	}
        	else if(e.getActionCommand().equals(getValue("VALmnuxxxxx015Exit"))) {
        		ApplicationMaster.initialize().exit();
        	}
              	
        	else if(e.getActionCommand().equals(getValue("VALmnuxxxxx015HelpContents"))) {
        		SystemProxy.getInstance().displayHelpView();
        	}
        	else if(e.getActionCommand().equals(getValue("VALmnuxxxxx015AboutBTS"))) {
        		SystemProxy.getInstance().displayAboutBTSView();
        	}
        }
    }
}
