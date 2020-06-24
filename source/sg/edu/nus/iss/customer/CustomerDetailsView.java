package sg.edu.nus.iss.customer;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;

import sg.edu.nus.iss.utility.BTSButton;
import sg.edu.nus.iss.utility.BTSDate;
import sg.edu.nus.iss.utility.BTSInternalFrame;
import sg.edu.nus.iss.utility.BTSKeyWords;
import sg.edu.nus.iss.utility.BTSLabel;
import sg.edu.nus.iss.utility.BTSPanel;
import sg.edu.nus.iss.utility.BTSPropertyBundle;
import sg.edu.nus.iss.utility.BTSTextField;


public class CustomerDetailsView extends BTSInternalFrame{

	private final int SCREENWIDTH = 660;
	private final int SCREENHEIGHT = 580;

	private static final String MODULE = "Customer";

	public static final char ADD 		= 'A';
	public static final char MODIFY 	= 'M';
	public static final char VIEW 		= 'V';

	private static final String DELIM = "¢"; 

	private BTSPropertyBundle propertyBundle = null;

	private char mode;

	private BTSTextField customerIdTextField				= null;
	private BTSTextField firstNameTextField					= null;
	private BTSTextField middleNameTextField				= null;
	private BTSTextField lastNameTextField					= null;
	private BTSTextField nricTextField						= null;
	private BTSTextField customerAccountTextField			= null;
	private BTSTextField customerStatusTextField			= null;
	private BTSTextField addressL1TextField					= null;
	private BTSTextField addressL2TextField					= null;
	private BTSTextField contactNoTextField					= null;
	private BTSTextField emailIDTextField					= null;
	private BTSTextField countryTextField					= null;
	private BTSTextField postalcodeTextField				= null;
	private BTSButton saveButton							= null;
	private BTSTextField fromDateText						= null;
	private BTSTextField toDateText							= null;
	private JCheckBox interestsCheckbox						= null;
	private JCheckBox interestsCheckbox1					= null;
	private JCheckBox interestsCheckbox2					= null;
	private JCheckBox interestsCheckbox3					= null;
	//private JTextArea intereststextArea						=null;
	private BTSButton closeButton							= null;
	private CustomerActionListener customerActionListener	= null;
	private Customer oldcustomerInfo 						= null;
	private CustomerController customerController 			= null;

	private BTSDate btsDate;
	CustomerDetailsView() {
		setSize(SCREENWIDTH, SCREENHEIGHT);
		propertyBundle = new BTSPropertyBundle(MODULE);
		btsDate = new BTSDate();
		createGUIComponents();
		addActionListeners();
	}
	void setScreenMode(char mode) {
		this.mode = mode;

		if(mode == VIEW) {
			customerIdTextField.setEditable(false);
			customerAccountTextField.setEditable(false);
			customerStatusTextField.setEditable(false);
			firstNameTextField.setEditable(false);
			middleNameTextField.setEditable(false);
			lastNameTextField.setEditable(false);
			nricTextField.setEditable(false);
			contactNoTextField.setEditable(false);
			emailIDTextField.setEditable(false);
			addressL1TextField.setEditable(false);
			addressL2TextField.setEditable(false);
			postalcodeTextField.setEditable(false);
			countryTextField.setEditable(false);
			interestsCheckbox.setEnabled(false);
			interestsCheckbox1.setEnabled(false);
			interestsCheckbox2.setEnabled(false);
			interestsCheckbox3.setEnabled(false);
			fromDateText.setEditable(false);
			toDateText.setEditable(false);
			saveButton.setEnabled(false);
		}
		else {
			firstNameTextField.setMandatoryField(true);
			lastNameTextField.setMandatoryField(true);
			nricTextField.setMandatoryField(true);
			saveButton.setEnabled(true);
			oldcustomerInfo = getCustomerDetails(false);
		}
	}
	void setController(CustomerController customerController) {
		this.customerController = customerController;
	}

	private void createGUIComponents() {
		BTSPanel panel = new BTSPanel("");
		panel.setBounds(20, 20, SCREENWIDTH - 50, SCREENHEIGHT - 100);
		add(panel);

		BTSLabel customerIdLabel = new BTSLabel(getValue("VALlblxxxxx002CustomerId"));
		customerIdLabel.setBounds(25, 35, 95, 20);
		panel.add(customerIdLabel);

		customerIdTextField	= new BTSTextField(15,BTSTextField.UPPER);
		customerIdTextField.setBounds(130, 35, 150, 20);
		panel.add(customerIdTextField);
		customerIdTextField.setEditable(false);

		BTSLabel accountAccountNumberLabel = new BTSLabel(getValue("VALlblxxxxx002CustomerAccountNumber"));
		accountAccountNumberLabel.setBounds(275, 35, 150, 20);
		panel.add(accountAccountNumberLabel);

		customerAccountTextField = new BTSTextField(20,BTSTextField.UPPER);
		customerAccountTextField.setBounds(430, 35, 150, 20);
		panel.add(customerAccountTextField);
		customerAccountTextField.setEditable(false);

		BTSLabel customerStatusLabel = new BTSLabel(getValue("VALlblxxxxx002Customestatus"));
		customerStatusLabel.setBounds(25, 70, 95, 20);
		panel.add(customerStatusLabel);

		customerStatusTextField	= new BTSTextField(15);
		customerStatusTextField.setBounds(130, 70, 150, 20);
		customerStatusTextField.setEditable(false);
		panel.add(customerStatusTextField);

		BTSLabel firstNameLabel = new BTSLabel(getValue("VALlblxxxxx002Firstname"));
		firstNameLabel.setBounds(25, 120, 95, 20);
		panel.add(firstNameLabel);

		firstNameTextField	= new BTSTextField(30);
		firstNameTextField.setBounds(130, 120, 150, 20);
		panel.add(firstNameTextField);

		BTSLabel middleLabel = new BTSLabel(getValue("VALlblxxxxx002Middlename"));
		middleLabel.setBounds(275, 120, 150, 20);
		panel.add(middleLabel);

		middleNameTextField	= new BTSTextField(30);
		middleNameTextField.setBounds(430, 120, 150, 20);
		panel.add(middleNameTextField);

		BTSLabel lastLabel = new BTSLabel(getValue("VALlblxxxxx002Lastname"));
		lastLabel.setBounds(25, 150, 95, 20);
		panel.add(lastLabel);

		lastNameTextField = new BTSTextField(30);
		lastNameTextField.setBounds(130, 150, 150, 20);
		panel.add(lastNameTextField);

		BTSLabel nricLabel = new BTSLabel(getValue("VALlblxxxxx002NRIC"));
		nricLabel.setBounds(275, 155, 150, 20);
		panel.add(nricLabel);

		nricTextField	= new BTSTextField(10,BTSTextField.UPPER);
		nricTextField.setBounds(430, 155, 150, 20);
		panel.add(nricTextField);

		BTSLabel contactNoLabel = new BTSLabel(getValue("VALlblxxxxx002contactNumber"));
		contactNoLabel.setBounds(25, 190, 95, 20);
		panel.add(contactNoLabel);

		contactNoTextField = new BTSTextField(8,BTSTextField.INTEGER);
		contactNoTextField.setBounds(130, 190, 150, 20);
		panel.add(contactNoTextField);

		BTSLabel emailLabel = new BTSLabel(getValue("VALlblxxxxx002emailID"));
		emailLabel.setBounds(275, 190, 150, 20);
		panel.add(emailLabel);

		emailIDTextField = new BTSTextField(30);
		emailIDTextField.setBounds(430, 190, 150, 20);
		panel.add(emailIDTextField);

		BTSLabel address1Label = new BTSLabel(getValue("VALlblxxxxx002AddressL1"));
		address1Label.setBounds(25, 240, 95, 20);
		panel.add(address1Label);

		addressL1TextField = new BTSTextField(30);
		addressL1TextField.setBounds(130, 240, 350, 20);
		panel.add(addressL1TextField);

		BTSLabel address2Label = new BTSLabel(getValue("VALlblxxxxx002AddressL2"));
		address2Label.setBounds(25, 270, 95, 20);
		panel.add(address2Label);

		addressL2TextField = new BTSTextField(30);
		addressL2TextField.setBounds(130, 270, 350, 20);
		panel.add(addressL2TextField);

		BTSLabel postalCodeLabel = new BTSLabel(getValue("VALlblxxxxx002PostalCode"));
		postalCodeLabel.setBounds(25, 300, 95, 20);
		panel.add(postalCodeLabel);

		postalcodeTextField = new BTSTextField(8,BTSTextField.INTEGER);
		postalcodeTextField.setBounds(130, 300, 150, 20);
		panel.add(postalcodeTextField);

		BTSLabel countryLabel = new BTSLabel(getValue("VALlblxxxxx002Country"));
		countryLabel.setBounds(175, 300, 150, 20);
		panel.add(countryLabel);

		countryTextField = new BTSTextField(30);
		countryTextField.setBounds(330, 300, 150, 20);
		panel.add(countryTextField);

		BTSLabel interstsLabel = new BTSLabel(getValue("VALlblxxxxx002Interests"));
		interstsLabel.setBounds(25, 340, 95, 20);
		panel.add(interstsLabel);

		interestsCheckbox = new JCheckBox(getValue("VALlblxxxxx002PlayingGames"));
		interestsCheckbox.setBounds(125, 340, 150, 20);
		interestsCheckbox1 = new JCheckBox(getValue("VALlblxxxxx002Shopping"));
		interestsCheckbox1.setBounds(285, 340, 150, 20);
		interestsCheckbox2 = new JCheckBox(getValue("VALlblxxxxx002WatchingTv"));
		interestsCheckbox2.setBounds(125, 370, 150, 20);
		interestsCheckbox3 = new JCheckBox(getValue("VALlblxxxxx002ReadingBooks"));
		interestsCheckbox3.setBounds(285, 370, 150, 20);
		panel.add(interestsCheckbox);
		panel.add(interestsCheckbox1);
		panel.add(interestsCheckbox2);
		panel.add(interestsCheckbox3);

		BTSLabel fromDateLabel = new BTSLabel(getValue("VALlblxxxxx002FromDate"));
		fromDateLabel.setBounds(25, 400, 150, 20);
		panel.add(fromDateLabel);

		fromDateText = new BTSTextField(20);
		fromDateText.setBounds(180,400,95,20);
		panel.add(fromDateText);
		fromDateText.setEditable(false);

		BTSLabel toDateLabel = new BTSLabel(getValue("VALlblxxxxx002ToDate"));
		toDateLabel.setBounds(280, 400, 160, 20);
		panel.add(toDateLabel);

		toDateText = new BTSTextField(20);
		toDateText.setBounds(445,400,95,20);
		toDateText.setEditable(false);
		panel.add(toDateText);

		saveButton = new BTSButton();
		saveButton.setText(getValue("VALbtnxxxxx002Save"));
		saveButton.setBounds(230, 440, 50, 20);
		panel.add(saveButton);

		closeButton = new BTSButton();
		closeButton.setText(getValue("VALbtnxxxxx002Close"));
		closeButton.setBounds(300, 440, 50, 20);
		panel.add(closeButton);

	}

	private void addActionListeners() {
		customerActionListener = new CustomerActionListener();

		saveButton.addActionListener(customerActionListener);
		closeButton.addActionListener(customerActionListener);
	}

	private void removeActionListeners() {
		saveButton.removeActionListener(customerActionListener);
		closeButton.removeActionListener(customerActionListener);
	}

	private class CustomerActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			if(e.getSource().equals(saveButton)) {
				Customer customer = getCustomerDetails(true);

				if(customer != null) {
					if(mode == ADD) {
						customerController.createCustomer(customer);
				//		customerController.disposeDetailsView();
					}
					else if(mode == MODIFY) {
						if(customer.equals(oldcustomerInfo)) {
							showMessage(CustomerDetailsView.MSG_INFORMATION, getValue("INFmsgxxxxx003NoModification"));
							return;
						}

						customerController.modifyCustomer(customer);
						customerController.disposeDetailsView();
					}
				}
			}
			else if(e.getSource().equals(closeButton)) {

				if(validateScreenBeforeClose()) {
					customerController.disposeDetailsView();
				}
			}
		}
	}

	boolean validateScreenBeforeClose() {
		if(mode != VIEW) {
			Customer customer = getCustomerDetails(false);
			if(customer != null && !customer.equals(oldcustomerInfo)) {
				int value = showMessage(CustomerDetailsView.MSG_QUESTION, getValue("INFmsgxxxxx003Modificationnotsaved"));

				if(value != 0) {
					return false;
				}
			}
		}

		return true;
	}

	void populateScreen(Customer customer) {
		if(customer != null) {
			oldcustomerInfo = customer; 

			customerIdTextField.setText(customer.getCustomerId());
			customerAccountTextField.setText(customer.getAccountNumber());
			customerStatusTextField.setText(customer.getAccountStatus());
			firstNameTextField.setText(customer.getFirstName());
			middleNameTextField.setText(customer.getMiddleName());
			lastNameTextField.setText(customer.getLastName());
			nricTextField.setText(customer.getNRIC());
			contactNoTextField.setText(customer.getContactNo()+"");
			emailIDTextField.setText(customer.getEmailAddr());
			addressL1TextField.setText(customer.getAddressList1());
			addressL2TextField.setText(customer.getAddressList2());
			postalcodeTextField.setText(customer.getPostalCode()+"");
			countryTextField.setText(customer.getCountry());
			fromDateText.setText(customer.getFromDate());
			toDateText.setText(customer.getToDate());
			String interests  = customer.getInterests();
			String[] individualinterest = interests.split(DELIM);

			for(int i = 0; i < individualinterest.length; i++) {
				if(individualinterest[i] != null && individualinterest[i].trim().length() > 0) {

					if (individualinterest[i].trim().equals(getValue("VALlblxxxxx002PlayingGames"))){
						interestsCheckbox.setSelected(true);
					}
					else if (individualinterest[i].trim().equals(getValue("VALlblxxxxx002Shopping"))){
						interestsCheckbox1.setSelected(true);
					}
					else if (individualinterest[i].trim().equals(getValue("VALlblxxxxx002WatchingTv"))){
						interestsCheckbox2.setSelected(true);
					}
					else if (individualinterest[i].trim().equals(getValue("VALlblxxxxx002ReadingBooks"))){
						interestsCheckbox3.setSelected(true);
					}
				}
			}
		}
	}

	Customer getCustomerDetails(boolean validationNeeded) {
		Customer customer = null;

		if(!validationNeeded || validateCustomerDetails()) {
			customer = new Customer();
			customer.setCustomerId(customerIdTextField.getText().trim());
			customer.setAccountNumber(customerAccountTextField.getText().trim());
			customer.setAccountStatus(customerStatusTextField.getText().trim());
			customer.setFirstName(firstNameTextField.getText().trim());
			customer.setMiddleName(middleNameTextField.getText().trim());
			customer.setLastName(lastNameTextField.getText().trim());
			customer.setNRIC(nricTextField.getText().trim());
			customer.setContactNo(Integer.parseInt(checkNull(contactNoTextField.getText())));
			customer.setEmailAddr(emailIDTextField.getText().trim()); 	
			customer.setAddressList1(addressL1TextField.getText().trim());
			customer.setAddressList2(addressL2TextField.getText().trim());
			customer.setPostalCode(Integer.parseInt(checkNull(postalcodeTextField.getText().trim()+"")));
			customer.setCountry(countryTextField.getText().trim());
			if(mode==MODIFY){
				customer.setFromDate(fromDateText.getText().trim());
				if(!toDateText.getText().trim().isEmpty()){
					customer.setToDate(toDateText.getText().trim());
				}
			}
			else{
				customer.setFromDate(btsDate.getCurrentDate());
			}
			StringBuffer interests = new StringBuffer();

			if(interestsCheckbox.isSelected()) {
				interests.append(getValue("VALlblxxxxx002PlayingGames"));
			}

			interests.append(DELIM);

			if(interestsCheckbox1.isSelected()) {
				interests.append(getValue("VALlblxxxxx002Shopping"));
			}

			interests.append(DELIM);

			if(interestsCheckbox2.isSelected()) {
				interests.append(getValue("VALlblxxxxx002WatchingTv"));
			}	

			interests.append(DELIM);

			if(interestsCheckbox3.isSelected()) {
				interests.append(getValue("VALlblxxxxx002ReadingBooks"));
			}
			customer.setInterests(interests.toString());
		}
		return customer;

	}
	public String checkNull(Object obj){
		String returnStr ="0" ;
		if(obj == null || obj.toString().trim().equals("")){
			returnStr = "0";
		}else{
			returnStr= obj.toString().trim();
		}
		return returnStr;
	}
	private boolean validateCustomerDetails() {
		if(firstNameTextField.getText().trim().length() == 0) {
			showMessage(CustomerDetailsView.MSG_ERROR, getValue("ERRmsgxxxx004PleaseEnterFirstName"));
			firstNameTextField.requestFocus();
			return false;
		}
		else if(lastNameTextField.getText().trim().length() == 0) {
			showMessage(CustomerDetailsView.MSG_ERROR, getValue("ERRmsgxxxx004PleaseEnterLastName"));
			lastNameTextField.requestFocus();
			return false;
		}
		else if(nricTextField.getText().trim().length() == 0) {
			showMessage(CustomerDetailsView.MSG_ERROR, getValue("ERRmsgxxxx004PleaseEnterNRIC"));
			nricTextField.requestFocus();
			return false;
		}		
		else if(customerController.validateCustomerNRIC(customerIdTextField.getText().trim(), nricTextField.getText().trim())) {
			return false; 
		}
		return true;
	}

	public String getValue(String key) {
		return propertyBundle.getValue(key);
	}

	public void destroy() {
		removeActionListeners();
		super.dispose();
	}	
}