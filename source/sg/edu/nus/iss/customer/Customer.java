package sg.edu.nus.iss.customer;



import java.lang.reflect.Field;
import java.util.ArrayList;



public class Customer extends Person implements Comparable<Customer>, Cloneable {
	
	private String customerId = null;
	private String accountNumber = null;
	private String addressList1 = null;
	private String addressList2 = null;
	private String country = null;
	private int postalCode;
	private int contactNo;
	private String emailAddr = null;
	private String interests = null;
	private String fromDate = null;
	private String toDate = null;
	
	public static final String STATUS_ACTIVE = "Active";
	public static final String STATUS_INACTIVE = "InActive";
	
	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAddressList1() {
		return addressList1;
	}

	public void setAddressList1(String addressList1) {
		this.addressList1 = addressList1;
	}

	public String getAddressList2() {
		return addressList2;
	}

	public void setAddressList2(String addressList2) {
		this.addressList2 = addressList2;
	}
	
	public String getCountry() { 
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public int getContactNo() {
		return contactNo;
	}

	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}
	
	public String getEmailAddr() {
		return emailAddr;
	}

	public void setEmailAddr(String emailAddr) {
		this.emailAddr = emailAddr;
	}
	public String getInterests() {
		return interests;
	}

	public void setInterests(String interests) {
		this.interests = interests;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	
	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public boolean equals(Object obj) {
		
		if(obj != null && obj instanceof Customer) {
			
			Customer customer = (Customer) obj;
			
			if( ((customerId == null && customer.getCustomerId() == null) || ((customerId != null && customer.getCustomerId() != null) && ((customerId.trim().length() == 0 && customer.getCustomerId().trim().length() == 0 ) || (customerId.trim().equals(customer.getCustomerId().trim())))))
					&& ((accountNumber == null && customer.getAccountNumber() == null) || ((accountNumber != null && customer.getAccountNumber() != null) && ((accountNumber.trim().length() == 0 && customer.getAccountNumber().trim().length() == 0 ) || (accountNumber.trim().equals(customer.getAccountNumber().trim())))))
					&& ((addressList1 == null && customer.getAddressList1() == null) || ((addressList1 != null && customer.getAddressList1() != null) && ((addressList1.trim().length() == 0 && customer.getAddressList1().trim().length() == 0 ) || (addressList1.trim().equals(customer.getAddressList1().trim())))))
					&& ((addressList2 == null && customer.getAddressList2() == null) || ((addressList2 != null && customer.getAddressList2() != null) && ((addressList2.trim().length() == 0 && customer.getAddressList2().trim().length() == 0 ) || (addressList2.trim().equals(customer.getAddressList2().trim())))))
					&& ((country == null && customer.getCountry() == null) || ((country != null && customer.getCountry() != null) && ((country.trim().length() == 0 && customer.getCountry().trim().length() == 0 ) || (country.trim().equals(customer.getCountry().trim())))))
					&& (postalCode == customer.getPostalCode()) && (contactNo == customer.getContactNo())
					&& ((emailAddr == null && customer.getEmailAddr() == null) || ((emailAddr != null && customer.getEmailAddr() != null) && ((emailAddr.trim().length() == 0 && customer.getEmailAddr().trim().length() == 0 ) || (emailAddr.trim().equals(customer.getEmailAddr().trim())))))
					&& ((interests ==null && customer.getInterests() == null) || ((interests != null && customer.getInterests() != null) && ((interests.trim().length() == 0 && customer.getInterests().trim().length() == 0 ) || (interests.trim().equals(customer.getInterests().trim())))))
					&& ((fromDate == null && customer.getFromDate() == null) || ((fromDate != null && customer.getFromDate() != null) && ((fromDate.trim().length() == 0 && customer.getFromDate().trim().length() == 0 ) || (fromDate.trim().equals(customer.getFromDate().trim())))))
					&& ((toDate == null && customer.getToDate() == null) || ((toDate != null && customer.getToDate() != null) && ((toDate.trim().length() == 0 && customer.getToDate().trim().length() == 0 ) || (toDate.trim().equals(customer.getToDate().trim())))))
					&& ((getFirstName() == null && customer.getFirstName() == null) || ((getFirstName() != null && customer.getFirstName() != null) && ((getFirstName().trim().length() == 0 && customer.getFirstName().trim().length() == 0 ) || (getFirstName().trim().equals(customer.getFirstName().trim())))))
					&& ((getLastName() == null && customer.getLastName() == null) || ((getLastName() != null && customer.getLastName() != null) && ((getLastName().trim().length() == 0 && customer.getLastName().trim().length() == 0 ) || (getLastName().trim().equals(customer.getLastName().trim())))))
					&& ((getMiddleName() == null && customer.getMiddleName() == null) || ((getMiddleName() != null && customer.getMiddleName() != null) && ((getMiddleName().trim().length() == 0 && customer.getMiddleName().trim().length() == 0 ) || (getMiddleName().trim().equals(customer.getMiddleName().trim())))))
					&& ((getNRIC() == null && customer.getNRIC() == null) || ((getNRIC() != null && customer.getNRIC() != null) && ((getNRIC().trim().length() == 0 && customer.getNRIC().trim().length() == 0 ) || (getNRIC().trim().equals(customer.getNRIC().trim())))))
					&& ((getAccountStatus() == null && customer.getAccountStatus() == null) || ((getAccountStatus() != null && customer.getAccountStatus() != null) && ((getAccountStatus().trim().length() == 0 && customer.getAccountStatus().trim().length() == 0 ) || (getAccountStatus().trim().equals(customer.getAccountStatus().trim())))))
				)
				{
					return true;
				}
		}
		
		return false;
	}
	
		
	public int compareTo(Customer customer) {
		if (customer != null && customer.getCustomerId() != null) {
			return -customer.getCustomerId().compareToIgnoreCase(this.customerId);
		}
		return 0;
	}

	public Object clone() {
		Customer cust = null;
		try {
			cust = (Customer)super.clone();
		}
		catch(CloneNotSupportedException cnse) {
			cnse.printStackTrace();
		}
		return cust;
	}

	public String toString() {
		StringBuffer value = new StringBuffer();
		try
		{
			value.append("\n********"+this.getClass()+"*******\n");
			Field[] fields = this.getClass().getDeclaredFields();
			if(fields != null && fields.length > 0)
			{
				for(int i=0;i<fields.length;i++)
				{
					if(fields[i].getModifiers() == 2) {
						value.append("\n"+fields[i].getName()+" =:\t"+fields[i].get(this));
					}
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return value.toString();
	}
}
