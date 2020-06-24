package sg.edu.nus.iss.system;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;


import sg.edu.nus.iss.utility.BTSDesktopPane;
import sg.edu.nus.iss.utility.BTSImageBundle;
import sg.edu.nus.iss.utility.BTSInternalFrame;
import sg.edu.nus.iss.utility.BTSKeyWords;
import sg.edu.nus.iss.utility.BTSPanel;
import sg.edu.nus.iss.utility.BTSPropertyBundle;
import sg.edu.nus.iss.utility.BTSScrollPane;
import sg.edu.nus.iss.utility.BTSStatusBar;


public class MainScreen extends JFrame {

	private static final String MODULE = "System";

	private static	ApplicationMaster applicationMaster;
	private	static	MainScreen mainScreen;

	private BTSPropertyBundle propertyBundle = null;

	private Dimension screenSize;
	private BTSDesktopPane deskTopPane;

	private static	BTSScrollPane mainScrollPane;
	private static	BTSStatusBar statusPanel;

	private static BTSPanel northPanel;
	
	
	private Thread timerThread = null;

	public static MainScreen initialize()
	{
		if(mainScreen == null) {
			mainScreen = new MainScreen();
		}
		
		return mainScreen;
	}

	private MainScreen()
	{
		applicationMaster = ApplicationMaster.initialize();
		propertyBundle = new BTSPropertyBundle(MODULE);

		screenSize = Toolkit.getDefaultToolkit().getScreenSize();		
		setBounds(0,0,screenSize.width,screenSize.height-22);

		setTitle(getValue("TTLscrxxxxx040MainScreen"));
		setIconImage(BTSImageBundle.getImage("mainScreenIcon").getImage());
		createGUIComponents();
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{ 
				applicationMaster.exit();
			}
		});
		
		setExtendedState(MAXIMIZED_BOTH);
		
		setSystemTimer();
	}

	private void createGUIComponents() {
		
		createNorthPanel();
		createMainScrollPane();
		statusPanel	= new BTSStatusBar();

		getContentPane().add(northPanel,BorderLayout.NORTH);
		getContentPane().add(mainScrollPane,BorderLayout.CENTER);
		getContentPane().add(statusPanel, BorderLayout.SOUTH);
	}

	private void createNorthPanel() {
		northPanel = new BTSPanel()
		{
			GradientPaint gradientPaint = new GradientPaint(0f, 0f, Color.white, 0f, 55f, new Color(175, 190, 209));
			public void paint(Graphics grps)
			{
				Graphics2D grps2D = (Graphics2D)grps;
				grps2D.setPaint(gradientPaint);
				grps2D.fill(new Rectangle(0,0,screenSize.width,55));
				super.paintBorder(grps);
				super.paintChildren(grps);
			}
		};
		northPanel.removeBorder();
		northPanel.setLayout(null);
		northPanel.setPreferredSize(new Dimension(1016,55));

		//northPanel.add(environmentNameLabel);
	}

	private void createMainScrollPane() {

		BTSPanel screenPanel = new BTSPanel();
		screenPanel.setBounds(0,-5,screenSize.width,screenSize.height-150);
		screenPanel.setBackground(new Color(231, 231, 239));
		screenPanel.setOpaque(true);
		screenPanel.setBorder(null);

		JLabel label = new JLabel() {
			public void paintComponent (Graphics g) {
				super.paintComponent (g);
				g.drawImage (BTSImageBundle.getImage("centerImage").getImage(), 0, 0, getWidth(), getHeight (), null);
			}
		};
		label.setBounds(0, 0, screenSize.width,(screenSize.height-140));
		screenPanel.add(label);

		deskTopPane = new BTSDesktopPane();
		deskTopPane.setLayout(null);
		deskTopPane.setBorder(null);
		deskTopPane.setBackground(new Color(231, 231, 239));
		deskTopPane.add(screenPanel, JLayeredPane.FRAME_CONTENT_LAYER);

		mainScrollPane = new BTSScrollPane();
		mainScrollPane.setBackground(Color.white);
		mainScrollPane.getViewport().add(deskTopPane);
	}

	void addScreen(BTSInternalFrame screen)
	{
		addScreen(screen,new Integer(1));
	}

	void addScreen(BTSInternalFrame screen, Integer layer)
	{
		int x 	= 0;
		int y 	= 0;
		deskTopPane.add(screen,layer);

		if (((int)getViewSize().getWidth()) > screen.getWidth())
		{
			x	= (((int)getViewSize().getWidth())-screen.getWidth())/2;
		}
		if(((int)getViewSize().getHeight()) > screen.getHeight())
		{
			y	= (((int)getViewSize().getHeight())-screen.getHeight())/2;
		}
		screen.setLocation(x,y);
	}

	void removeScreen(BTSInternalFrame screen)
	{
		deskTopPane.remove(screen);
		deskTopPane.repaint();
		deskTopPane.requestFocus();
	}
	
	private void setSystemTimer() {
		
		final SimpleDateFormat formatter = new SimpleDateFormat(BTSKeyWords.DATE_TIME_FORMAT);
		
		timerThread = new Thread() {
			
			public void run() {
				
				Calendar btsCalendar = new GregorianCalendar();
				
				while(true) {
					btsCalendar.add(Calendar.SECOND,1);
					statusPanel.setRightMessage(formatter.format(btsCalendar.getTime()));
					try {
						Thread.sleep(1000);
					}
					catch(Exception e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		timerThread.start();
	}

	public Dimension getViewSize()
	{
		return mainScrollPane.getViewport().getExtentSize();
	}

	
	void setInitialDetails() {
		
		setTitle(getValue("TTLscrxxxxx040MainScreen") + " - " + "BTS System");

		setJMenuBar(new MenuHandler());
	}

	public String getValue(String key) {
		return propertyBundle.getValue(key);
	}
	
	public ArrayList<String> getRegisteredModules() {
		
		ArrayList<String> registeredModules = new ArrayList<String>();
		
		registeredModules.add("sg.edu.nus.iss.customer.CustomerProxy");
	
		registeredModules.add("sg.edu.nus.iss.subscription.SubscriptionProxy");
		
		return registeredModules;
	}
	
	public void destroy() {
		super.dispose();
		mainScreen = null;
	}
}
