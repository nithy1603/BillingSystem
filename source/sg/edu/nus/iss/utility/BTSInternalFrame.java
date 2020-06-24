package sg.edu.nus.iss.utility;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.beans.PropertyVetoException;

import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;



public class BTSInternalFrame extends JInternalFrame {

    /**
     * Code for various messages
     */
    public static final int MSG_SUCCESS			= 0;
    public static final int MSG_INFORMATION 	= 1;
    public static final int MSG_ERROR			= 2;
    public static final int MSG_WARNING 		= 3;
    public static final int MSG_QUESTION		= 4;
    public static final int MSG_STATUS 			= 5;
    public static final int MSG_QUESTION_CANCEL	= 6;

	private BTSPanel contentPanel;
	private JComponent statusBar;

	public BTSInternalFrame() {
		super("", false, true, false);

		setIconifiable(true);
		setBackground(new Color(255,255,255));
		getContentPane().setLayout(new BorderLayout());

		contentPanel = new BTSPanel();
		contentPanel.removeBorder();
		contentPanel.setLayout(null);
		contentPanel.setBackground(new Color(255,255,255));

		statusBar = new BTSStatusBar();
		statusBar.setPreferredSize(new Dimension(10,26));
		statusBar.setMinimumSize(new Dimension(10,26));


		getContentPane().add(contentPanel, BorderLayout.CENTER);
		getContentPane().add(statusBar, BorderLayout.SOUTH);

		setFrameIcon(BTSImageBundle.getImage("windowIcon"));
		setDefaultCloseOperation(JInternalFrame.DO_NOTHING_ON_CLOSE);

		/**
		 * Frame Close operation
		 */
		addInternalFrameListener(new InternalFrameAdapter()
		{
	        public void internalFrameClosing(InternalFrameEvent e)
	        {
				cancelAction();
	        }
		});
		
		/**
		 * Escape Key Action
		 */
		javax.swing.Action escapeAction = new javax.swing.AbstractAction()
		{
			public void actionPerformed(java.awt.event.ActionEvent e)
			{
				cancelAction();
			}
		};

		this.getInputMap(javax.swing.JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(javax.swing.KeyStroke.getKeyStroke("ESCAPE"), "BTSInternalFrameEscapeAction");
		this.getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW).put(javax.swing.KeyStroke.getKeyStroke("ESCAPE"), "BTSInternalFrameEscapeAction");
		this.getActionMap().put("BTSInternalFrameEscapeAction", escapeAction);
	}

	/**
	 * This method adds the given component to the internal Frame.
	 */
	public void add(JComponent theComponent)
	{
		contentPanel.add(theComponent);
	}

	/**
	 * This method returns the panel
	 */
	public JPanel getContentPanel()
	{
		return contentPanel;
	}

	/**
	 * This method should be overridden in the sub classes. 
	 * This method will be called when close action or escape button action occurred.
	 */
    public void cancelAction()
    {
        dispose();
    }
    
    /**
     * This method returns the status bar.
     */
    public JComponent getStatusBar()
    {
        return statusBar;
    }
    
    /**
     * This method removes the status bar.
     */
    public void removeStatusBar()
    {
        this.getContentPane().remove(statusBar);
        statusBar = null;
    }
    
    /**
     * Clears the status bar message
     */
    public void clearMessage()
    {
        ((BTSStatusBar) getStatusBar()).setLeftMessage(" ");
    }

    /**
     * This method displays the input message on the status bar or
     * on an option pane
     */
    public int showMessage(int type, String message)
    {
        int optionType = 0;
        int messageType = 0;

        switch (type)
        {
        	case MSG_STATUS:
        	case MSG_SUCCESS:
        		((BTSStatusBar) getStatusBar()).setLeftMessage(message);
        		return -1;
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
            case MSG_QUESTION_CANCEL:
                messageType = JOptionPane.QUESTION_MESSAGE;
                optionType = JOptionPane.YES_NO_CANCEL_OPTION;
                break;
            default :
                messageType = JOptionPane.PLAIN_MESSAGE;
                optionType = JOptionPane.DEFAULT_OPTION;
                break;
        }

        int selectedOption = JOptionPane.showOptionDialog(this,
																message,
																getTitle(),
																optionType,
																messageType,
																null,
																null,
																null);
		return selectedOption;
    }
    
    public void setVisible(boolean isVisible) {
    	super.setVisible(isVisible);
    	
    	if(isVisible) {
			try {
				setSelected(true);
			} catch (PropertyVetoException e) {
				e.printStackTrace();
			}
			
			toFront();
			
			if(isIcon()) {
				try {
					setIcon(false);
				} catch (PropertyVetoException e) {
					e.printStackTrace();
				}
			}
    	}
    }

    public void dispose()
    {
        contentPanel.removeAll();
        contentPanel = null;
        statusBar = null;
        super.dispose();
    }
}
