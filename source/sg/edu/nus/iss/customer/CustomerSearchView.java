package sg.edu.nus.iss.customer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import sg.edu.nus.iss.subscription.Account;
import sg.edu.nus.iss.subscription.Subscription;
import sg.edu.nus.iss.subscription.SubscriptionProxy;
import sg.edu.nus.iss.system.ApplicationMaster;
import sg.edu.nus.iss.utility.BTSButton;
import sg.edu.nus.iss.utility.BTSComboBox;
import sg.edu.nus.iss.utility.BTSDate;
import sg.edu.nus.iss.utility.BTSInternalFrame;
import sg.edu.nus.iss.utility.BTSLabel;
import sg.edu.nus.iss.utility.BTSPanel;
import sg.edu.nus.iss.utility.BTSPropertyBundle;
import sg.edu.nus.iss.utility.BTSScrollPane;
import sg.edu.nus.iss.utility.BTSTable;
import sg.edu.nus.iss.utility.BTSTextField;


public class CustomerSearchView extends BTSInternalFrame {

	//Screen size declarations
	private final int SCREENWIDTH = 750;
	private final int SCREENHEIGHT = 580;

	private static final String MODULE = "Customer";

	private static final int CUST_ID = 0;
	private static final int CUST_ACOUNT_NO = 1;
	private static final int CUST_FULL_NAME = 2;
	private static final int CUST_NRIC_NO = 3;
	private static final int CUST_ACC_STAT= 4;
	private static final int CUST_TABLE_CUST_OBJ = 5;

	private BTSPropertyBundle propertyBundle = null;

	// Button Declarations for Customer Search Screen
	private BTSButton createNewCustomerButton		        = null;
	private BTSButton closeButton 				            = null;
	private BTSButton customerListButton               		= null;
	private BTSButton activateCustomerButton            	= null;
	private BTSButton deactivateCustomerButton 		        = null;
	private BTSButton modifyButton              			= null;
	private BTSButton viewButton                			= null;
	private BTSButton manageSubscriptionButton              = null;

	//TextField Declarations for Customer Search Screen
	private BTSTextField firstNameTextField					= null;
	private BTSTextField middleNameTextField				= null;
	private BTSTextField lastNameTextField					= null;
	private BTSTextField NRICTextField						= null;
	private BTSTextField customerIdTextField				= null;
	private BTSTextField accountNumberTextField				= null;
	private BTSTable customerListTable 						= null;
	private DefaultTableModel customerListTableModel		= null;
	private BTSDate btsDate;
	//Combo box declarations
	private BTSComboBox customerStatus						= null;

	private CustomerController customerController 			= null;
	private CustomerActionListener customerActionListener 	= null;
	
	private String loginRole 								= null;
	//private MainScreen mainScreen							= null;

	//Implementations for Customer Search View
	CustomerSearchView() {
		btsDate = new BTSDate();
		setSize(SCREENWIDTH, SCREENHEIGHT);
		propertyBundle = new BTSPropertyBundle(MODULE);
		createGUIComponents();//
		addActionListeners();
	}

	private void priviledge() {
	
			modifyButton.setEnabled(true);
			activateCustomerButton.setEnabled(true);
			deactivateCustomerButton.setEnabled(true);
			createNewCustomerButton.setEnabled(true);
			createNewCustomerButton.setEnabled(true);
			manageSubscriptionButton.setText(getValue("VALbtnxxxxx002ManageSubscriptions"));
		
	}

	void setController(CustomerController customerController) {
		this.customerController = customerController;
		priviledge();
	}

	private void createGUIComponents() {

		BTSPanel mainPanel = new BTSPanel();
		mainPanel.setSize(SCREENWIDTH, SCREENHEIGHT);
		add(mainPanel);

		createNewCustomerButton = new BTSButton();
		createNewCustomerButton.setText(getValue("VALbtnxxxxx002CreateNewCustomer"));
		createNewCustomerButton.setBounds(15, 20, 140, 20);
		mainPanel.add(createNewCustomerButton);

		closeButton = new BTSButton();
		closeButton.setText(getValue("VALbtnxxxxx002Close"));
		closeButton.setBounds(160, 20, 95, 20);
		mainPanel.add(closeButton);

		BTSPanel searchPanel = new BTSPanel(getValue("VALlblxxxxx002CustomerSearch"));
		searchPanel.setBounds(15, 50, SCREENWIDTH - 40, 150);
		mainPanel.add(searchPanel);

		BTSLabel customerIdLabel = new BTSLabel(getValue("VALlblxxxxx002CustomerId"));
		customerIdLabel.setBounds(5, 20, 100, 20);
		searchPanel.add(customerIdLabel);

		customerIdTextField	= new BTSTextField(10,BTSTextField.UPPER);
		customerIdTextField.setBounds(110, 20, 150, 20);
		searchPanel.add(customerIdTextField);

		BTSLabel NRICLabel = new BTSLabel(getValue("VALlblxxxxx002NRIC"));
		NRICLabel.setBounds(440, 20, 75, 20);
		searchPanel.add(NRICLabel);

		NRICTextField	= new BTSTextField(10,BTSTextField.UPPER);
		NRICTextField.setBounds(520, 20, 150, 20);
		searchPanel.add(NRICTextField);

		BTSLabel firstNameLabel = new BTSLabel(getValue("VALlblxxxxx002Firstname"));
		firstNameLabel.setBounds(5, 50, 100, 20);
		searchPanel.add(firstNameLabel);

		firstNameTextField	= new BTSTextField(30);
		firstNameTextField.setBounds(110, 50, 150, 20);
		searchPanel.add(firstNameTextField);

		BTSLabel middleNameLabel = new BTSLabel(getValue("VALlblxxxxx002Middlename"));
		middleNameLabel.setBounds(440, 50, 75, 20);
		searchPanel.add(middleNameLabel);

		middleNameTextField	= new BTSTextField(30);
		middleNameTextField.setBounds(520, 50, 150, 20);
		searchPanel.add(middleNameTextField);

		BTSLabel lastNameLabel = new BTSLabel(getValue("VALlblxxxxx002Lastname"));
		lastNameLabel.setBounds(5, 80, 100, 20);
		searchPanel.add(lastNameLabel);

		lastNameTextField = new BTSTextField(30);
		lastNameTextField.setBounds(110, 80, 150, 20);
		searchPanel.add(lastNameTextField);

		BTSLabel customerStatusLabel = new BTSLabel(getValue("VALlblxxxxx002Customestatus"));
		customerStatusLabel.setBounds(5, 110, 100, 20);
		searchPanel.add(customerStatusLabel);

		customerStatus = new BTSComboBox(); 
		customerStatus.addItem("");
		customerStatus.addItem("Active");
		customerStatus.addItem("Inactive");
		customerStatus.setBounds(110, 110, 150, 20);
		searchPanel.add(customerStatus);

		BTSLabel accountNumberLabel = new BTSLabel(getValue("VALlblxxxxx002CustomerAccountNumber"));
		accountNumberLabel.setBounds(360, 80, 150, 20);
		searchPanel.add(accountNumberLabel);

		accountNumberTextField = new BTSTextField(10,BTSTextField.UPPER);
		accountNumberTextField.setBounds(520,80,150,20);
		searchPanel.add(accountNumberTextField);

		customerListButton = new BTSButton();
		customerListButton.setText(getValue("VALbtnxxxxx002CustomerList"));
		customerListButton.setBounds(445, 120, 120, 20);
		searchPanel.add(customerListButton);

		modifyButton = new BTSButton();
		modifyButton.setText(getValue("VALbtnxxxxx002Modify"));
		modifyButton.setBounds(15, 210, 95, 20);
		mainPanel.add(modifyButton);

		viewButton = new BTSButton();
		viewButton.setText(getValue("VALbtnxxxxx002View"));
		viewButton.setBounds(120, 210, 95, 20);
		mainPanel.add(viewButton);

		activateCustomerButton = new BTSButton();
		activateCustomerButton.setText(getValue("VALbtnxxxxx002RegisterCustomer"));
		activateCustomerButton.setBounds(225, 210, 120, 20);
		mainPanel.add(activateCustomerButton);

		deactivateCustomerButton = new BTSButton();
		deactivateCustomerButton.setText(getValue("VALbtnxxxxx002DeRegisterCustomer"));
		deactivateCustomerButton.setBounds(360, 210, 150, 20);
		mainPanel.add(deactivateCustomerButton);

		manageSubscriptionButton = new BTSButton();
		manageSubscriptionButton.setText(getValue("VALbtnxxxxx002ManageSubscriptions"));
		manageSubscriptionButton.setBounds(520, 210, 150, 20);
		mainPanel.add(manageSubscriptionButton);

		BTSPanel resultTablePanel = new BTSPanel(getValue("VALlblxxxxx002Customerlist"));
		resultTablePanel.setBounds(15, 240, SCREENWIDTH - 40, 270);
		mainPanel.add(resultTablePanel);

		setUpResultTable();

		BTSScrollPane resultScrollPane = new BTSScrollPane();
		resultScrollPane.setBounds(10, 20, resultTablePanel.getWidth() - 20, resultTablePanel.getHeight() - 30);
		resultScrollPane.setVerticalScrollBarPolicy(javax.swing.JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		resultScrollPane.getViewport().add(customerListTable);

		resultTablePanel.add(resultScrollPane);
	}

	private void setUpResultTable() {
		Vector<String> headingCustomer = new Vector<String>();
		headingCustomer.addElement(getValue("VALlblxxxxx002CustomerId"));
		headingCustomer.addElement(getValue("VALlblxxxxx002CustomerAccountNumber"));
		headingCustomer.addElement(getValue("VALlblxxxxx002FullName"));
		headingCustomer.addElement(getValue("VALlblxxxxx002NRIC"));
		headingCustomer.addElement(getValue("VALlblxxxxx002Customestatus"));
		//Hidden Coloumn
		headingCustomer.addElement("Customer Object");

		customerListTable = new BTSTable() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		customerListTableModel = new DefaultTableModel(new Vector(), headingCustomer);
		customerListTable.setModel(customerListTableModel);
		customerListTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		customerListTable.getTableHeader().setReorderingAllowed(false);

		customerListTable.getColumnModel().getColumn(CUST_ID).setWidth(75);
		customerListTable.getColumnModel().getColumn(CUST_ID).setPreferredWidth(75);

		customerListTable.getColumnModel().getColumn(CUST_ACOUNT_NO).setWidth(75);
		customerListTable.getColumnModel().getColumn(CUST_ACOUNT_NO).setPreferredWidth(75);

		customerListTable.getColumnModel().getColumn(CUST_FULL_NAME).setWidth(200);
		customerListTable.getColumnModel().getColumn(CUST_FULL_NAME).setPreferredWidth(200);

		customerListTable.getColumnModel().getColumn(CUST_NRIC_NO).setWidth(75);
		customerListTable.getColumnModel().getColumn(CUST_NRIC_NO).setPreferredWidth(75);

		customerListTable.getColumnModel().getColumn(CUST_ACC_STAT).setWidth(75);
		customerListTable.getColumnModel().getColumn(CUST_ACC_STAT).setPreferredWidth(75);

		customerListTable.removeColumn(customerListTable.getColumnModel().getColumn(CUST_TABLE_CUST_OBJ));

	}

	private void addActionListeners() {
		customerActionListener = new CustomerActionListener();

		createNewCustomerButton.addActionListener(customerActionListener);
		closeButton.addActionListener(customerActionListener);
		customerListButton.addActionListener(customerActionListener);
		modifyButton.addActionListener(customerActionListener);
		viewButton.addActionListener(customerActionListener);
		activateCustomerButton.addActionListener(customerActionListener);
		deactivateCustomerButton.addActionListener(customerActionListener);
		manageSubscriptionButton.addActionListener(customerActionListener);
	}

	private void removeActionListeners() {
		createNewCustomerButton.removeActionListener(customerActionListener);
		closeButton.removeActionListener(customerActionListener);
		customerListButton.removeActionListener(customerActionListener);
		modifyButton.removeActionListener(customerActionListener);
		viewButton.removeActionListener(customerActionListener);
		activateCustomerButton.removeActionListener(customerActionListener);
		deactivateCustomerButton.removeActionListener(customerActionListener);
		manageSubscriptionButton.addActionListener(customerActionListener);
	}

	private class CustomerActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(createNewCustomerButton)) {
				customerController.displayDetailsView(CustomerDetailsView.ADD, null);
			}
			else if(e.getSource().equals(closeButton)) {
				customerController.disposeSearchView();
			}
			else if(e.getSource().equals(customerListButton)) {
				customerController.listCustomers();
			}
			else if(e.getSource().equals(modifyButton)) {
				Customer customer = getSelectedCustomer();
				if(customer != null) {
					customerController.displayDetailsView(CustomerDetailsView.MODIFY, customer);
				}
				else {
					showMessage(MSG_ERROR, getValue("ERRmsgxxxxx003SelectCustomer"));
				}
			}
			else if(e.getSource().equals(viewButton)) {
				Customer customer = getSelectedCustomer();
				if(customer != null) {
				customerController.displayDetailsView(CustomerDetailsView.VIEW, customer);
				}
				else {
					showMessage(MSG_ERROR, getValue("ERRmsgxxxxx003SelectCustomer"));
				}
			}
			else if(e.getSource().equals(activateCustomerButton)) {
				Customer customer = getSelectedCustomer();
				if(customer!=null){	
					if(Customer.STATUS_ACTIVE.equals(customer.getAccountStatus())){
						showMessage(MSG_INFORMATION, getValue("INFmsgxxxxx003ActiveCustomer"));	
					}
					else {
						int i = showMessage(MSG_QUESTION, getValue("INFmsgxxxxx003ActivateCustomer"));
						if(i == 0) {
							customer.setAccountStatus(Customer.STATUS_ACTIVE);
							customer.setFromDate(btsDate.getCurrentDate());
							customer.setToDate(null);
							customerController.activateCustomer(customer);
						}
					}
				}
				else{
					showMessage(MSG_ERROR, getValue("ERRmsgxxxxx003SelectCustomer"));
				}
			}
			else if(e.getSource().equals(deactivateCustomerButton)) {
				Customer customer = getSelectedCustomer();
				if(customer!=null){	
					if( Customer.STATUS_INACTIVE.equals(customer.getAccountStatus())){
						showMessage(MSG_INFORMATION, getValue("INFmsgxxxxx003InactiveCustomer"));

					}
					else {
						int i= showMessage(MSG_QUESTION, getValue("INFmsgxxxxx003InactivateCustomer"));
						if(i == 0) {
							customer.setAccountStatus(Customer.STATUS_INACTIVE);
							customer.setToDate(btsDate.getCurrentDate());
							customerController.deactivateCustomer(customer);
						}
					}
				}
				else{
					showMessage(MSG_ERROR, getValue("ERRmsgxxxxx003SelectCustomer"));
				}
			}
			else if(e.getSource().equals(manageSubscriptionButton)) {
				Customer customer = getSelectedCustomer();
				if(customer != null) {
					Account account = new Account();
					account.setAccountNumber(customer.getAccountNumber());
					
						SubscriptionProxy.getInstance().displaySubscriptionView(account, Subscription.MODIFY);

				}
				else {
					showMessage(MSG_ERROR, getValue("ERRmsgxxxxx003SelectCustomer"));
				}
			}
		}    	
	}
	Customer getSearchCriteria() {
		Customer customer = new Customer();

		if(customerIdTextField.getText().trim().length() > 0) {
			customer.setCustomerId(customerIdTextField.getText().trim());
		}

		if(NRICTextField.getText().trim().length() > 0) {
			customer.setNRIC(NRICTextField.getText().trim());
		}

		if(accountNumberTextField.getText().trim().length() > 0) {
			customer.setAccountNumber(accountNumberTextField.getText().trim());
		}

		if(firstNameTextField.getText().trim().length() > 0) {
			customer.setFirstName(firstNameTextField.getText().trim());
		}

		if(middleNameTextField.getText().trim().length() > 0) {
			customer.setMiddleName(middleNameTextField.getText().trim());
		}

		if(lastNameTextField.getText().trim().length() > 0) {
			customer.setLastName(lastNameTextField.getText().trim());
		}

		if(customerStatus.getSelectedItem().toString().trim().length() > 0) {
			customer.setAccountStatus(customerStatus.getSelectedItem().toString().trim());
		}		

		return customer;
	}

	void populateListTable(List<Customer> customers) {

		clearMessage();
		for(int row = customerListTableModel.getRowCount() - 1; row >= 0; row--) {
			customerListTableModel.removeRow(row);
		}

		if(customers != null && customers.size() > 0) {
			Collections.sort(customers);
			for(Customer customer : customers) {				
				customerListTableModel.addRow(new Object[] {
						customer.getCustomerId(),
						customer.getAccountNumber(),
						customer.getLastName()+", "+customer.getFirstName()+" "+customer.getMiddleName(),
						customer.getNRIC(),
						customer.getAccountStatus(),
						customer
				});
			}

			showMessage(MSG_STATUS, getValue("INFmsgxxxxx003CustomersListedSuccessfully"));
		}
		else {
			showMessage(MSG_ERROR, getValue("ERRmsgxxxxx003NoCustomersMatching"));
		}
	}

	Customer getSelectedCustomer() {
		int selectedRow = customerListTable.getSelectedRow();

		if(selectedRow != -1) {
			return (Customer) customerListTableModel.getValueAt(selectedRow, CUST_TABLE_CUST_OBJ);
		}

		return null;
	}

	private String getValue(String key) {
		return propertyBundle.getValue(key);
	}

	public void destroy() {
		removeActionListeners();
		super.dispose();
	}
}
