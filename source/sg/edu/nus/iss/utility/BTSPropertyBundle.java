package sg.edu.nus.iss.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;



public class BTSPropertyBundle {

	private static HashMap<String, String> propertyMap = null;
	
	private Properties properties;

	static {
		propertyMap = new HashMap<String, String>();

		propertyMap.put("System", "propertyfiles/system.properties");
		propertyMap.put("Subscription", "propertyfiles/subscription.properties");		
		propertyMap.put("Customer", "propertyfiles/customer.properties");

	}

	public BTSPropertyBundle(String module) {

		String file = propertyMap.get(module);
		
		properties = new Properties();

		if(file != null && file.trim().length() > 0) {
			try {
				properties.load(new FileInputStream(file));
			}
			catch(FileNotFoundException fileNotFoundException) {
				fileNotFoundException.printStackTrace();
			}
			catch(IOException ioException) {
				ioException.printStackTrace();
			}
		}
	}
	
	public String getValue(String key) {
		try {
			String returnValue = properties.getProperty(key);
			if(returnValue != null) {
				return returnValue;
			}
			else {
				return key;
			}
		}
		catch(Exception exception) {
			return key;
		}
	}

}