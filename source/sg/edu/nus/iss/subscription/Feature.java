package sg.edu.nus.iss.subscription;



public class Feature {
	
	private String featureId = null;
	private String dateCommenced = null;
	private String dateTerminated = null;
	
	public String getFeatureId(){
		return featureId;
	}
	
	public void setFeatureId(String featureId){
		this.featureId = featureId;
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

	
}