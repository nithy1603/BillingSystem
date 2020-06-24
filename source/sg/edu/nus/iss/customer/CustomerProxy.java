package sg.edu.nus.iss.customer;

import java.util.List;

public class CustomerProxy {

	/**
	 * Variable Declarations
	 */
	private static CustomerProxy customerProxy;
	private CustomerController customerController;
	private CustomerDetailsView customerDetailsView; 
	private CustomerSearchView customerSearchView;

	private CustomerProxy(){
		if(customerController == null) {
			customerController = new CustomerController();
		}
	}

	/**
	 * This method returns the instance of this class
	 */
	public static CustomerProxy getInstance()
	{
		if(customerProxy==null)
			customerProxy=new CustomerProxy(); 
		return customerProxy;
	}

	/**
	 * This method, is used to display the Customer search screen.
	 */
	public void displaySearchView() {
		customerSearchView = customerController.displaySearchView();  
	}
	
	public List<Customer> listAllCustomers(){
		List<Customer> customers = customerController.listAllCustomers();		
		return customers;
	}	

	/**
	 * This function sets all the object data members to null.
	 */
	public void destroy()
	{
		customerController = null;
		customerProxy = null;
		customerDetailsView = null;
	}

}
