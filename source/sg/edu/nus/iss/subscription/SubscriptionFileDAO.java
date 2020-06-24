package sg.edu.nus.iss.subscription;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;


import sg.edu.nus.iss.utility.BTSFileProcessor;
import sg.edu.nus.iss.utility.BTSKeyWords;


public class SubscriptionFileDAO implements SubscriptionDAO, BTSKeyWords{
	
	int i = 0;
	
	BTSFileProcessor btsFileProcessor = null;
	
	public SubscriptionFileDAO(){
		try {
			btsFileProcessor = new BTSFileProcessor(FEATURE_TABLE,FT_COLUMN_COUNT);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public List<Subscription> getSubscriptionList (Account account){
	
		String[] accountArray = getAccountStringArray(account);
		
		try {
			List<String[]> featureArrays = btsFileProcessor.getMatchingRecords(accountArray);
			
			if(featureArrays != null) {
				
				for(String[] featureArray : featureArrays) {
			       
					if(featureArray != null && featureArray.length != BTSKeyWords.FT_COLUMN_COUNT) {
						String[] tempArray = new String[BTSKeyWords.FT_COLUMN_COUNT];
						
						for(int i=0; i< featureArray.length; i++) {
							tempArray[i] = featureArray[i];
						}
						
						featureArray = tempArray;
					} 
					
					account = setAccountSubscriptions(featureArray,account);
				}
			}
			
			
			return account.getSubscriptions();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return account.getSubscriptions();
		
	
	}
	
	private String[] getAccountStringArray(Account account) {
		String[] returnArray = new String[BTSKeyWords.FT_COLUMN_COUNT];
		
		if(account != null) {
			if(account.getAccountNumber() != null && account.getAccountNumber().trim().length() > 0) {
				returnArray[BTSKeyWords.ACCOUNT_NO] = account.getAccountNumber().trim();
			}
			
		}	
				
		return returnArray;
	}
	
	public Account setAccountSubscriptions(String[] featureArray, Account account){
		
		int hasFound = 0;
		for(int i = 0; i < featureArray.length; i++) {  
			if (featureArray[i]!= null && featureArray[i].trim().length() > 0){
			
			if(i == BTSKeyWords.ACCOUNT_NO) {
				account.setAccountNumber(featureArray[i]);
			}
			else if(i == BTSKeyWords.SUBSCRIPTION_ID) {
				if (!(account.getSubscriptions().isEmpty())){
					hasFound = 0;
					Iterator<Subscription> it = account.getSubscriptions().iterator();
					while(it.hasNext()){
						Subscription s = it.next();
						if(s.getSubscriptionId().equalsIgnoreCase(featureArray[i])){
							hasFound = 1;
							break;
						}
					} 
					if (hasFound == 0){
						if (featureArray[i].equalsIgnoreCase(DIGITALPLAN) || featureArray[i].startsWith("digital")){
							DigitalVoice sub = new DigitalVoice();
							sub.setSubscriptionId(DIGITALPLAN);
							if (featureArray[i+2]!= null && featureArray[i+2].trim().length() > 0){
								sub.setTelephoneNumber(new Long(featureArray[i+2]));
								}
							account.setSubscriptions(sub);
						}
						else if (featureArray[i].equalsIgnoreCase(MOBILEPLAN) || featureArray[i].startsWith("mobile")){
							MobileVoice sub = new MobileVoice();
							if (featureArray[i+2]!= null && featureArray[i+2].trim().length() > 0){
							sub.setTelephoneNumber(new Long(featureArray[i+2]));
							}
							sub.setSubscriptionId(MOBILEPLAN);
							account.setSubscriptions(sub);
						}
						else if (featureArray[i].equalsIgnoreCase(CABLETV) || featureArray[i].startsWith("cable")){
							CableTv sub = new CableTv();
							sub.setSubscriptionId(CABLETV);
							if (featureArray[i+3]!= null && featureArray[i+3].trim().length() > 0){
							sub.setAdditionalChannels(Integer.parseInt(featureArray[i+3]));
							}
							account.setSubscriptions(sub);
						}						
					}
				}
				else {
					if (featureArray[i].equalsIgnoreCase(DIGITALPLAN) || featureArray[i].startsWith("digital")){
						DigitalVoice sub = new DigitalVoice();
						sub.setSubscriptionId(DIGITALPLAN);
						if (featureArray[i+2]!= null && featureArray[i+2].trim().length() > 0){
							sub.setTelephoneNumber(new Long(featureArray[i+2]));
							}
						account.setSubscriptions(sub);
					}
					else if (featureArray[i].equalsIgnoreCase(MOBILEPLAN) || featureArray[i].startsWith("mobile")){
						MobileVoice sub = new MobileVoice();
						sub.setSubscriptionId(MOBILEPLAN);
						if (featureArray[i+2]!= null && featureArray[i+2].trim().length() > 0){
							sub.setTelephoneNumber(new Long(featureArray[i+2]));
							}
						account.setSubscriptions(sub);
					}
					else if (featureArray[i].equalsIgnoreCase(CABLETV) || featureArray[i].startsWith("cable")){
						CableTv sub = new CableTv();
						sub.setSubscriptionId(CABLETV);
						if (featureArray[i+3]!= null && featureArray[i+3].trim().length() > 0){
						sub.setAdditionalChannels(Integer.parseInt(featureArray[i+3]));
						}
						account.setSubscriptions(sub);
					}	
				}				
			}
			
			else if(i == BTSKeyWords.FEATURE_ID) {
				hasFound = 0;
				Iterator<Subscription> it = account.getSubscriptions().iterator();
				while(it.hasNext()){
					
					Subscription subscription = it.next();
					if (featureArray[i-1]!= null && featureArray[i-1].trim().length() > 0){
					if(subscription.getSubscriptionId().equalsIgnoreCase(featureArray[i-1])){
						if(!(subscription.getFeatures().isEmpty())){
							Iterator<Feature> itf = subscription.getFeatures().iterator();
							while(itf.hasNext()){
								hasFound = 0;
								Feature f = itf.next();
								if(f.getFeatureId().equalsIgnoreCase(featureArray[i])){
									hasFound = 1;
									break;
								}													
								
							} 
							if (hasFound == 0){
									if (subscription.getSubscriptionId().equalsIgnoreCase(DIGITALPLAN)){
									Feature feature = new Feature();
									feature.setFeatureId(featureArray[i]);
									if (featureArray[i+3]!= null && featureArray[i+3].trim().length() > 0){
									feature.setDateCommenced(featureArray[i+3]);
									}
									if (featureArray[i].equalsIgnoreCase(DIGITAL_LOCAL)){
										if (featureArray[i+3]!= null && featureArray[i+3].trim().length() > 0){
										subscription.setDateCommenced(featureArray[i+3]);
										}
										if (featureArray[i+4]!= null && featureArray[i+4].trim().length() > 0){
											subscription.setDateTerminated(featureArray[i+4]);
										}
									}
									if (featureArray[i+4]!= null && featureArray[i+4].trim().length() > 0){
										feature.setDateTerminated(featureArray[i+4]);
									}
									subscription.setFeatures(feature);
								}
								else if (subscription.getSubscriptionId().equalsIgnoreCase(MOBILEPLAN)){
									Feature feature = new Feature();
									feature.setFeatureId(featureArray[i]);
									if (featureArray[i+3]!= null && featureArray[i+3].trim().length() > 0){
										feature.setDateCommenced(featureArray[i+3]);
										}
									if (featureArray[i].equalsIgnoreCase(MOBILE_LOCAL)){
										if (featureArray[i+3]!= null && featureArray[i+3].trim().length() > 0){
											subscription.setDateCommenced(featureArray[i+3]);
											}
										if (featureArray[i+4]!= null && featureArray[i+4].trim().length() > 0){
											subscription.setDateTerminated(featureArray[i+4]);
										}
									}
									if (featureArray[i+4]!= null && featureArray[i+4].trim().length() > 0){
										feature.setDateTerminated(featureArray[i+4]);
									}
									subscription.setFeatures(feature);
									}								
									
								
								else if (subscription.getSubscriptionId().equalsIgnoreCase(CABLETV)){
									if (featureArray[i].equalsIgnoreCase(STANDARDCHANNELS) || featureArray[i].startsWith("standard_3")){
										Feature feature = new Feature();
										feature.setFeatureId(STANDARDCHANNELS);
										if (featureArray[i+3]!= null && featureArray[i+3].trim().length() > 0){
										subscription.setDateCommenced(featureArray[i+3]);
										feature.setDateCommenced(featureArray[i+3]);
										}
										
										if (featureArray[i+4]!= null && featureArray[i+4].trim().length() > 0){
											feature.setDateTerminated(featureArray[i+4]);
											subscription.setDateTerminated(featureArray[i+4]);
										}
										
										subscription.setFeatures(feature);
									}
									else if (featureArray[i].equalsIgnoreCase(ADDITIONALCHANNELS) || featureArray[i].startsWith("additional")){
										
										if (featureArray[i+2]!= null && featureArray[i+2].trim().length() > 0){
										int channels = Integer.parseInt(featureArray[i+2].trim());
										
										
										Feature feature = new Feature();
										feature.setFeatureId(ADDITIONALCHANNELS);
										if (featureArray[i+3]!= null && featureArray[i+3].trim().length() > 0){
										feature.setDateCommenced(featureArray[i+3]);
										}
										if (featureArray[i+4]!= null && featureArray[i+4].trim().length() > 0){
											feature.setDateTerminated(featureArray[i+4]);
										}
										subscription.setFeatures(feature);
									
									
									}
								}
						}
						
					}
						}
						else{
							if (subscription.getSubscriptionId().equalsIgnoreCase(DIGITALPLAN)){
								Feature feature = new Feature();
								feature.setFeatureId(featureArray[i]);
								if (featureArray[i+3]!= null && featureArray[i+3].trim().length() > 0){
								feature.setDateCommenced(featureArray[i+3]);
								}
								if (featureArray[i].equalsIgnoreCase(DIGITAL_LOCAL)){
									if (featureArray[i+3]!= null && featureArray[i+3].trim().length() > 0){
									subscription.setDateCommenced(featureArray[i+3]);
									}
									if (featureArray[i+4]!= null && featureArray[i+4].trim().length() > 0){
										subscription.setDateTerminated(featureArray[i+4]);
									}
								}
								if (featureArray[i+4]!= null && featureArray[i+4].trim().length() > 0){
									feature.setDateTerminated(featureArray[i+4]);
								}
								subscription.setFeatures(feature);
							}
							else if (subscription.getSubscriptionId().equalsIgnoreCase(MOBILEPLAN)){
								Feature feature = new Feature();
								feature.setFeatureId(featureArray[i]);
								if (featureArray[i+3]!= null && featureArray[i+3].trim().length() > 0){
								feature.setDateCommenced(featureArray[i+3]);
								}
								if (featureArray[i].equalsIgnoreCase(MOBILE_LOCAL)){
									if (featureArray[i+3]!= null && featureArray[i+3].trim().length() > 0){
									subscription.setDateCommenced(featureArray[i+3]);
									}
									if (featureArray[i+4]!= null && featureArray[i+4].trim().length() > 0){
										subscription.setDateTerminated(featureArray[i+4]);
									}
								}
								if (featureArray[i+4]!= null && featureArray[i+4].trim().length() > 0){
									feature.setDateTerminated(featureArray[i+4]);
								}
								subscription.setFeatures(feature);
								}								
								
							
							else if (subscription.getSubscriptionId().equalsIgnoreCase(CABLETV)){
								if (featureArray[i].equalsIgnoreCase(STANDARDCHANNELS) || featureArray[i].startsWith("standard_3")){
									Feature feature = new Feature();
									feature.setFeatureId(STANDARDCHANNELS);
									if (featureArray[i+3]!= null && featureArray[i+3].trim().length() > 0){
									feature.setDateCommenced(featureArray[i+3]);
									subscription.setDateCommenced(featureArray[i+3]);
									}
									if (featureArray[i+4]!= null && featureArray[i+4].trim().length() > 0){
										feature.setDateTerminated(featureArray[i+4]);
										subscription.setDateTerminated(featureArray[i+4]);
									}
									
									subscription.setFeatures(feature);
								}
								else if (featureArray[i].equalsIgnoreCase(ADDITIONALCHANNELS) || featureArray[i].startsWith("additional")){
									
									if (featureArray[i+2]!= null && featureArray[i+2].trim().length() > 0){
									int channels = Integer.parseInt(featureArray[i+2].trim());
									
									
									Feature feature = new Feature();
									feature.setFeatureId(ADDITIONALCHANNELS);
									if (featureArray[i+3]!= null && featureArray[i+3].trim().length() > 0){
									feature.setDateCommenced(featureArray[i+3]);
									}
									if (featureArray[i+4]!= null && featureArray[i+4].trim().length() > 0){
										feature.setDateTerminated(featureArray[i+4]);
									}
									subscription.setFeatures(feature);
								}}
								
								}
							}
					}
						}
				}
				}	
			}
		}return account;
	}		
		
			
		
	public void addSubscription(Account account, boolean isUpdate) {
		String[] oldarray = new String[7];
		String[] newarray = new String[7];
		if (account.getAccountNumber()!= null){
			oldarray[0] = account.getAccountNumber();
			newarray[0] = account.getAccountNumber();
		if(!(account.getSubscriptions().isEmpty())){
			Iterator<Subscription> subs = account.getSubscriptions().iterator();
			while(subs.hasNext()){
				Subscription sub = subs.next();
				oldarray[1] = sub.getSubscriptionId();
				newarray[1] = sub.getSubscriptionId();
				Iterator<Feature> feature = sub.getFeatures().iterator();
				while(feature.hasNext()){
					Feature fi = feature.next();
					oldarray[2] = fi.getFeatureId();
					newarray[2] = fi.getFeatureId();
					if(sub.getSubscriptionId().equalsIgnoreCase(DIGITALPLAN)){
						DigitalVoice digi = (DigitalVoice)sub;
						oldarray[3] = String.valueOf(digi.getTelephoneNumber());
						newarray[3] = String.valueOf(digi.getTelephoneNumber());
						oldarray[4] = null;
						newarray[4] = null;
					}
					else if(sub.getSubscriptionId().equalsIgnoreCase(MOBILEPLAN)){
						MobileVoice mob = (MobileVoice)sub;
						oldarray[3] = String.valueOf(mob.getTelephoneNumber());
						newarray[3] = String.valueOf(mob.getTelephoneNumber());
						oldarray[4] = null;
						newarray[4] = null;
					}
					else if(sub.getSubscriptionId().equalsIgnoreCase(CABLETV)){
						CableTv cable = (CableTv)sub;
						oldarray[3] = null;
						newarray[3] = null;
						oldarray[4] = String.valueOf(cable.getAdditionalChannels());
						newarray[4] = String.valueOf(cable.getAdditionalChannels());
						
					}
					oldarray[5] = fi.getDateCommenced();
					newarray[5] = fi.getDateCommenced();
					
					if (!isUpdate){
					oldarray[6] = fi.getDateTerminated();
					newarray[6] = fi.getDateTerminated();
					}
					else{
						oldarray[6] = null;
						newarray[6] = fi.getDateTerminated();
					}
					
					try {
						btsFileProcessor.updateRecord(oldarray,newarray);
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
				}
				
			}
		}
		
	}	

	public void subscribe(Account account) {
		
		
		//Delete all existing subscriptions for that account
		if(account != null && account.getAccountNumber() != null){
			btsFileProcessor.deleteRecords(ACCOUNT_NO,account.getAccountNumber());
			addSubscription(account, false);
		}
		
		
	}
		
}