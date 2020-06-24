package sg.edu.nus.iss.customer;


import java.text.MessageFormat;
import java.util.List;

import sg.edu.nus.iss.subscription.Account;
import sg.edu.nus.iss.subscription.Subscription;
import sg.edu.nus.iss.subscription.SubscriptionProxy;
import sg.edu.nus.iss.system.ApplicationMaster;
import sg.edu.nus.iss.utility.BTSInternalFrame;
import sg.edu.nus.iss.utility.BTSPropertyBundle;

class CustomerController extends BTSInternalFrame{

	private static final String MODULE = "Customer";

	private BTSPropertyBundle propertyBundle 			= null;
	private CustomerDetailsView customerDetailsView 	= null;
	private CustomerDAO customerDAO 					= null;
	private CustomerSearchView customerSearchView 		= null;

	CustomerController() {
		propertyBundle = new BTSPropertyBundle(MODULE);
		customerDAO = new CustomerFileDAO();
	}

	/** 
	 * This method, is used to display the CustomerDetailsScreen.
	 * @return CustomerDetailsView
	 */
	public CustomerDetailsView displayDetailsView(char mode, Customer customer) { 

		if(customerDetailsView == null) {
			customerDetailsView = new CustomerDetailsView() {
				public void cancelAction() {
					if(validateScreenBeforeClose()) {
						disposeDetailsView();
					}
				}
			};

			ApplicationMaster.addScreen(customerDetailsView);
		}

		customerDetailsView.setTitle(getValue("TTLscrxxxxx001CustomerDetailsScreen"));
		customerDetailsView.setScreenMode(mode);
		customerDetailsView.setController(this);

		if(mode != CustomerDetailsView.ADD && customer != null) {
			customerDetailsView.populateScreen(customer);
		}

		if(customerSearchView != null && customerSearchView.isVisible()) {
			customerSearchView.setVisible(false);
		}

		customerDetailsView.setVisible(true);
		return customerDetailsView;
	}

	/**
	 * This method, is used to dispose the CustomerDetailsScreen.
	 */
	public void disposeDetailsView() {
		if(customerDetailsView != null) {
			customerDetailsView.setVisible(false);
			ApplicationMaster.removeScreen(customerDetailsView);

			if(customerSearchView != null) {
				customerSearchView.setVisible(true);
			}

			customerDetailsView.destroy();
			customerDetailsView = null;
		}
	}

	/**
	 * This method, is used to display the CustomerSearchView.
	 * @return CustomerSearchView
	 */
	public CustomerSearchView displaySearchView() {

		if(customerSearchView == null) {
			customerSearchView = new CustomerSearchView() {
				public void cancelAction() {
					disposeSearchView();
				}
			};

			ApplicationMaster.addScreen(customerSearchView);
		}

		if(customerDetailsView != null && customerDetailsView.isVisible()) {
			customerDetailsView.setVisible(true);
		}
		else {
			customerSearchView.setTitle(getValue("TTLscrxxxxx001CustomerSearchScreen"));
			customerSearchView.setController(this);

			customerSearchView.setVisible(true);
		}

		return customerSearchView;
	}

	/**
	 * This method, is used to dispose the CustomerSearchView.
	 */
	public void disposeSearchView() {
		if(customerSearchView != null) {
			customerSearchView.setVisible(false);
			ApplicationMaster.removeScreen(customerSearchView);

			customerSearchView.destroy();
			customerSearchView = null;
		} 
	}

	void listCustomers() {
		Customer customer = customerSearchView.getSearchCriteria(); 

		List<Customer> customers = customerDAO.getMatchingCustomers(customer);		
		customerSearchView.populateListTable(customers);
	}

	public void createCustomer(Customer customer) {
		String custId = customerDAO.createCustomer(customer);
		if(custId != null) {
			listCustomers(); 
			disposeDetailsView();
			String[] arg = new String[] { custId };
			MessageFormat messageFormat	= new MessageFormat(getValue("INFmsgxxxxx003CustomerCreatedSuccessfully"));
			int i = showMessage(CustomerDetailsView.MSG_QUESTION, messageFormat.format(arg));
			if(i==0){
				Account account = new Account();
				account.setAccountNumber(customer.getAccountNumber());
				SubscriptionProxy.getInstance().displaySubscriptionView(account, Subscription.ADD);
			}
		}
	}
	public void modifyCustomer(Customer customer) {
		customerDAO.modifyCustomer(customer);
		if(customerSearchView != null) {
			listCustomers(); 
			customerSearchView.showMessage(CustomerSearchView.MSG_STATUS, getValue("INFmsgxxxxx003CustomerUpdatedSuccessfully"));
		}
	}

	public List<Customer> listAllCustomers(){
		List<Customer> customers = customerDAO.getAllCustomers();
		return customers;
	}


	public String getValue(String key) {
		return propertyBundle.getValue(key);
	}

	public void activateCustomer(Customer customer) {
		customerDAO.modifyCustomer(customer);
		listCustomers();
	}

	public void deactivateCustomer(Customer customer) {
		customerDAO.modifyCustomer(customer);
		listCustomers();
	}
	boolean validateCustomerNRIC(String custId, String nric) {
		try {
			customerDAO.validateCustomerNRIC(custId, nric);
		} catch (CustomerException e) {
			customerDetailsView.showMessage(CustomerDetailsView.MSG_ERROR, getValue("ERRmsgxxxxx004nric"));
			return true;
		}
		return false;
	}

}
