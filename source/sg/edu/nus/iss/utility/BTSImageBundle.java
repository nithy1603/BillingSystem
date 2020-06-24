package sg.edu.nus.iss.utility;

import java.util.HashMap;
import java.util.Properties;

import javax.swing.ImageIcon;



public class BTSImageBundle {

	private static HashMap<String, String> imageMap = null;
	
	private Properties properties;

	static {
		imageMap = new HashMap<String, String>();

		imageMap.put("logonView", "icons/logonView.jpg");
		imageMap.put("okButton", "icons/okButton.gif");
		imageMap.put("closeButton", "icons/closeButton.gif");
		imageMap.put("projectIcon", "icons/projectIcon.jpg");
		imageMap.put("centerImage", "icons/centerImage.jpg");
		imageMap.put("windowIcon", "icons/windowIcon.jpg");
		imageMap.put("mainScreenIcon", "icons/mainScreenIcon.jpg");
	}
	
	public static ImageIcon getImage(String key) {
		
		ImageIcon imageIcon = null;
		
		try {
			String file = imageMap.get(key);
			if(file != null) {
				imageIcon = new ImageIcon(file);
			}
		}
		catch(Exception exception) {
			return null;
		}
		
		return imageIcon;
	}

}