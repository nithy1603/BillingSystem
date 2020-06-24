package sg.edu.nus.iss.subscription;

import java.lang.reflect.Field;
import java.util.ArrayList;



public class CableTv extends Subscription {
	private int additionalChannels;
	
	
	public int getAdditionalChannels(){
		return additionalChannels;
	}
	
	public void setAdditionalChannels(int additionalChannels){
		this.additionalChannels = additionalChannels;
	}
	
	public String toString() {
		return "AdditionalChannels :: " + additionalChannels;
	}
	
}