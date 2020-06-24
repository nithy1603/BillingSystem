package sg.edu.nus.iss.customer;


public class Person {

	private String firstName = null;
	private String middleName = null;
	private String lastName = null;
	private String NRIC = null;
	private String accountStatus = null;

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getNRIC() {
		return NRIC;
	}
	public void setNRIC(String nRIC) {
		NRIC = nRIC;
	}
	public String getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public boolean equals(Object obj) {

		if(obj != null && obj instanceof Person) {

			Person person = (Person) obj;

			if( 

					((firstName == null && person.getFirstName() == null) || ((firstName != null && person.getFirstName() != null) && ((firstName.trim().length() == 0 && person.getFirstName().trim().length() == 0 ) || (firstName.trim().equals(person.getFirstName().trim())))))
					&&((middleName == null && person.getMiddleName() == null) || ((middleName != null && person.getMiddleName() != null) && ((middleName.trim().length() == 0 && person.getMiddleName().trim().length() == 0 ) || (middleName.trim().equals(person.getMiddleName().trim())))))
					&&((lastName == null && person.getLastName() == null) || ((lastName != null && person.getLastName() != null) && ((lastName.trim().length() == 0 && person.getLastName().trim().length() == 0 ) || (lastName.trim().equals(person.getLastName().trim())))))
					&&((accountStatus == null && person.getAccountStatus() == null) || ((accountStatus != null && person.getAccountStatus() != null) && ((accountStatus.trim().length() == 0 && person.getAccountStatus().trim().length() == 0 ) || (accountStatus.trim().equals(person.getAccountStatus().trim())))))
			)
			{
				return true;
			}
		}

		return false;
	}
}
