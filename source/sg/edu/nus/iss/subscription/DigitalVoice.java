package sg.edu.nus.iss.subscription;

import java.lang.reflect.Field;
import java.util.ArrayList;


public class DigitalVoice extends Subscription {
	private long  telephoneNumber;
	
	
	public long getTelephoneNumber(){
		return telephoneNumber;
	}
	
	public void setTelephoneNumber(long telephoneNumber){
		this.telephoneNumber = telephoneNumber;
	}
	
}