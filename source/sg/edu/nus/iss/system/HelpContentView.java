package sg.edu.nus.iss.system;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.StringTokenizer;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import sg.edu.nus.iss.utility.BTSInternalFrame;
import sg.edu.nus.iss.utility.BTSKeyWords;
import sg.edu.nus.iss.utility.BTSLabel;
import sg.edu.nus.iss.utility.BTSPanel;
import sg.edu.nus.iss.utility.BTSPropertyBundle;
import sg.edu.nus.iss.utility.BTSTextArea;


public class HelpContentView extends BTSInternalFrame implements BTSKeyWords {
	private final int SCREENWIDTH = 700;
	private final int SCREENHEIGHT = 300;
	private static final String MODULE = "System";
	private BTSPropertyBundle propertyBundle = null;
	private JScrollPane scrollPane=null;


	private SystemController systemController = null;
	public HelpContentView() {
		propertyBundle = new BTSPropertyBundle(MODULE);
		setSize(SCREENWIDTH, SCREENHEIGHT);
		createGUIComponents();
	}
	public void setController(SystemController systemController) {
		this.systemController = systemController;
	}
	
	/**
	 * Sets the UI properties
	 */
	private void createGUIComponents() {

		BTSPanel mainPanel = new BTSPanel();
		int ycoord=60;
		int abtYcoord=20;
		int faqYcoord=60; 
		
		mainPanel.setPreferredSize(new Dimension(SCREENWIDTH-10,SCREENHEIGHT+900)); 
		add(mainPanel);
		scrollPane = new JScrollPane(mainPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,  
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 0, SCREENWIDTH-10, SCREENHEIGHT-60);

		add(scrollPane);
		
		BTSLabel infoLabel = new BTSLabel(getValue("AboutLabel"));
		setLabelProperties(infoLabel);
		infoLabel.setBounds(5, abtYcoord, SCREENWIDTH-35, 22);
		mainPanel.add(infoLabel);

		BTSTextArea textarea= new BTSTextArea(9, 1);
		textarea.setBounds(5, abtYcoord+30, SCREENWIDTH-35, 80);
		textarea.setEditable(false);
		textarea.setForeground(Color.black);
		textarea.setText(getValue("VALabout"));
		mainPanel.add(textarea);
		
		BTSLabel guideLabel = new BTSLabel(getValue("GuideLabel"));
		
		guideLabel.setBounds(5, ycoord+130, SCREENWIDTH-35, 22);
		setLabelProperties(guideLabel);
		mainPanel.add(guideLabel);
		
		formGuide(mainPanel);
		
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
	
	private void setLabelProperties(BTSLabel label){
		label.setFont(new Font("Arial",Font.BOLD,14));
		label.setHorizontalAlignment(BTSLabel.LEFT);
		label.setOpaque(true);
		label.setBackground(new Color(192,192,192));	
	}

	private void setSubHeadingProperties(BTSLabel label){
		label.setFont(new Font("Times New Roman",Font.BOLD,12));
		label.setHorizontalAlignment(BTSLabel.LEFT);
		label.setOpaque(true);
		label.setForeground(Color.BLACK);
		
		label.setBackground(new Color(192,192,192));	
	}
	


	
	/**
	 * @param mainPanel
	 */
	private void formGuide(BTSPanel mainPanel){
		String questions=getValue("UserGuideTopics");
		StringTokenizer str = new StringTokenizer(questions, ",");
		int labelcoord=10;
		while(str.hasMoreTokens()){
			String ques = str.nextToken();
			formUserGuideView(getValue(ques),getValue(ques+"EXP"),labelcoord,labelcoord+25,mainPanel);
			labelcoord=labelcoord+130;
		}
	}

	/**
	 * @param labelText
	 * @param areaText
	 * @param labelCoord
	 * @param areaCoord
	 * @param mainPanel
	 */
	private void formUserGuideView(String labelText, String areaText, int labelCoord, int areaCoord, BTSPanel mainPanel){
		int ycoord =240;
		BTSLabel cmpltManagementLabel = new BTSLabel(labelText);
		cmpltManagementLabel.setBounds(5, ycoord+labelCoord, SCREENWIDTH-35, 15);
		setSubHeadingProperties(cmpltManagementLabel);
		mainPanel.add(cmpltManagementLabel);
	
		BTSTextArea cmplttextarea= new BTSTextArea(3, 1);
		cmplttextarea.setBounds(5, ycoord+areaCoord, SCREENWIDTH-35, 80);
		cmplttextarea.setEditable(false);
		cmplttextarea.setForeground(Color.black);
		cmplttextarea.setText(areaText);
		mainPanel.add(cmplttextarea);
	}
	
}
