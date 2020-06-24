package sg.edu.nus.iss.subscription;

import java.lang.reflect.Field;
import java.util.ArrayList;



public class Subscription  {
	private String subscriptionId = null;
	private String dateCommenced = null;
	private String dateTerminated = null;
	protected ArrayList<Feature> features = new ArrayList<Feature>();
	public static final char ADD = 'a';
	public static final char MODIFY = 'm';
	public static final char VIEW = 'v';
	
	
	public String getSubscriptionId(){
		return subscriptionId;
	}
	
	public void setSubscriptionId(String subscriptionId){
		this.subscriptionId = subscriptionId;
	}
	
	public String getDateCommenced(){
		return dateCommenced;
	}
	
	public void setDateCommenced(String dateCommenced){
		this.dateCommenced = dateCommenced;
	}
	
	public String getDateTerminated(){
		return dateTerminated;
	}
	
	public void setDateTerminated(String dateTerminated){
		this.dateTerminated = dateTerminated;
	}
	
	public ArrayList<Feature> getFeatures(){
		return features;
	}
		
	public void setFeatures(Feature ft){
		this.features.add(ft);
	}

	public String toString() {
		return features.toString();
	}

}