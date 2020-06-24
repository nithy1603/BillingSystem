package sg.edu.nus.iss.customer;


public class CustomerException extends Exception {

	public CustomerException(String message) {

		super(message);
	}
	
	public CustomerException(String message, Throwable e) {

		super(message, e);
	}
	
	public final static String DUPLICATE_NRIC = "DUPLICATE_NRIC";
}
