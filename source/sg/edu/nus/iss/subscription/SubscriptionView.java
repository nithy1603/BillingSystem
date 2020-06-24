package sg.edu.nus.iss.subscription;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import sg.edu.nus.iss.utility.BTSButton;
import sg.edu.nus.iss.utility.BTSCheckBox;
import sg.edu.nus.iss.utility.BTSInternalFrame;
import sg.edu.nus.iss.utility.BTSKeyWords;
import sg.edu.nus.iss.utility.BTSLabel;
import sg.edu.nus.iss.utility.BTSPanel;
import sg.edu.nus.iss.utility.BTSPropertyBundle;
import sg.edu.nus.iss.utility.BTSTextField;



public class SubscriptionView extends BTSInternalFrame implements BTSKeyWords{

	private final int SCREENWIDTH = 1200;
	private final int SCREENHEIGHT = 600;

	private static final String MODULE = "Subscription";


	private BTSPropertyBundle propertyBundle = null;


	private BTSButton addSubscriptionButton = null;
	private BTSButton closeButton=null;   
	private BTSTextField accountNumTextField=null;
	private BTSTextField digitalVoiceTelNoTextField = null;
	private BTSTextField mobileTelNoTextField = null;
	private BTSTextField digitalDateCommencedTextField=null;
	private BTSTextField digitalDateterminatedTextField=null;
	private BTSTextField dlocalDateCommencedTextField=null;
	private BTSTextField dlocalDateterminatedTextField=null;
	private BTSTextField dIDDDateCommencedTextField=null;
	private BTSTextField dIDDDateterminatedTextField=null;
	private BTSTextField dCallTrfrDateCommencedTextField=null;
	private BTSTextField dCallTrfrDateterminatedTextField=null;
	private BTSTextField mobileDateCommencedTextField=null;
	private BTSTextField mobileDateterminatedTextField=null;
	private BTSTextField mRoamingDateCommencedTextField=null;
	private BTSTextField mRoamingDateterminatedTextField=null;
	private BTSTextField mlocalDateCommencedTextField=null;
	private BTSTextField mlocalDateterminatedTextField=null;
	private BTSTextField mIDDDateCommencedTextField=null;
	private BTSTextField mIDDDateterminatedTextField=null;
	private BTSTextField mDSDateCommencedTextField=null;
	private BTSTextField mDSDateterminatedTextField=null;
	private BTSTextField cableDateCommencedTextField=null;
	private BTSTextField cableDateterminatedTextField=null;
	private BTSTextField cableStdDateCommencedTextField=null;
	private BTSTextField cableStdDateterminatedTextField=null;
	private BTSTextField cableAddnlDateCommencedTextField=null;
	private BTSTextField cableAddnlDateterminatedTextField=null;
	private BTSTextField cableAddlChannelsCountTextField=null;

	private BTSCheckBox digitalCheckBox= null;
	private BTSCheckBox mobileCheckBox= null;
	private BTSCheckBox cableCheckBox= null;
	private BTSCheckBox dlocalCheckBox= null;
	private BTSCheckBox dIDDCheckBox= null;
	private BTSCheckBox dcallTransferCheckBox= null;
	private BTSCheckBox mlocalCheckBox= null;
	private BTSCheckBox mRoamingCheckBox= null;
	private BTSCheckBox mIDDCheckBox= null;
	private BTSCheckBox mDataserviceCheckBox= null;
	private BTSCheckBox stdChannelsCheckBox= null;
	private BTSCheckBox addnlChannelsCheckBox= null;
	private CustomKeyAdapter customKeyAdapter=null;


	private SubscriptionController subscriptionController = null;
	private SubscriptionActionListener subscriptionListener=null;

	SubscriptionView() {
		setSize(SCREENWIDTH, SCREENHEIGHT);
		propertyBundle = new BTSPropertyBundle(MODULE);
		createGUIComponents();
		addActionListeners();
		addKeyListeners();
	}

	void setController(SubscriptionController subscriptionController) {
		this.subscriptionController = subscriptionController;
	}

	private void createGUIComponents() {

		BTSPanel mainPanel = new BTSPanel();
		mainPanel.setSize(SCREENWIDTH, SCREENHEIGHT);
		add(mainPanel);

		BTSPanel subscriptionPanel = new BTSPanel(getValue("SubscriptionPanelText"));
		subscriptionPanel.setBounds(15, 10, SCREENWIDTH - 35, 540);
		mainPanel.add(subscriptionPanel);

		BTSLabel infoLabel = new BTSLabel(getValue("InfoText"));
		infoLabel.setBounds(5, 20, 225, 22);
		subscriptionPanel.add(infoLabel);

		BTSLabel accountLabel = new BTSLabel(getValue("AccountText"));
		accountLabel.setBounds(250, 20, 135, 22);
		subscriptionPanel.add(accountLabel);

		accountNumTextField = new BTSTextField(11);
		accountNumTextField.setBounds(400, 20, 150, 22);
		subscriptionPanel.add(accountNumTextField);


		digitalCheckBox = new BTSCheckBox();
		digitalCheckBox.setBounds(5, 50, 25, 25);
		subscriptionPanel.add(digitalCheckBox);

		BTSLabel digitalVoiceLabel = new BTSLabel(getValue("DigitalVoiceLabelText"));
		digitalVoiceLabel.setBounds(30, 50, 75, 22);
		subscriptionPanel.add(digitalVoiceLabel);



		BTSLabel digitalDateCommencedLabel = new BTSLabel(getValue("DateCommencedText"));
		digitalDateCommencedLabel.setBounds(250, 50, 150, 22);
		subscriptionPanel.add(digitalDateCommencedLabel);

		digitalDateCommencedTextField = new BTSTextField(11);
		digitalDateCommencedTextField.setBounds(400, 50, 150, 22);
		subscriptionPanel.add(digitalDateCommencedTextField);


		BTSLabel digitalDateTerminatedLabel = new BTSLabel(getValue("DateTerminatedText"));
		digitalDateTerminatedLabel.setBounds(550, 50, 150, 22);
		subscriptionPanel.add(digitalDateTerminatedLabel);

		digitalDateterminatedTextField = new BTSTextField(11);
		digitalDateterminatedTextField.setBounds(700, 50, 150, 22);
		subscriptionPanel.add(digitalDateterminatedTextField);

		BTSLabel digitalTelNoLabel = new BTSLabel(getValue("TelephoneNumberText"));
		digitalTelNoLabel.setBounds(850, 50, 150, 22);
		subscriptionPanel.add(digitalTelNoLabel);

		digitalVoiceTelNoTextField = new BTSTextField(8, BTSTextField.INTEGER);
		digitalVoiceTelNoTextField.setBounds(1000, 50, 150, 22);
		digitalVoiceTelNoTextField.setMandatoryField(true);
		subscriptionPanel.add(digitalVoiceTelNoTextField);

		dlocalCheckBox = new BTSCheckBox();
		dlocalCheckBox.setBounds(35, 80, 25, 25);
		subscriptionPanel.add(dlocalCheckBox);

		BTSLabel dlocalLabel = new BTSLabel(getValue("LocalCallsText"));
		dlocalLabel.setBounds(60, 80, 100, 22);
		subscriptionPanel.add(dlocalLabel);



		BTSLabel dlocalDateCommencedLabel = new BTSLabel(getValue("DateCommencedText"));
		dlocalDateCommencedLabel.setBounds(250, 80, 150, 22);
		subscriptionPanel.add(dlocalDateCommencedLabel);

		dlocalDateCommencedTextField = new BTSTextField(11);
		dlocalDateCommencedTextField.setBounds(400, 80, 150, 22);
		subscriptionPanel.add(dlocalDateCommencedTextField);

		BTSLabel dlocalDateTerminatedLabel = new BTSLabel(getValue("DateTerminatedText"));
		dlocalDateTerminatedLabel.setBounds(550, 80, 150, 22);
		subscriptionPanel.add(dlocalDateTerminatedLabel);

		dlocalDateterminatedTextField = new BTSTextField(11);
		dlocalDateterminatedTextField.setBounds(700, 80, 150, 22);
		subscriptionPanel.add(dlocalDateterminatedTextField);

		dIDDCheckBox = new BTSCheckBox();
		dIDDCheckBox.setBounds(35, 110, 25, 25);
		subscriptionPanel.add(dIDDCheckBox);

		BTSLabel dIDDLabel = new BTSLabel(getValue("IDDCallsText"));
		dIDDLabel.setBounds(60, 110, 100, 22);
		subscriptionPanel.add(dIDDLabel);



		BTSLabel dIDDDateCommencedLabel = new BTSLabel(getValue("DateCommencedText"));
		dIDDDateCommencedLabel.setBounds(250, 110, 150, 22);
		subscriptionPanel.add(dIDDDateCommencedLabel);

		dIDDDateCommencedTextField = new BTSTextField(11);
		dIDDDateCommencedTextField.setBounds(400, 110, 150, 22);
		subscriptionPanel.add(dIDDDateCommencedTextField);

		BTSLabel dIDDDateTerminatedLabel = new BTSLabel(getValue("DateTerminatedText"));
		dIDDDateTerminatedLabel.setBounds(550, 110, 150, 22);
		subscriptionPanel.add(dIDDDateTerminatedLabel);

		dIDDDateterminatedTextField = new BTSTextField(11);
		dIDDDateterminatedTextField.setBounds(700, 110, 150, 22);
		subscriptionPanel.add(dIDDDateterminatedTextField);

		dcallTransferCheckBox = new BTSCheckBox();
		dcallTransferCheckBox.setBounds(35, 140, 25, 25);
		subscriptionPanel.add(dcallTransferCheckBox);

		BTSLabel dCTLabel = new BTSLabel(getValue("CallTransferText"));
		dCTLabel.setBounds(60, 140, 100, 22);
		subscriptionPanel.add(dCTLabel);



		BTSLabel dCTDateCommencedLabel = new BTSLabel(getValue("DateCommencedText"));
		dCTDateCommencedLabel.setBounds(250, 140, 150, 22);
		subscriptionPanel.add(dCTDateCommencedLabel);

		dCallTrfrDateCommencedTextField = new BTSTextField(11);
		dCallTrfrDateCommencedTextField.setBounds(400, 140, 150, 22);
		subscriptionPanel.add(dCallTrfrDateCommencedTextField);

		BTSLabel dCTDateTerminatedLabel = new BTSLabel(getValue("DateTerminatedText"));
		dCTDateTerminatedLabel.setBounds(550, 140, 150, 22);
		subscriptionPanel.add(dCTDateTerminatedLabel);

		dCallTrfrDateterminatedTextField = new BTSTextField(11);
		dCallTrfrDateterminatedTextField.setBounds(700, 140, 150, 22);
		subscriptionPanel.add(dCallTrfrDateterminatedTextField);

		addSubscriptionButton = new BTSButton();
		addSubscriptionButton.setText(getValue("AddSubscriptionButtonText"));
		addSubscriptionButton.setBounds(400, 490, 150, 20);
		subscriptionPanel.add(addSubscriptionButton);

		closeButton = new BTSButton();
		closeButton.setText(getValue("CloseText"));
		closeButton.setBounds(700,490,150,20);
		subscriptionPanel.add(closeButton);

		createMobileGUI(subscriptionPanel);
		createCableGUI(subscriptionPanel);
	}

	public void createMobileGUI(BTSPanel subscriptionPanel){
		int ycoord=190;
		int ycoord2=220;
		int ycoord3=250;
		int ycoord4=280;
		int ycoord5=310;
		mobileCheckBox = new BTSCheckBox();
		mobileCheckBox.setBounds(5, ycoord, 25, 25);
		subscriptionPanel.add(mobileCheckBox);

		BTSLabel mobileVoiceLabel = new BTSLabel(getValue("MobileVoiceText"));
		mobileVoiceLabel.setBounds(30, ycoord, 75, 22);
		subscriptionPanel.add(mobileVoiceLabel);



		BTSLabel mobileDateCommencedLabel = new BTSLabel(getValue("DateCommencedText"));
		mobileDateCommencedLabel.setBounds(250, ycoord, 150, 22);
		subscriptionPanel.add(mobileDateCommencedLabel);

		mobileDateCommencedTextField = new BTSTextField(11);
		mobileDateCommencedTextField.setBounds(400, ycoord, 150, 22);
		subscriptionPanel.add(mobileDateCommencedTextField);

		BTSLabel mobileDateTerminatedLabel = new BTSLabel(getValue("DateTerminatedText"));
		mobileDateTerminatedLabel.setBounds(550, ycoord, 150, 22);
		subscriptionPanel.add(mobileDateTerminatedLabel);

		mobileDateterminatedTextField = new BTSTextField(11);
		mobileDateterminatedTextField.setBounds(700, ycoord, 150, 22);
		subscriptionPanel.add(mobileDateterminatedTextField);

		BTSLabel mobileTelNoLabel = new BTSLabel(getValue("TelephoneNumberText"));
		mobileTelNoLabel.setBounds(850, ycoord, 150, 22);
		subscriptionPanel.add(mobileTelNoLabel);

		mobileTelNoTextField= new BTSTextField(8, BTSTextField.INTEGER);
		mobileTelNoTextField.setBounds(1000, ycoord, 150, 22);
		mobileTelNoTextField.setMandatoryField(true);
		subscriptionPanel.add(mobileTelNoTextField);

		mlocalCheckBox = new BTSCheckBox();
		mlocalCheckBox.setBounds(35, ycoord2, 25, 25);
		subscriptionPanel.add(mlocalCheckBox);

		BTSLabel mlocalLabel = new BTSLabel(getValue("LocalCallsText"));
		mlocalLabel.setBounds(60, ycoord2, 100, 22);
		subscriptionPanel.add(mlocalLabel);

		BTSLabel mlocalDateCommencedLabel = new BTSLabel(getValue("DateCommencedText"));
		mlocalDateCommencedLabel.setBounds(250, ycoord2, 150, 22);
		subscriptionPanel.add(mlocalDateCommencedLabel);

		mlocalDateCommencedTextField = new BTSTextField(11);
		mlocalDateCommencedTextField.setBounds(400, ycoord2, 150, 22);
		subscriptionPanel.add(mlocalDateCommencedTextField);

		BTSLabel mlocalDateTerminatedLabel = new BTSLabel(getValue("DateTerminatedText"));
		mlocalDateTerminatedLabel.setBounds(550, ycoord2, 150, 22);
		subscriptionPanel.add(mlocalDateTerminatedLabel);

		mlocalDateterminatedTextField = new BTSTextField(11);
		mlocalDateterminatedTextField.setBounds(700, ycoord2, 150, 22);
		subscriptionPanel.add(mlocalDateterminatedTextField);

		mIDDCheckBox = new BTSCheckBox();
		mIDDCheckBox.setBounds(35, ycoord3, 25, 25);
		subscriptionPanel.add(mIDDCheckBox);

		BTSLabel mIDDLabel = new BTSLabel(getValue("IDDCallsText"));
		mIDDLabel.setBounds(60, ycoord3, 100, 22);
		subscriptionPanel.add(mIDDLabel);



		BTSLabel mIDDDateCommencedLabel = new BTSLabel(getValue("DateCommencedText"));
		mIDDDateCommencedLabel.setBounds(250, ycoord3, 150, 22);
		subscriptionPanel.add(mIDDDateCommencedLabel);

		mIDDDateCommencedTextField = new BTSTextField(11);
		mIDDDateCommencedTextField.setBounds(400, ycoord3, 150, 22);
		subscriptionPanel.add(mIDDDateCommencedTextField);

		BTSLabel mIDDDateTerminatedLabel = new BTSLabel(getValue("DateTerminatedText"));
		mIDDDateTerminatedLabel.setBounds(550, ycoord3, 150, 22);
		subscriptionPanel.add(mIDDDateTerminatedLabel);

		mIDDDateterminatedTextField = new BTSTextField(11);
		mIDDDateterminatedTextField.setBounds(700, ycoord3, 150, 22);
		subscriptionPanel.add(mIDDDateterminatedTextField);

		mDataserviceCheckBox = new BTSCheckBox();
		mDataserviceCheckBox.setBounds(35, ycoord4, 25, 25);
		subscriptionPanel.add(mDataserviceCheckBox);

		BTSLabel dmDSLabel = new BTSLabel(getValue("DataServiceText"));
		dmDSLabel.setBounds(60, ycoord4, 100, 22);
		subscriptionPanel.add(dmDSLabel);



		BTSLabel mDSDateCommencedLabel = new BTSLabel(getValue("DateCommencedText"));
		mDSDateCommencedLabel.setBounds(250, ycoord4, 150, 22);
		subscriptionPanel.add(mDSDateCommencedLabel);

		mDSDateCommencedTextField = new BTSTextField(11);
		mDSDateCommencedTextField.setBounds(400, ycoord4, 150, 22);
		subscriptionPanel.add(mDSDateCommencedTextField);

		BTSLabel mDSDateTerminatedLabel = new BTSLabel(getValue("DateTerminatedText"));
		mDSDateTerminatedLabel.setBounds(550, ycoord4, 150, 22);
		subscriptionPanel.add(mDSDateTerminatedLabel);

		mDSDateterminatedTextField = new BTSTextField(11);
		mDSDateterminatedTextField.setBounds(700, ycoord4, 150, 22);
		subscriptionPanel.add(mDSDateterminatedTextField);

		mRoamingCheckBox = new BTSCheckBox();
		mRoamingCheckBox.setBounds(35, ycoord5, 25, 25);
		subscriptionPanel.add(mRoamingCheckBox);

		BTSLabel mRoamingLabel = new BTSLabel(getValue("RoamingText"));
		mRoamingLabel.setBounds(60, ycoord5, 100, 22);
		subscriptionPanel.add(mRoamingLabel);



		BTSLabel mRoamingDateCommencedLabel = new BTSLabel(getValue("DateCommencedText"));
		mRoamingDateCommencedLabel.setBounds(250, ycoord5, 150, 22);
		subscriptionPanel.add(mRoamingDateCommencedLabel);

		mRoamingDateCommencedTextField = new BTSTextField(11);
		mRoamingDateCommencedTextField.setBounds(400, ycoord5, 150, 22);
		subscriptionPanel.add(mRoamingDateCommencedTextField);

		BTSLabel mRoamingDateTerminatedLabel = new BTSLabel(getValue("DateTerminatedText"));
		mRoamingDateTerminatedLabel.setBounds(550, ycoord5, 150, 22);
		subscriptionPanel.add(mRoamingDateTerminatedLabel);

		mRoamingDateterminatedTextField = new BTSTextField(11);
		mRoamingDateterminatedTextField.setBounds(700, ycoord5, 150, 22);
		subscriptionPanel.add(mRoamingDateterminatedTextField);
	}

	public void createCableGUI(BTSPanel subscriptionPanel){
		int ycoord=360;
		int ycoord2=390;
		int ycoord3=420;
		int ycoord4=450;
		cableCheckBox = new BTSCheckBox();
		cableCheckBox.setBounds(5, ycoord, 25, 25);
		subscriptionPanel.add(cableCheckBox);

		BTSLabel mobileVoiceLabel = new BTSLabel(getValue("CableTVText"));
		mobileVoiceLabel.setBounds(30, ycoord, 75, 22);
		subscriptionPanel.add(mobileVoiceLabel);



		BTSLabel cableDateCommencedLabel = new BTSLabel(getValue("DateCommencedText"));
		cableDateCommencedLabel.setBounds(250, ycoord, 150, 22);
		subscriptionPanel.add(cableDateCommencedLabel);

		cableDateCommencedTextField = new BTSTextField(11);
		cableDateCommencedTextField.setBounds(400, ycoord, 150, 22);
		subscriptionPanel.add(cableDateCommencedTextField);

		BTSLabel cableDateTerminatedLabel = new BTSLabel(getValue("DateTerminatedText"));
		cableDateTerminatedLabel.setBounds(550, ycoord, 150, 22);
		subscriptionPanel.add(cableDateTerminatedLabel);

		cableDateterminatedTextField = new BTSTextField(11);
		cableDateterminatedTextField.setBounds(700, ycoord, 150, 22);
		subscriptionPanel.add(cableDateterminatedTextField);


		stdChannelsCheckBox = new BTSCheckBox();
		stdChannelsCheckBox.setBounds(35, ycoord2, 25, 25);
		subscriptionPanel.add(stdChannelsCheckBox);

		BTSLabel mlocalLabel = new BTSLabel(getValue("StandardChannelsText"));
		mlocalLabel.setBounds(60, ycoord2, 160, 22);
		subscriptionPanel.add(mlocalLabel);

		BTSLabel clocalDateCommencedLabel = new BTSLabel(getValue("DateCommencedText"));
		clocalDateCommencedLabel.setBounds(250, ycoord2, 150, 22);
		subscriptionPanel.add(clocalDateCommencedLabel);

		cableStdDateCommencedTextField = new BTSTextField(11);
		cableStdDateCommencedTextField.setBounds(400, ycoord2, 150, 22);
		subscriptionPanel.add(cableStdDateCommencedTextField);

		BTSLabel clocalDateTerminatedLabel = new BTSLabel(getValue("DateTerminatedText"));
		clocalDateTerminatedLabel.setBounds(550, ycoord2, 150, 22);
		subscriptionPanel.add(clocalDateTerminatedLabel);

		cableStdDateterminatedTextField = new BTSTextField(11);
		cableStdDateterminatedTextField.setBounds(700, ycoord2, 150, 22);
		subscriptionPanel.add(cableStdDateterminatedTextField);

		addnlChannelsCheckBox = new BTSCheckBox();
		addnlChannelsCheckBox.setBounds(35, ycoord3, 25, 25);
		subscriptionPanel.add(addnlChannelsCheckBox);

		BTSLabel caddnlLabel = new BTSLabel(getValue("AddnlChannelsText"));
		caddnlLabel.setBounds(60, ycoord3, 160, 22);
		subscriptionPanel.add(caddnlLabel);



		BTSLabel caddnlDateCommencedLabel = new BTSLabel(getValue("DateCommencedText"));
		caddnlDateCommencedLabel.setBounds(250, ycoord3, 150, 22);
		subscriptionPanel.add(caddnlDateCommencedLabel);

		cableAddnlDateCommencedTextField = new BTSTextField(11);
		cableAddnlDateCommencedTextField.setBounds(400, ycoord3, 150, 22);
		subscriptionPanel.add(cableAddnlDateCommencedTextField);

		BTSLabel caddnlDateTerminatedLabel = new BTSLabel(getValue("DateTerminatedText"));
		caddnlDateTerminatedLabel.setBounds(550, ycoord3, 150, 22);
		subscriptionPanel.add(caddnlDateTerminatedLabel);

		cableAddnlDateterminatedTextField = new BTSTextField(11);
		cableAddnlDateterminatedTextField.setBounds(700, ycoord3, 150, 22);
		subscriptionPanel.add(cableAddnlDateterminatedTextField);



		BTSLabel dmDSLabel = new BTSLabel(getValue("AddnlChannelsCountText"));
		dmDSLabel.setBounds(60, ycoord4, 160, 22);
		subscriptionPanel.add(dmDSLabel);



		cableAddlChannelsCountTextField = new BTSTextField(3);
		cableAddlChannelsCountTextField.setBounds(400, ycoord4, 150, 22);
		subscriptionPanel.add(cableAddlChannelsCountTextField);
	}


	private class SubscriptionActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			if(e.getSource().equals(digitalCheckBox)){
				handleCheckBoxAction(digitalCheckBox, digitalDateCommencedTextField);
				if(digitalCheckBox.isSelected()){
					dlocalCheckBox.setSelected(true);
					handleCheckBoxAction(dlocalCheckBox, dlocalDateCommencedTextField);
					dlocalCheckBox.setEnabled(false);
					dlocalDateCommencedTextField.setEditable(false);
					dlocalDateterminatedTextField.setEditable(false);

				}
				else{
					dlocalDateCommencedTextField.setEditable(true);
					dlocalDateterminatedTextField.setEditable(true);
					digitalVoiceTelNoTextField.setText(EMPTY_STRING);
					dlocalCheckBox.setSelected(false);
					handleCheckBoxAction(dlocalCheckBox, dlocalDateCommencedTextField);
					dIDDCheckBox.setSelected(false);
					handleCheckBoxAction(dIDDCheckBox, dIDDDateCommencedTextField);
					dcallTransferCheckBox.setSelected(false);
					handleCheckBoxAction(dcallTransferCheckBox, dCallTrfrDateCommencedTextField);
					dlocalCheckBox.setEnabled(true);
					dlocalDateterminatedTextField.setText(EMPTY_STRING);
					dIDDDateterminatedTextField.setText(EMPTY_STRING);
					dCallTrfrDateterminatedTextField.setText(EMPTY_STRING);
					digitalDateterminatedTextField.setText(EMPTY_STRING);

				}
			}else if(e.getSource().equals(mobileCheckBox)){
				handleCheckBoxAction(mobileCheckBox, mobileDateCommencedTextField);
				if(mobileCheckBox.isSelected()){
					mlocalCheckBox.setSelected(true);
					handleCheckBoxAction(mlocalCheckBox, mlocalDateCommencedTextField);
					mlocalCheckBox.setEnabled(false);
					mlocalDateCommencedTextField.setEditable(false);
					mlocalDateterminatedTextField.setEditable(false);

				}
				else{
					mlocalDateCommencedTextField.setEditable(true);
					mlocalDateterminatedTextField.setEditable(true);
					mobileTelNoTextField.setText(EMPTY_STRING);
					mlocalCheckBox.setSelected(false);
					handleCheckBoxAction(mlocalCheckBox, mlocalDateCommencedTextField);
					mIDDCheckBox.setSelected(false);
					handleCheckBoxAction(mIDDCheckBox, mIDDDateCommencedTextField);
					mDataserviceCheckBox.setSelected(false);
					handleCheckBoxAction(mDataserviceCheckBox, mDSDateCommencedTextField);
					mRoamingCheckBox.setSelected(false);
					handleCheckBoxAction(mRoamingCheckBox, mRoamingDateCommencedTextField);
					mlocalCheckBox.setEnabled(true);
					mlocalDateterminatedTextField.setText(EMPTY_STRING);
					mIDDDateterminatedTextField.setText(EMPTY_STRING);
					mDSDateterminatedTextField.setText(EMPTY_STRING);
					mRoamingDateterminatedTextField.setText(EMPTY_STRING);
					mobileDateterminatedTextField.setText(EMPTY_STRING);
				}
			}else if(e.getSource().equals(cableCheckBox)){
				handleCheckBoxAction(cableCheckBox, cableDateCommencedTextField);
				if(cableCheckBox.isSelected()){
					cableAddlChannelsCountTextField.setEditable(false);
					stdChannelsCheckBox.setSelected(true);
					handleCheckBoxAction(stdChannelsCheckBox, cableStdDateCommencedTextField);
					stdChannelsCheckBox.setEnabled(false);
					cableStdDateCommencedTextField.setEditable(false);
					cableStdDateterminatedTextField.setEditable(false);
				}
				else{
					cableStdDateCommencedTextField.setEditable(true);
					cableStdDateterminatedTextField.setEditable(true);
					cableAddlChannelsCountTextField.setEditable(false);
					cableAddlChannelsCountTextField.setText(EMPTY_STRING);
					stdChannelsCheckBox.setSelected(false);
					handleCheckBoxAction(stdChannelsCheckBox, cableStdDateCommencedTextField);
					addnlChannelsCheckBox.setSelected(false);
					handleCheckBoxAction(addnlChannelsCheckBox, cableAddnlDateCommencedTextField);
					stdChannelsCheckBox.setEnabled(true);
					cableAddnlDateterminatedTextField.setText(EMPTY_STRING);
					cableDateterminatedTextField.setText(EMPTY_STRING);
					cableStdDateterminatedTextField.setText(EMPTY_STRING);
				}
			}else if(e.getSource().equals(dlocalCheckBox)){
				if(!digitalCheckBox.isSelected()){
					showMessage(MSG_ERROR, getValue("ErrormsgxxxxxDigitalSelection"));
					dlocalCheckBox.setSelected(false);
				}else{
					handleCheckBoxAction(dlocalCheckBox, dlocalDateCommencedTextField);
				}
				
			}else if(e.getSource().equals(dIDDCheckBox)){
				if(!digitalCheckBox.isSelected()){
					showMessage(MSG_ERROR, getValue("ErrormsgxxxxxDigitalSelection"));
					dIDDCheckBox.setSelected(false);
				}else{
					handleCheckBoxAction(dIDDCheckBox, dIDDDateCommencedTextField);
				}
				if(!digitalDateterminatedTextField.getText().equalsIgnoreCase(EMPTY_STRING)){
					showMessage(MSG_ERROR, getValue("ErrormsgxxxxxDigitalSelectionAfterTermination"));
					dIDDCheckBox.setSelected(false);
				}
			}else if(e.getSource().equals(dcallTransferCheckBox)){
				if(!digitalCheckBox.isSelected()){
					showMessage(MSG_ERROR, getValue("ErrormsgxxxxxDigitalSelection"));
					dcallTransferCheckBox.setSelected(false);
				}
				else{
					handleCheckBoxAction(dcallTransferCheckBox, dCallTrfrDateCommencedTextField);
				}
				if(!digitalDateterminatedTextField.getText().equalsIgnoreCase(EMPTY_STRING)){
					showMessage(MSG_ERROR, getValue("ErrormsgxxxxxDigitalSelectionAfterTermination"));
					dcallTransferCheckBox.setSelected(false);
				}
			}else if(e.getSource().equals(mlocalCheckBox)){
				if(!mobileCheckBox.isSelected()){
					showMessage(MSG_ERROR, getValue("ErrormsgxxxxxMobileSelection"));
					mlocalCheckBox.setSelected(false);
				}
				else{
					handleCheckBoxAction(mlocalCheckBox, mlocalDateCommencedTextField);
				}
			}else if(e.getSource().equals(mIDDCheckBox)){
				if(!mobileCheckBox.isSelected()){
					showMessage(MSG_ERROR, getValue("ErrormsgxxxxxMobileSelection"));
					mIDDCheckBox.setSelected(false);
				}
				else{
					handleCheckBoxAction(mIDDCheckBox, mIDDDateCommencedTextField);
				}
				if(!mobileDateterminatedTextField.getText().equalsIgnoreCase(EMPTY_STRING)){
					showMessage(MSG_ERROR, getValue("ErrormsgxxxxxDigitalSelectionAfterTermination"));
					mIDDCheckBox.setSelected(false);
				}
			}else if(e.getSource().equals(mDataserviceCheckBox)){
				if(!mobileCheckBox.isSelected()){
					showMessage(MSG_ERROR, getValue("ErrormsgxxxxxMobileSelection"));
					mDataserviceCheckBox.setSelected(false);
				}else{
					handleCheckBoxAction(mDataserviceCheckBox, mDSDateCommencedTextField);
				}
				if(!mobileDateterminatedTextField.getText().equalsIgnoreCase(EMPTY_STRING)){
					showMessage(MSG_ERROR, getValue("ErrormsgxxxxxDigitalSelectionAfterTermination"));
					mDataserviceCheckBox.setSelected(false);
				}
			}else if(e.getSource().equals(stdChannelsCheckBox)){
				if(!cableCheckBox.isSelected()){
					showMessage(MSG_ERROR, getValue("ErrormsgxxxxxCableSelection"));
					stdChannelsCheckBox.setSelected(false);
				}
				else{
				handleCheckBoxAction(stdChannelsCheckBox, cableStdDateCommencedTextField);
				}
			}else if(e.getSource().equals(addnlChannelsCheckBox)){
				if(!cableCheckBox.isSelected()){
					showMessage(MSG_ERROR, getValue("ErrormsgxxxxxCableSelection"));
					addnlChannelsCheckBox.setSelected(false);
				}
				else{
					handleCheckBoxAction(addnlChannelsCheckBox, cableAddnlDateCommencedTextField);

					if (addnlChannelsCheckBox.isSelected()){
						cableAddlChannelsCountTextField.setEditable(true);
						//cableAddlChannelsCountTextField.setEditable(true);
					}
					else{
						cableAddlChannelsCountTextField.setText(EMPTY_STRING);
						cableAddlChannelsCountTextField.setEditable(false);
					}}
				if(!cableDateterminatedTextField.getText().equalsIgnoreCase(EMPTY_STRING)){
					showMessage(MSG_ERROR, getValue("ErrormsgxxxxxDigitalSelectionAfterTermination"));
					addnlChannelsCheckBox.setSelected(false);
				}
			}else if(e.getSource().equals(mRoamingCheckBox)){
				if(!mobileCheckBox.isSelected()){
					showMessage(MSG_ERROR, getValue("ErrormsgxxxxxMobileSelection"));
					mRoamingCheckBox.setSelected(false);
				}
				else{
					handleCheckBoxAction(mRoamingCheckBox, mRoamingDateCommencedTextField);
				}
				if(!mobileDateterminatedTextField.getText().equalsIgnoreCase(EMPTY_STRING)){
					showMessage(MSG_ERROR, getValue("ErrormsgxxxxxDigitalSelectionAfterTermination"));
					mRoamingCheckBox.setSelected(false);
				}

			}else if(e.getSource().equals(addSubscriptionButton)){
				//Add Subscription
				//				BTSDialog dialog = new BTSDialog();
				//				dialog.setTitle("Information!");
				//				
				//				dialog.setBounds(400, 400, 300, 200);
				//				//dialog.setSize(300, 200);
				//				BTSLabel dmDSLabel = new BTSLabel("Test text");
				//				dmDSLabel.setBounds(10, 10, 160, 22);
				//				BTSButton okButton = new BTSButton();
				//				okButton.setText("OK");
				//				okButton.setBounds(100, 100, 50, 30);
				//			
				//				dialog.add(okButton);				
				//				dialog.add(dmDSLabel);	
				//				dialog.setResizable(false);
				//				dialog.setVisible(true);


				Account account = manageSubscription();
				if (account!=null){
					subscriptionController.subscribe(account);
					showMessage(MSG_INFORMATION, getValue("InfomsgxxxxxSubscriptionSuccess"));
					subscriptionController.disposeSubscriptionView();
				}
			}
			else if(e.getSource().equals(closeButton)){
				subscriptionController.disposeSubscriptionView();
			}

		}
	}


	public Account manageSubscription() {
		Account account = new Account();
		account.setAccountNumber(accountNumTextField.getText());
		if(digitalCheckBox.isSelected()){
			DigitalVoice digitalSubscription = new DigitalVoice();
			digitalSubscription.setSubscriptionId(DIGITALPLAN);
			if (isValidDate(digitalDateCommencedTextField.getText(),false)){
				digitalSubscription.setDateCommenced(digitalDateCommencedTextField.getText());
			}
			else{
				showMessage(MSG_ERROR, getValue("ErrormsgxxxxxCommencedInvalidDate"));
				return null;
			}
			if (isValidDate(digitalDateterminatedTextField.getText(), true)){
				digitalSubscription.setDateTerminated(digitalDateterminatedTextField.getText());
			}
			else{
				showMessage(MSG_ERROR, getValue("ErrormsgxxxxxTerminatedInvalidDate"));
				return null;
			}
			if(dlocalCheckBox.isSelected()){
				Feature feature = new Feature();
				if (isValidDate(dlocalDateCommencedTextField.getText(),false)){
					if(isCommencedService(dlocalDateCommencedTextField.getText(),digitalDateCommencedTextField.getText())){
						feature.setDateCommenced(dlocalDateCommencedTextField.getText());
					}
					else{
						showMessage(MSG_ERROR, getValue("ErrormsgxxxxxCommencedFeatureLessThanService"));
						return null;
					}
				}
				else{
					showMessage(MSG_ERROR, getValue("ErrormsgxxxxxCommencedInvalidDate"));
					return null;
				}
				if (isValidDate(dlocalDateterminatedTextField.getText(),true)){
					if(isTerminatedService(dlocalDateterminatedTextField.getText(),digitalDateterminatedTextField.getText())){
						feature.setDateTerminated(dlocalDateterminatedTextField.getText());
					}
					else{
						showMessage(MSG_ERROR, getValue("ErrormsgxxxxxTerminatedFeatureLessThanService"));
						return null;
					}
					
				}
				else{
					showMessage(MSG_ERROR, getValue("ErrormsgxxxxxTerminatedInvalidDate"));
					return null;
				}
				if (isLater(dlocalDateCommencedTextField.getText(),dlocalDateterminatedTextField.getText())){
					feature.setFeatureId(DIGITAL_LOCAL);
					digitalSubscription.setFeatures(feature);
				}
				else{
					showMessage(MSG_ERROR, getValue("ErrormsgxxxxxTerminatedLesserDate"));
					return null;
				}

			}
			if(dIDDCheckBox.isSelected()){
				Feature feature = new Feature();
				if (isValidDate(dIDDDateCommencedTextField.getText(),false)){
					if(isCommencedService(dIDDDateCommencedTextField.getText(),digitalDateCommencedTextField.getText())){
						feature.setDateCommenced(dIDDDateCommencedTextField.getText());
					}
					else{
						showMessage(MSG_ERROR, getValue("ErrormsgxxxxxCommencedFeatureLessThanService"));
						return null;
					}
				}
				else{
					showMessage(MSG_ERROR, getValue("ErrormsgxxxxxCommencedInvalidDate"));
					return null;
				}
				if (isValidDate(dIDDDateterminatedTextField.getText(),true)){
					if(dIDDDateterminatedTextField.getText().equalsIgnoreCase(EMPTY_STRING)){
						dIDDDateterminatedTextField.setText(digitalDateterminatedTextField.getText());
						}
					if(isTerminatedService(dIDDDateterminatedTextField.getText(),digitalDateterminatedTextField.getText())){
						feature.setDateTerminated(dIDDDateterminatedTextField.getText());
					}
					else{
						showMessage(MSG_ERROR, getValue("ErrormsgxxxxxTerminatedFeatureLessThanService"));
						return null;
					}
					
				}
				else{
					showMessage(MSG_ERROR, getValue("ErrormsgxxxxxTerminatedInvalidDate"));
					return null;
				}
				if (isLater(dIDDDateCommencedTextField.getText(),dIDDDateterminatedTextField.getText())){
					feature.setFeatureId(DIGITAL_IDD);
					digitalSubscription.setFeatures(feature);
				}
				else{
					showMessage(MSG_ERROR, getValue("ErrormsgxxxxxTerminatedLesserDate"));
					return null;
				}

			}	
			if(dcallTransferCheckBox.isSelected()){
				Feature feature = new Feature();
				if (isValidDate(dCallTrfrDateCommencedTextField.getText(), false)){
					if(isCommencedService(dCallTrfrDateCommencedTextField.getText(),digitalDateCommencedTextField.getText())){
						feature.setDateCommenced(dCallTrfrDateCommencedTextField.getText());
					}
					else{
						showMessage(MSG_ERROR, getValue("ErrormsgxxxxxCommencedFeatureLessThanService"));
						return null;
					}
				}
				else{
					showMessage(MSG_ERROR, getValue("ErrormsgxxxxxCommencedInvalidDate"));
					return null;
				}
				if (isValidDate(dCallTrfrDateterminatedTextField.getText(), true)){
					if(dCallTrfrDateterminatedTextField.getText().equalsIgnoreCase(EMPTY_STRING)){
						dCallTrfrDateterminatedTextField.setText(digitalDateterminatedTextField.getText());
					}
					if(isTerminatedService(dCallTrfrDateterminatedTextField.getText(),digitalDateterminatedTextField.getText())){
						feature.setDateTerminated(dCallTrfrDateterminatedTextField.getText());
					}
					else{
						showMessage(MSG_ERROR, getValue("ErrormsgxxxxxTerminatedFeatureLessThanService"));
						return null;
					}
					
				}
				else{
					showMessage(MSG_ERROR, getValue("ErrormsgxxxxxTerminatedInvalidDate"));
					return null;
				}
				if (isLater(dCallTrfrDateCommencedTextField.getText(),dCallTrfrDateterminatedTextField.getText())){
					feature.setFeatureId(DIGITAL_CALLTRANSFER);
					digitalSubscription.setFeatures(feature);
				}
				else{
					showMessage(MSG_ERROR, getValue("ErrormsgxxxxxTerminatedLesserDate"));
					return null;
				}

			}		
			if(digitalVoiceTelNoTextField.getText() != null 
					&& !EMPTY_STRING.equals(digitalVoiceTelNoTextField.getText())&& isLong(digitalVoiceTelNoTextField.getText())){
				digitalSubscription.setTelephoneNumber(new Long(digitalVoiceTelNoTextField.getText()));
			}
			else{
				showMessage(MSG_ERROR, getValue("ErrormsgxxxxxTelephoneNo"));
				return null;
			}
			
			if (isLater(digitalDateCommencedTextField.getText(),digitalDateterminatedTextField.getText())){
				account.setSubscriptions(digitalSubscription);
			}
			else{
				showMessage(MSG_ERROR, getValue("ErrormsgxxxxxTerminatedLesserDate"));
				return null;
			}	

		}
		if(mobileCheckBox.isSelected()){
			MobileVoice mobileSubscription = new MobileVoice();
			mobileSubscription.setSubscriptionId(MOBILEPLAN);
			if (isValidDate(mobileDateCommencedTextField.getText(), false)){
				mobileSubscription.setDateCommenced(mobileDateCommencedTextField.getText());
			}
			else{
				showMessage(MSG_ERROR, getValue("ErrormsgxxxxxCommencedInvalidDate"));
				return null;
			}
			if (isValidDate(mobileDateterminatedTextField.getText(), true)){
				mobileSubscription.setDateTerminated(mobileDateterminatedTextField.getText());
			}
			else{
				showMessage(MSG_ERROR, getValue("ErrormsgxxxxxTerminatedInvalidDate"));
				return null;
			}
			if(mlocalCheckBox.isSelected()){
				Feature feature = new Feature();
				if (isValidDate(mlocalDateCommencedTextField.getText(), false)){
					feature.setDateCommenced(mlocalDateCommencedTextField.getText());
				}
				else{
					showMessage(MSG_ERROR, getValue("ErrormsgxxxxxCommencedInvalidDate"));
					return null;
				}

				if (isValidDate(mlocalDateterminatedTextField.getText(), true)){
					feature.setDateTerminated(mlocalDateterminatedTextField.getText());
				}
				else{
					showMessage(MSG_ERROR, getValue("ErrormsgxxxxxTerminatedInvalidDate"));
					return null;
				}
				if (isLater(mlocalDateCommencedTextField.getText(),mlocalDateterminatedTextField.getText())){
					feature.setFeatureId(MOBILE_LOCAL);
					mobileSubscription.setFeatures(feature);
				}
				else{
					showMessage(MSG_ERROR, getValue("ErrormsgxxxxxTerminatedLesserDate"));
					return null;
				}

			}
			if(mRoamingCheckBox.isSelected()){
				Feature feature = new Feature();
				if (isValidDate(mRoamingDateCommencedTextField.getText(), false)){
					if(isCommencedService(mRoamingDateCommencedTextField.getText(),mobileDateCommencedTextField.getText())){
						feature.setDateCommenced(mRoamingDateCommencedTextField.getText());
					}
					else{
						showMessage(MSG_ERROR, getValue("ErrormsgxxxxxCommencedFeatureLessThanService"));
						return null;
					}
				}
				else{
					showMessage(MSG_ERROR, getValue("ErrormsgxxxxxCommencedInvalidDate"));
					return null;
				}

				if (isValidDate(mRoamingDateterminatedTextField.getText(), true)){
					if(mRoamingCheckBox.isSelected() && mRoamingDateterminatedTextField.getText().equalsIgnoreCase(EMPTY_STRING)){
						mRoamingDateterminatedTextField.setText(mobileDateterminatedTextField.getText());
						}
					if(isTerminatedService(mRoamingDateterminatedTextField.getText(),mobileDateterminatedTextField.getText())){
						feature.setDateTerminated(mRoamingDateterminatedTextField.getText());
					}
					else{
						showMessage(MSG_ERROR, getValue("ErrormsgxxxxxTerminatedFeatureLessThanService"));
						return null;
					}
					
				}
				else{
					showMessage(MSG_ERROR, getValue("ErrormsgxxxxxTerminatedInvalidDate"));
					return null;
				}

				if (isLater(mRoamingDateCommencedTextField.getText(),mRoamingDateterminatedTextField.getText())){
					feature.setFeatureId(MOBILE_ROAMING);
					mobileSubscription.setFeatures(feature);
				}
				else{
					showMessage(MSG_ERROR, getValue("ErrormsgxxxxxTerminatedLesserDate"));
					return null;
				}					

			}	

			if(mIDDCheckBox.isSelected()){
				Feature feature = new Feature();
				if (isValidDate(mIDDDateCommencedTextField.getText(), false)){
					if(isCommencedService(mIDDDateCommencedTextField.getText(),mobileDateCommencedTextField.getText())){
						feature.setDateCommenced(mIDDDateCommencedTextField.getText());
					}
					else{
						showMessage(MSG_ERROR, getValue("ErrormsgxxxxxCommencedFeatureLessThanService"));
						return null;
					}
					
				}
				else{
					showMessage(MSG_ERROR, getValue("ErrormsgxxxxxCommencedInvalidDate"));
					return null;
				}
				if (isValidDate(mIDDDateterminatedTextField.getText(), true)){
					if(mIDDDateterminatedTextField.getText().equalsIgnoreCase(EMPTY_STRING)){
						mIDDDateterminatedTextField.setText(mobileDateterminatedTextField.getText());
						}
					if(isTerminatedService(mIDDDateterminatedTextField.getText(),mobileDateterminatedTextField.getText())){
						feature.setDateTerminated(mIDDDateterminatedTextField.getText());
					}
					else{
						showMessage(MSG_ERROR, getValue("ErrormsgxxxxxTerminatedFeatureLessThanService"));
						return null;
					}
					
				}
				else{
					showMessage(MSG_ERROR, getValue("ErrormsgxxxxxTerminatedInvalidDate"));
					return null;
				}				
				if (isLater(mIDDDateCommencedTextField.getText(),mIDDDateterminatedTextField.getText())){
					feature.setFeatureId(MOBILE_IDD);
					mobileSubscription.setFeatures(feature);
				}
				else{
					showMessage(MSG_ERROR, getValue("ErrormsgxxxxxTerminatedLesserDate"));
					return null;
				}	

			}	
			if(mDataserviceCheckBox.isSelected()){
				Feature feature = new Feature();
				if (isValidDate(mDSDateCommencedTextField.getText(), false)){
					if(isCommencedService(mDSDateCommencedTextField.getText(),mobileDateCommencedTextField.getText())){
						feature.setDateCommenced(mDSDateCommencedTextField.getText());
					}
					else{
						showMessage(MSG_ERROR, getValue("ErrormsgxxxxxCommencedFeatureLessThanService"));
						return null;
					}
					
				}
				else{
					showMessage(MSG_ERROR, getValue("ErrormsgxxxxxCommencedInvalidDate"));
					return null;
				}

				if (isValidDate(mDSDateterminatedTextField.getText(), true)){
					if(mDataserviceCheckBox.isSelected() && mDSDateterminatedTextField.getText().equalsIgnoreCase(EMPTY_STRING)){
						mDSDateterminatedTextField.setText(mobileDateterminatedTextField.getText());
						}
					if(isTerminatedService(mDSDateterminatedTextField.getText(),mobileDateterminatedTextField.getText())){
						feature.setDateTerminated(mDSDateterminatedTextField.getText());
					}
					else{
						showMessage(MSG_ERROR, getValue("ErrormsgxxxxxTerminatedFeatureLessThanService"));
						return null;
					}
					
				}
				else{
					showMessage(MSG_ERROR, getValue("ErrormsgxxxxxTerminatedInvalidDate"));
					return null;
				}

				if (isLater(mDSDateCommencedTextField.getText(),mDSDateterminatedTextField.getText())){
					feature.setFeatureId(MOBILE_DATASERVICES);
					mobileSubscription.setFeatures(feature);
				}
				else{
					showMessage(MSG_ERROR, getValue("ErrormsgxxxxxTerminatedLesserDate"));
					return null;
				}				

			}		
			if(mobileTelNoTextField.getText() != null 
					&& !EMPTY_STRING.equals(mobileTelNoTextField.getText()) && isLong(mobileTelNoTextField.getText())){
				mobileSubscription.setTelephoneNumber(new Long(mobileTelNoTextField.getText()));
			}
			else{
				showMessage(MSG_ERROR, getValue("ErrormsgxxxxxTelephoneNo"));
				return null;
			}

			

			if (isLater(mobileDateCommencedTextField.getText(),mobileDateterminatedTextField.getText())){
				account.setSubscriptions(mobileSubscription);
			}
			else{
				showMessage(MSG_ERROR, getValue("ErrormsgxxxxxTerminatedLesserDate"));
				return null;
			}				

		}
		if(cableCheckBox.isSelected()){
			CableTv cableSubscription = new CableTv();
			cableSubscription.setSubscriptionId(CABLETV);
			if (isValidDate(cableDateCommencedTextField.getText(), false)){
				cableSubscription.setDateCommenced(cableDateCommencedTextField.getText());
			}
			else{
				showMessage(MSG_ERROR, getValue("ErrormsgxxxxxCommencedInvalidDate"));
				return null;
			}
			if (isValidDate(cableDateterminatedTextField.getText(), true)){
				cableSubscription.setDateTerminated(cableDateterminatedTextField.getText());
			}
			else{
				showMessage(MSG_ERROR, getValue("ErrormsgxxxxxTerminatedInvalidDate"));
				return null;
			}

			if(stdChannelsCheckBox.isSelected()){
				Feature feature = new Feature();
				if (isValidDate(cableStdDateCommencedTextField.getText(), false)){
					feature.setDateCommenced(cableStdDateCommencedTextField.getText());
				}
				else{
					showMessage(MSG_ERROR, getValue("ErrormsgxxxxxCommencedInvalidDate"));
					return null;
				}

				if (isValidDate(cableStdDateterminatedTextField.getText(), true)){
					feature.setDateTerminated(cableStdDateterminatedTextField.getText());
				}
				else{
					showMessage(MSG_ERROR, getValue("ErrormsgxxxxxTerminatedInvalidDate"));
					return null;
				}
				if (isLater(cableStdDateCommencedTextField.getText(),cableStdDateterminatedTextField.getText())){
					feature.setFeatureId(STANDARDCHANNELS);
					cableSubscription.setFeatures(feature);
				}
				else{
					showMessage(MSG_ERROR, getValue("ErrormsgxxxxxTerminatedLesserDate"));
					return null;
				}	

			}
			if(addnlChannelsCheckBox.isSelected()){
				Feature feature = new Feature();
				if (isValidDate(cableAddnlDateCommencedTextField.getText(), false)){
					if(isCommencedService(cableAddnlDateCommencedTextField.getText(),cableDateCommencedTextField.getText())){
						feature.setDateCommenced(cableAddnlDateCommencedTextField.getText());
					}
					else{
						showMessage(MSG_ERROR, getValue("ErrormsgxxxxxCommencedFeatureLessThanService"));
						return null;
					}
					
				}
				else{
					showMessage(MSG_ERROR, getValue("ErrormsgxxxxxCommencedInvalidDate"));
					return null;
				}
				if (isValidDate(cableAddnlDateterminatedTextField.getText(), true)){
					if(addnlChannelsCheckBox.isSelected() && cableAddnlDateterminatedTextField.getText().equalsIgnoreCase(EMPTY_STRING)){
						cableAddnlDateterminatedTextField.setText(cableDateterminatedTextField.getText());
						}
					if(isTerminatedService(cableAddnlDateterminatedTextField.getText(),cableDateterminatedTextField.getText())){
						feature.setDateTerminated(cableAddnlDateterminatedTextField.getText());
					}
					else{
						showMessage(MSG_ERROR, getValue("ErrormsgxxxxxTerminatedFeatureLessThanService"));
						return null;
					}
					
				}
				else{
					showMessage(MSG_ERROR, getValue("ErrormsgxxxxxTerminatedInvalidDate"));
					return null;
				}
				if (isLater(cableAddnlDateCommencedTextField.getText(),cableAddnlDateterminatedTextField.getText())){
					feature.setFeatureId(ADDITIONALCHANNELS);
					cableSubscription.setFeatures(feature);	
				}
				else{
					showMessage(MSG_ERROR, getValue("ErrormsgxxxxxTerminatedLesserDate"));
					return null;
				}


				if(cableAddlChannelsCountTextField.getText() != null 
						&& !EMPTY_STRING.equals(cableAddlChannelsCountTextField.getText())){
					if (isInt(cableAddlChannelsCountTextField.getText())){
					cableSubscription.setAdditionalChannels(new Integer(cableAddlChannelsCountTextField.getText()));
					}
					else{
						showMessage(MSG_ERROR, getValue("ErrormsgxxxxxAdditionalChannelsNo"));
						return null;
					}
				}
				else{
					showMessage(MSG_ERROR, getValue("ErrormsgxxxxxAdditionalChannels"));
					return null;
				}

			}

			
			if (isLater(cableDateCommencedTextField.getText(),cableDateterminatedTextField.getText())){
				account.setSubscriptions(cableSubscription);	
			}
			else{
				showMessage(MSG_ERROR, getValue("ErrormsgxxxxxTerminatedLesserDate"));
				return null;
			}

		}

		return account;
	}

	public void displaySubscriptions(Account account, char mode){
		
		if(mode == Subscription.MODIFY || mode == Subscription.ADD){
			enableComponents();
		}
		else if (mode == Subscription.VIEW){
			disableComponents();			
		}
	
		if((account !=null) && account.getAccountNumber()!=null && account.getAccountNumber().trim().length()>0){
			accountNumTextField.setText(account.getAccountNumber());
			List<Subscription> subscriptionList = account.getSubscriptions();
			if(subscriptionList != null && !subscriptionList.isEmpty()){
				for(Subscription subscription: subscriptionList){
					List<Feature> featuresList = subscription.getFeatures();
					if(DIGITALPLAN.equalsIgnoreCase(subscription.getSubscriptionId())){
						DigitalVoice digitalSubscription = (DigitalVoice)subscription;
						digitalCheckBox.setSelected(true);
						digitalCheckBox.setEnabled(false);
						digitalDateCommencedTextField.setText(digitalSubscription.getDateCommenced());
						if(digitalSubscription.getDateTerminated() != null){
							digitalDateterminatedTextField.setText(digitalSubscription.getDateTerminated());
						}
						digitalVoiceTelNoTextField.setText(String.valueOf(digitalSubscription.getTelephoneNumber()));

						if(featuresList != null && !featuresList.isEmpty()){
							for(Feature feature:featuresList){
								if(DIGITAL_LOCAL.equalsIgnoreCase(feature.getFeatureId())){
									dlocalCheckBox.setSelected(true);
									dlocalCheckBox.setEnabled(false);
									dlocalDateCommencedTextField.setText(feature.getDateCommenced());
									if(feature.getDateTerminated() != null){
										dlocalDateterminatedTextField.setText(feature.getDateTerminated());
									}
									dlocalDateCommencedTextField.setEditable(false);
									dlocalDateterminatedTextField.setEditable(false);
								}else if(DIGITAL_IDD.equalsIgnoreCase(feature.getFeatureId())){
									dIDDCheckBox.setSelected(true);
									dIDDCheckBox.setEnabled(false);
									dIDDDateCommencedTextField.setText(feature.getDateCommenced());
									if(feature.getDateTerminated() != null){
										dIDDDateterminatedTextField.setText(feature.getDateTerminated());
									}								
								}else if(DIGITAL_CALLTRANSFER.equalsIgnoreCase(feature.getFeatureId())){
									dcallTransferCheckBox.setSelected(true);
									dcallTransferCheckBox.setEnabled(false);
									dCallTrfrDateCommencedTextField.setText(feature.getDateCommenced());
									if(feature.getDateTerminated() != null){
										dCallTrfrDateterminatedTextField.setText(feature.getDateTerminated());
									}								
								}
							}
						}

					}else if(MOBILEPLAN.equalsIgnoreCase(subscription.getSubscriptionId())){
						MobileVoice mobileSubscription = (MobileVoice)subscription;
						mobileCheckBox.setSelected(true);
						mobileCheckBox.setEnabled(false);
						mobileDateCommencedTextField.setText(subscription.getDateCommenced());
						if(subscription.getDateTerminated() != null){
							mobileDateterminatedTextField.setText(subscription.getDateTerminated());
						}			
						mobileTelNoTextField.setText(String.valueOf(mobileSubscription.getTelephoneNumber()));
						if(featuresList != null && !featuresList.isEmpty()){
							for(Feature feature:featuresList){
								if(MOBILE_LOCAL.equalsIgnoreCase(feature.getFeatureId())){
									mlocalCheckBox.setSelected(true);
									mlocalCheckBox.setEnabled(false);
									mlocalDateCommencedTextField.setText(feature.getDateCommenced());
									if(feature.getDateTerminated() != null){
										mlocalDateterminatedTextField.setText(feature.getDateTerminated());
									}
									mlocalDateCommencedTextField.setEditable(false);
									mlocalDateterminatedTextField.setEditable(false);
								}else if(MOBILE_IDD.equalsIgnoreCase(feature.getFeatureId())){
									mIDDCheckBox.setSelected(true);
									mIDDCheckBox.setEnabled(false);
									mIDDDateCommencedTextField.setText(feature.getDateCommenced());
									if(feature.getDateTerminated() != null){
										mIDDDateterminatedTextField.setText(feature.getDateTerminated());
									}								
								}else if(MOBILE_DATASERVICES.equalsIgnoreCase(feature.getFeatureId())){
									mDataserviceCheckBox.setSelected(true);
									mDataserviceCheckBox.setEnabled(false);
									mDSDateCommencedTextField.setText(feature.getDateCommenced());
									if(feature.getDateTerminated() != null){
										mDSDateterminatedTextField.setText(feature.getDateTerminated());
									}								
								}
								else if(MOBILE_ROAMING.equalsIgnoreCase(feature.getFeatureId())){
									mRoamingCheckBox.setSelected(true);
									mRoamingCheckBox.setEnabled(false);
									mRoamingDateCommencedTextField.setText(feature.getDateCommenced());
									if(feature.getDateTerminated() != null){
										mRoamingDateterminatedTextField.setText(feature.getDateTerminated());
									}								
								}
							}
						}				

					}else if(CABLETV.equalsIgnoreCase(subscription.getSubscriptionId())){
						CableTv cableSubscription = (CableTv)subscription;
						cableCheckBox.setSelected(true);
						cableCheckBox.setEnabled(false);
						cableDateCommencedTextField.setText(subscription.getDateCommenced());
						if(subscription.getDateTerminated() != null){
							cableDateterminatedTextField.setText(subscription.getDateTerminated());
						}	

						if(featuresList != null && !featuresList.isEmpty()){
							for(Feature feature:featuresList){
								if(STANDARDCHANNELS.equalsIgnoreCase(feature.getFeatureId())){
									stdChannelsCheckBox.setSelected(true);
									stdChannelsCheckBox.setEnabled(false);
									cableStdDateCommencedTextField.setText(feature.getDateCommenced());
									if(feature.getDateTerminated() != null){
										cableStdDateterminatedTextField.setText(feature.getDateTerminated());
									}								
									cableStdDateCommencedTextField.setEditable(false);
									cableStdDateterminatedTextField.setEditable(false);							
								}else if(ADDITIONALCHANNELS.equalsIgnoreCase(feature.getFeatureId())){
									addnlChannelsCheckBox.setSelected(true);
									addnlChannelsCheckBox.setEnabled(false);
									cableAddnlDateCommencedTextField.setText(feature.getDateCommenced());
									if(feature.getDateTerminated() != null){
										cableAddnlDateterminatedTextField.setText(feature.getDateTerminated());
									}	
									cableAddlChannelsCountTextField.setText(String.valueOf(cableSubscription.getAdditionalChannels()));
								}
							}
						}						
					}
				}
			}
		}
		
	}
	private String handleCheckBoxAction(BTSCheckBox checkBox, BTSTextField textField){

		String returnString=EMPTY_STRING;
		if(checkBox.isSelected()){
			DateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			returnString = sdf.format(new Date());
			textField.setEditable(true);
		}else{
			textField.setEditable(true);
		}
		textField.setText(returnString);

		return returnString;
	}

	/**
	 * @Description Adds listener to the buttons and text fields
	 */
	private void addActionListeners() {
		subscriptionListener = new SubscriptionActionListener();

		addSubscriptionButton.addActionListener(subscriptionListener);

		//		digitalVoiceTelNoTextField.addActionListener(subscriptionListener);
		//		mobileTelNoTextField.addActionListener(subscriptionListener);
		//		digitalDateCommencedTextField.addActionListener(subscriptionListener);
		//		digitalDateterminatedTextField.addActionListener(subscriptionListener);
		//		dlocalDateCommencedTextField.addActionListener(subscriptionListener);
		//		dlocalDateterminatedTextField.addActionListener(subscriptionListener);
		//		dIDDDateCommencedTextField.addActionListener(subscriptionListener);
		//		dIDDDateterminatedTextField.addActionListener(subscriptionListener);
		//		dCallTrfrDateCommencedTextField.addActionListener(subscriptionListener);
		//		dCallTrfrDateterminatedTextField.addActionListener(subscriptionListener);
		//		mobileDateCommencedTextField.addActionListener(subscriptionListener);
		//		mobileDateterminatedTextField.addActionListener(subscriptionListener);
		//		mlocalDateCommencedTextField.addActionListener(subscriptionListener);
		//		mlocalDateterminatedTextField.addActionListener(subscriptionListener);
		//		mIDDDateCommencedTextField.addActionListener(subscriptionListener);
		//		mIDDDateterminatedTextField.addActionListener(subscriptionListener);
		//		mDSDateCommencedTextField.addActionListener(subscriptionListener);
		//		mDSDateterminatedTextField.addActionListener(subscriptionListener);
		//		cableDateCommencedTextField.addActionListener(subscriptionListener);
		//		cableDateterminatedTextField.addActionListener(subscriptionListener);
		//		cableStdDateCommencedTextField.addActionListener(subscriptionListener);
		//		cableStdDateterminatedTextField.addActionListener(subscriptionListener);
		//		cableAddnlDateCommencedTextField.addActionListener(subscriptionListener);
		//		cableAddnlDateterminatedTextField.addActionListener(subscriptionListener);
		//		cableAddlChannelsCountTextField.addActionListener(subscriptionListener);

		digitalCheckBox.addActionListener(subscriptionListener);
		mobileCheckBox.addActionListener(subscriptionListener);
		cableCheckBox.addActionListener(subscriptionListener);
		dlocalCheckBox.addActionListener(subscriptionListener);
		dIDDCheckBox.addActionListener(subscriptionListener);
		dcallTransferCheckBox.addActionListener(subscriptionListener);
		mlocalCheckBox.addActionListener(subscriptionListener);
		mIDDCheckBox.addActionListener(subscriptionListener);
		mRoamingCheckBox.addActionListener(subscriptionListener);
		mDataserviceCheckBox.addActionListener(subscriptionListener);
		stdChannelsCheckBox.addActionListener(subscriptionListener);
		addnlChannelsCheckBox.addActionListener(subscriptionListener);	
		closeButton.addActionListener(subscriptionListener);
	}

	/**
	 * @Description Removes listener from the button
	 */
	private void removeActionListeners() {

		addSubscriptionButton.removeActionListener(subscriptionListener);
		digitalVoiceTelNoTextField.removeActionListener(subscriptionListener);
		mobileTelNoTextField.removeActionListener(subscriptionListener);
		digitalDateCommencedTextField.removeActionListener(subscriptionListener);
		digitalDateterminatedTextField.removeActionListener(subscriptionListener);
		dlocalDateCommencedTextField.removeActionListener(subscriptionListener);
		dlocalDateterminatedTextField.removeActionListener(subscriptionListener);
		dIDDDateCommencedTextField.removeActionListener(subscriptionListener);
		dIDDDateterminatedTextField.removeActionListener(subscriptionListener);
		dCallTrfrDateCommencedTextField.removeActionListener(subscriptionListener);
		dCallTrfrDateterminatedTextField.removeActionListener(subscriptionListener);
		mobileDateCommencedTextField.removeActionListener(subscriptionListener);
		mobileDateterminatedTextField.removeActionListener(subscriptionListener);
		mlocalDateCommencedTextField.removeActionListener(subscriptionListener);
		mlocalDateterminatedTextField.removeActionListener(subscriptionListener);
		mIDDDateCommencedTextField.removeActionListener(subscriptionListener);
		mIDDDateterminatedTextField.removeActionListener(subscriptionListener);
		mDSDateCommencedTextField.removeActionListener(subscriptionListener);
		mDSDateterminatedTextField.removeActionListener(subscriptionListener);
		cableDateCommencedTextField.removeActionListener(subscriptionListener);
		cableDateterminatedTextField.removeActionListener(subscriptionListener);
		cableStdDateCommencedTextField.removeActionListener(subscriptionListener);
		cableStdDateterminatedTextField.removeActionListener(subscriptionListener);
		cableAddnlDateCommencedTextField.removeActionListener(subscriptionListener);
		cableAddnlDateterminatedTextField.removeActionListener(subscriptionListener);
		cableAddlChannelsCountTextField.removeActionListener(subscriptionListener);

		digitalCheckBox.removeActionListener(subscriptionListener);
		mobileCheckBox.removeActionListener(subscriptionListener);
		cableCheckBox.removeActionListener(subscriptionListener);
		dlocalCheckBox.removeActionListener(subscriptionListener);
		dIDDCheckBox.removeActionListener(subscriptionListener);
		dcallTransferCheckBox.removeActionListener(subscriptionListener);
		mlocalCheckBox.removeActionListener(subscriptionListener);
		mIDDCheckBox.removeActionListener(subscriptionListener);
		mRoamingCheckBox.removeActionListener(subscriptionListener);
		mDataserviceCheckBox.removeActionListener(subscriptionListener);
		stdChannelsCheckBox.removeActionListener(subscriptionListener);
		addnlChannelsCheckBox.removeActionListener(subscriptionListener);
		closeButton.removeActionListener(subscriptionListener);
	}

	public void addKeyListeners(){
		customKeyAdapter = new CustomKeyAdapter();

		digitalDateCommencedTextField.addKeyListener(customKeyAdapter);
		digitalDateterminatedTextField.addKeyListener(customKeyAdapter);
		mobileDateCommencedTextField.addKeyListener(customKeyAdapter);
		mobileDateterminatedTextField.addKeyListener(customKeyAdapter);
		cableDateCommencedTextField.addKeyListener(customKeyAdapter);
		cableDateterminatedTextField.addKeyListener(customKeyAdapter);
	}

	private String getValue(String key) {
		return propertyBundle.getValue(key);
	}

	public void destroy() {
		removeActionListeners();
		super.dispose();
	}

	private boolean isLater(String commenced, String terminated){
		if (terminated == null || terminated.trim().equals("")){
			return true;
		}
		SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");

		if (commenced.trim().length() != df.toPattern().length())
			return false;
		if (terminated.trim().length() != df.toPattern().length())
			return false;

		df.setLenient(false);

		//parse the inDate parameter
		try {
			Date d = df.parse(commenced.trim());
			Date d1 = df.parse(terminated.trim());
			if(d.before(d1)){
				return true;
			}
			else{
				return false;
			}
		} catch (java.text.ParseException e) {
			return false;
		}

		
	}


	private boolean isValidDate(String dateEntered, boolean isDateTerminated)  {
        
		if(isDateTerminated){
			if (dateEntered == null || dateEntered.trim().equals(""))
				return true;
		}
		else{
			if (dateEntered == null || dateEntered.trim().equals(""))
				return false;
		}

		//set the format to use as a constructor argument
		SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");

		if (dateEntered.trim().length() != df.toPattern().length())
			return false;

		df.setLenient(false);

		//parse the inDate parameter
		try {
			Date d = df.parse(dateEntered.trim());
			
		} catch (java.text.ParseException e) {
			return false;
		}
           return true;
	}
	
	
	private boolean isCommencedService(String feature, String service)  {
		
		SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
		

		if (feature.trim().length() != df.toPattern().length())
			return false;
		if (service.trim().length() != df.toPattern().length())
			return false;

		df.setLenient(false);

		//parse the inDate parameter
		try {
			Date d1 = df.parse(feature.trim());
			Date d2 = df.parse(service.trim());
			if(d2.before(d1)|| d2.equals(d1)){
				return true;
			}
			else {
				return false;
			}
			
		} catch (java.text.ParseException e) {
			return false;
		}
           
	}
	
private boolean isTerminatedService(String feature, String service)  {
		
		SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
		
		if (feature == null || feature.trim().equals(EMPTY_STRING))
			return true;
		
		if (service == null || service.trim().equals(EMPTY_STRING))
			return true;

		if (feature.trim().length() != df.toPattern().length())
			return false;
		if (service.trim().length() != df.toPattern().length())
			return false;

		df.setLenient(false);

		//parse the inDate parameter
		try {
			Date d1 = df.parse(feature.trim());
			Date d2 = df.parse(service.trim());
			if(d1.before(d2)|| d1.equals(d2)){
				return true;
			}
			else {
				return false;
			}
			
		} catch (java.text.ParseException e) {
			return false;
		}
           
	}
	

	private boolean isLong(String t){
		boolean isValidPh=true;
		try{
			
			Long.parseLong(t);
			if(t.length() <8){
				isValidPh= false;
			}
			
		}
		catch(NumberFormatException nfe){
			isValidPh=false;
		}
		return isValidPh;
	}
	
	private boolean isInt(String t){
		try{
			Integer.parseInt(t);
			return true;
		}
		catch(NumberFormatException nfe){
			return false;
		}
	}

	private void disableComponents(){
		accountNumTextField.setEditable(false);
		addSubscriptionButton.setEnabled(false);
		digitalVoiceTelNoTextField.setEditable(false);
		mobileTelNoTextField.setEditable(false);
		digitalDateCommencedTextField.setEditable(false);
		digitalDateterminatedTextField.setEditable(false);
		dlocalDateCommencedTextField.setEditable(false);
		dlocalDateterminatedTextField.setEditable(false);
		dIDDDateCommencedTextField.setEditable(false);
		dIDDDateterminatedTextField.setEditable(false);
		dCallTrfrDateCommencedTextField.setEditable(false);
		dCallTrfrDateterminatedTextField.setEditable(false);
		mobileDateCommencedTextField.setEditable(false);
		mobileDateterminatedTextField.setEditable(false);
		mlocalDateCommencedTextField.setEditable(false);
		mlocalDateterminatedTextField.setEditable(false);
		mIDDDateCommencedTextField.setEditable(false);
		mIDDDateterminatedTextField.setEditable(false);
		mDSDateCommencedTextField.setEditable(false);
		mDSDateterminatedTextField.setEditable(false);
		cableDateCommencedTextField.setEditable(false);
		cableDateterminatedTextField.setEditable(false);
		cableStdDateCommencedTextField.setEditable(false);
		cableStdDateterminatedTextField.setEditable(false);
		cableAddnlDateCommencedTextField.setEditable(false);
		cableAddnlDateterminatedTextField.setEditable(false);
		cableAddlChannelsCountTextField.setEditable(false);
		mRoamingDateCommencedTextField.setEditable(false);
		mRoamingDateterminatedTextField.setEditable(false);

		digitalCheckBox.setEnabled(false);
		mobileCheckBox.setEnabled(false);
		cableCheckBox.setEnabled(false);
		dlocalCheckBox.setEnabled(false);
		dIDDCheckBox.setEnabled(false);
		dcallTransferCheckBox.setEnabled(false);
		mlocalCheckBox.setEnabled(false);
		mRoamingCheckBox.setEnabled(false);
		mIDDCheckBox.setEnabled(false);
		mDataserviceCheckBox.setEnabled(false);
		stdChannelsCheckBox.setEnabled(false);
		addnlChannelsCheckBox.setEnabled(false);

	}

	public void enableComponents(){
		accountNumTextField.setEditable(false);
		addSubscriptionButton.setEnabled(true);
		digitalVoiceTelNoTextField.setEditable(true);
		mobileTelNoTextField.setEditable(true);
		digitalDateCommencedTextField.setEditable(true);
		digitalDateterminatedTextField.setEditable(true);
		dlocalDateCommencedTextField.setEditable(true);
		dlocalDateterminatedTextField.setEditable(true);
		dIDDDateCommencedTextField.setEditable(true);
		dIDDDateterminatedTextField.setEditable(true);
		dCallTrfrDateCommencedTextField.setEditable(true);
		dCallTrfrDateterminatedTextField.setEditable(true);
		mobileDateCommencedTextField.setEditable(true);
		mobileDateterminatedTextField.setEditable(true);
		mlocalDateCommencedTextField.setEditable(true);
		mlocalDateterminatedTextField.setEditable(true);
		mIDDDateCommencedTextField.setEditable(true);
		mIDDDateterminatedTextField.setEditable(true);
		mDSDateCommencedTextField.setEditable(true);
		mDSDateterminatedTextField.setEditable(true);
		cableDateCommencedTextField.setEditable(true);
		cableDateterminatedTextField.setEditable(true);
		cableStdDateCommencedTextField.setEditable(true);
		cableStdDateterminatedTextField.setEditable(true);
		cableAddnlDateCommencedTextField.setEditable(true);
		cableAddnlDateterminatedTextField.setEditable(true);
		cableAddlChannelsCountTextField.setEditable(true);
		mRoamingDateCommencedTextField.setEditable(true);
		mRoamingDateterminatedTextField.setEditable(true);

		digitalCheckBox.setEnabled(true);
		mobileCheckBox.setEnabled(true);
		cableCheckBox.setEnabled(true);
		dlocalCheckBox.setEnabled(true);
		dIDDCheckBox.setEnabled(true);
		dcallTransferCheckBox.setEnabled(true);
		mlocalCheckBox.setEnabled(true);
		mRoamingCheckBox.setEnabled(true);
		mIDDCheckBox.setEnabled(true);
		mDataserviceCheckBox.setEnabled(true);
		stdChannelsCheckBox.setEnabled(true);
		addnlChannelsCheckBox.setEnabled(true);
	}

	class CustomKeyAdapter extends KeyAdapter{
		public void keyReleased(KeyEvent ke){
			if (ke.getSource() == digitalDateCommencedTextField){
				dlocalDateCommencedTextField.setText(digitalDateCommencedTextField.getText());
			}
			else if(ke.getSource() == digitalDateterminatedTextField){
				dlocalDateterminatedTextField.setText(digitalDateterminatedTextField.getText());
			}
			else if(ke.getSource() == mobileDateCommencedTextField){
				mlocalDateCommencedTextField.setText(mobileDateCommencedTextField.getText());
			}
			else if(ke.getSource() == mobileDateterminatedTextField){
				mlocalDateterminatedTextField.setText(mobileDateterminatedTextField.getText());
			}
			else if(ke.getSource() == cableDateCommencedTextField){
				cableStdDateCommencedTextField.setText(cableDateCommencedTextField.getText());
			}
			else if(ke.getSource() == cableDateterminatedTextField){
				cableStdDateterminatedTextField.setText(cableDateterminatedTextField.getText());
			}

		}
	}
}