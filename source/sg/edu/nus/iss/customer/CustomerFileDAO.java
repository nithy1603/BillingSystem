package sg.edu.nus.iss.customer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import sg.edu.nus.iss.customer.Customer;
import sg.edu.nus.iss.utility.BTSFileProcessor;
import sg.edu.nus.iss.utility.BTSKeyWords;



public class CustomerFileDAO implements CustomerDAO {

	private static final String CUSTOMERIDENTIFIER = "CI";
	private static final String ACCTIDENTIFIER = "AN";
	BTSFileProcessor btsSequenceFileProcessor 	= null;
	BTSFileProcessor btscustomerFileProcessor = null;
	public CustomerFileDAO() {

		try {
			btscustomerFileProcessor = new BTSFileProcessor(BTSKeyWords.CUSTOMER_TABLE,BTSKeyWords.CUST_COLUMN_COUNT);
			btsSequenceFileProcessor = new BTSFileProcessor(BTSKeyWords.SEQUENCE_TABLE, BTSKeyWords.ST_COLUMN_COUNT); 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Customer> getMatchingCustomers(Customer customer) {

		List<Customer> customers = new ArrayList<Customer>();

		String[] customerStringArray = getcustomerStringArray(customer);

		try {
			List<String[]> customerArrays = btscustomerFileProcessor.getMatchingRecords(customerStringArray);

			for(String[] customerArray : customerArrays) {
				customers.add(getCustomerObject(customerArray));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return customers;
	}

	private String[] getcustomerStringArray(Customer customer) {
		String[] returnArray = new String[BTSKeyWords.CUST_COLUMN_COUNT];

		if(customer != null) {
			if(customer.getCustomerId() != null && customer.getCustomerId().trim().length() > 0) {
				returnArray[BTSKeyWords.CUST_ID] = customer.getCustomerId().trim();
			}

			if(customer.getAccountNumber() != null && customer.getAccountNumber().trim().length() > 0) {
				returnArray[BTSKeyWords.CUST_ACCOUNT_NO] = customer.getAccountNumber().trim();
			}

			if(customer.getFirstName() != null && customer.getFirstName().trim().length() > 0) {
				returnArray[BTSKeyWords.CUST_FIRST_NAME] = customer.getFirstName().trim();
			}

			if(customer.getMiddleName() != null && customer.getMiddleName().trim().length() > 0) {
				returnArray[BTSKeyWords.CUST_MIDDLE_NAME] = customer.getMiddleName().trim();
			}

			if(customer.getLastName() != null && customer.getLastName().trim().length() > 0) {
				returnArray[BTSKeyWords.CUST_LAST_NAME] = customer.getLastName().trim();
			}

			if(customer.getNRIC() != null && customer.getNRIC().trim().length() > 0) {
				returnArray[BTSKeyWords.CUST_NRIC] = customer.getNRIC().trim();
			}

			if(customer.getAddressList1() != null && customer.getAddressList1().trim().length() > 0) {
				returnArray[BTSKeyWords.CUST_ADDR_LINE1] = customer.getAddressList1().trim();
			}

			if(customer.getAddressList2() != null && customer.getAddressList2().trim().length() > 0) {
				returnArray[BTSKeyWords.CUST_ADDR_LINE2] = customer.getAddressList2().trim();
			}

			if(customer.getCountry() != null && customer.getCountry().trim().length() > 0) {
				returnArray[BTSKeyWords.CUST_COUNTRY] = customer.getCountry().trim();
			}

			if(customer.getPostalCode() != 0 ) {
				returnArray[BTSKeyWords.CUST_POSTAL_CODE] = customer.getPostalCode()+ "";
			}

			if(customer.getContactNo() != 0) {
				returnArray[BTSKeyWords.CUST_CONTACT_NO] = customer.getContactNo()+ "";
			}

			if(customer.getEmailAddr() != null && customer.getEmailAddr().trim().length() > 0) {
				returnArray[BTSKeyWords.CUST_EMAIL_ADDR] = customer.getEmailAddr().trim();
			}

			if(customer.getInterests() != null) {
				returnArray[BTSKeyWords.CUST_INTERESTS] = customer.getInterests().trim();
			}

			if(customer.getAccountStatus() != null && customer.getAccountStatus().trim().length() > 0) {
				returnArray[BTSKeyWords.CUST_ACC_STAT] = customer.getAccountStatus().trim();
			}

			if(customer.getFromDate() != null && customer.getFromDate().trim().length() > 0) {
				returnArray[BTSKeyWords.CUST_FROMDATE] = customer.getFromDate().trim();
			} 

			if(customer.getToDate()!= null && customer.getToDate().trim().length() > 0) {
				returnArray[BTSKeyWords.CUST_TODATE] = customer.getToDate().trim();
			}
		}

		return returnArray;
	}

	private Customer getCustomerObject(String[] customerArray) {
		Customer customer = new Customer();

		for(int i = 0; i < customerArray.length; i++) {
			if(i == BTSKeyWords.CUST_ID) { 
				customer.setCustomerId(customerArray[i]);
			}
			else if(i == BTSKeyWords.CUST_ACCOUNT_NO) { 
				customer.setAccountNumber(customerArray[i]);
			}
			else if(i == BTSKeyWords.CUST_FIRST_NAME) {
				customer.setFirstName(customerArray[i]);
			}
			else if(i == BTSKeyWords.CUST_MIDDLE_NAME) {
				customer.setMiddleName(customerArray[i]);
			}
			else if(i == BTSKeyWords.CUST_LAST_NAME) {
				customer.setLastName(customerArray[i]);
			}
			else if(i == BTSKeyWords.CUST_NRIC) {
				customer.setNRIC(customerArray[i]);
			}
			else if(i == BTSKeyWords.CUST_ADDR_LINE1) {
				customer.setAddressList1(customerArray[i]);
			}
			else if(i == BTSKeyWords.CUST_ADDR_LINE2) {
				customer.setAddressList2(customerArray[i]);
			}
			else if(i == BTSKeyWords.CUST_COUNTRY) {
				customer.setCountry(customerArray[i]);
			}

			else if(i == BTSKeyWords.CUST_POSTAL_CODE) {
				customer.setPostalCode((Integer.parseInt(checkNull(customerArray[i]))));
			}
			else if(i == BTSKeyWords.CUST_CONTACT_NO) {
				customer.setContactNo((Integer.parseInt(checkNull(customerArray[i]))));
			}
			else if(i == BTSKeyWords.CUST_EMAIL_ADDR) {
				customer.setEmailAddr(customerArray[i]);
			}
			else if(i == BTSKeyWords.CUST_INTERESTS) {
				customer.setInterests(customerArray[i]);
			}
			else if(i == BTSKeyWords.CUST_ACC_STAT) {
				customer.setAccountStatus(customerArray[i]);
			}

			else if(i==BTSKeyWords.CUST_FROMDATE){
				customer.setFromDate(customerArray[i]);
			}
			else if(i==BTSKeyWords.CUST_TODATE){
				customer.setToDate(customerArray[i]);
			}
		}

		return customer;	
	}
	public String checkNull(Object obj){
		String returnStr="0";
		if(obj == null || obj.toString().trim().equals("")){
			returnStr = "0";
		}else{
			returnStr= obj.toString();
		}
		return returnStr;
	}
	public String createCustomer(Customer customer) {

		String[] custIdSequence = new String[BTSKeyWords.ST_COLUMN_COUNT];
		String[] accNoSequence = new String[BTSKeyWords.ST_COLUMN_COUNT];
		int nextSequence = 0;

		try {
			custIdSequence = btsSequenceFileProcessor.getMatchingRecord(BTSKeyWords.ST_SEQUENCE_ID, BTSKeyWords.CUSTOMERID_SEQUENCE);
			if(custIdSequence != null && custIdSequence.length == BTSKeyWords.ST_COLUMN_COUNT) {
				nextSequence = Integer.parseInt(custIdSequence[BTSKeyWords.ST_CURRENT_VALUE]) + 1;
				String custid = CUSTOMERIDENTIFIER + String.format("%05d", nextSequence);
				customer.setCustomerId(custid);
			}

			accNoSequence = btsSequenceFileProcessor.getMatchingRecord(BTSKeyWords.ST_SEQUENCE_ID, BTSKeyWords.ACCOUNTNO_SEQUENCE);
			if(accNoSequence != null && accNoSequence.length == BTSKeyWords.ST_COLUMN_COUNT) {
				nextSequence = Integer.parseInt(accNoSequence[BTSKeyWords.ST_CURRENT_VALUE]) + 1;
				String accountNumber = ACCTIDENTIFIER + String.format("%05d", nextSequence);
				customer.setAccountNumber(accountNumber);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		customer.setAccountStatus(Customer.STATUS_ACTIVE);
		String[] custStringArray = getcustomerStringArray(customer);

		try {
			btscustomerFileProcessor.insertRecord(custStringArray);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			String[] newSequence = new String[BTSKeyWords.ST_COLUMN_COUNT];
			newSequence[BTSKeyWords.ST_SEQUENCE_ID] = BTSKeyWords.CUSTOMERID_SEQUENCE;
			newSequence[BTSKeyWords.ST_CURRENT_VALUE] = (Integer.parseInt(custIdSequence[BTSKeyWords.ST_CURRENT_VALUE]) + 1) + "";

			btsSequenceFileProcessor.updateRecord(custIdSequence, newSequence);
			
			String[] newAccSequence = new String[BTSKeyWords.ST_COLUMN_COUNT];
			newAccSequence[BTSKeyWords.ST_SEQUENCE_ID] = BTSKeyWords.ACCOUNTNO_SEQUENCE;
			newAccSequence[BTSKeyWords.ST_CURRENT_VALUE] = (Integer.parseInt(accNoSequence[BTSKeyWords.ST_CURRENT_VALUE]) + 1) + "";

			btsSequenceFileProcessor.updateRecord(accNoSequence, newAccSequence);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		return customer.getCustomerId();

	}

	public void modifyCustomer(Customer customer) {
		String[] customerStringArray = getcustomerStringArray(customer);

		try {
			btscustomerFileProcessor.updateRecord(BTSKeyWords.CUST_ID, customerStringArray);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Customer> getAllCustomers() {
		List<Customer> customers = new ArrayList<Customer>();
		try {
			List<String[]> customerArrays = btscustomerFileProcessor.getAllRecords();

			for(String[] customerArray : customerArrays) {
				customers.add(getCustomerObject(customerArray));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return customers;
	}
	
	public void validateCustomerNRIC(String custId, String nric) throws CustomerException {
		String[] customerStringArray = new String[BTSKeyWords.UT_COLUMN_COUNT];
		customerStringArray[BTSKeyWords.CUST_NRIC] = nric.trim();

		try {
			List<String[]> customerArrays = btscustomerFileProcessor.getMatchingRecords(customerStringArray);

			if(customerArrays != null && customerArrays.size() > 0) {
				if(custId != null && custId.trim().length() > 0) {
					if(!custId.trim().equals((customerArrays.get(0))[BTSKeyWords.CUST_ID])) {
						throw new CustomerException(CustomerException.DUPLICATE_NRIC);
					}
				}
				else {
					throw new CustomerException(CustomerException.DUPLICATE_NRIC);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
