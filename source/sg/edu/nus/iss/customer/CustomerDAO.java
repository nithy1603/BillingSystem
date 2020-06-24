package sg.edu.nus.iss.customer;


import java.util.List;

import sg.edu.nus.iss.customer.Customer;


public interface CustomerDAO {

	public List<Customer> getMatchingCustomers(Customer customer);
	
	public String createCustomer(Customer customer);

	public void modifyCustomer(Customer customer);

	public List<Customer> getAllCustomers(); 
	
	public void validateCustomerNRIC(String custId, String nric) throws CustomerException;	
}
