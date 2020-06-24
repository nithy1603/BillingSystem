package sg.edu.nus.iss.subscription;

import java.util.ArrayList;
import java.util.List;


public class Account {
	
	private String accountNumber = null;
	private List<Subscription> subs= new ArrayList<Subscription>();
	
	public String getAccountNumber(){
		return accountNumber;
	}
	
	public void setAccountNumber(String accountNumber){
		this.accountNumber = accountNumber;
	}
	
	
	public ArrayList<Subscription> getSubscriptions(){
		return (ArrayList<Subscription>) subs;
	}
	
	
	
	public void setSubscriptions(Subscription sub){
			subs.add(sub);
		}
	
	
	}