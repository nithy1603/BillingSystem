package sg.edu.nus.iss.subscription;

import java.util.List;



public interface SubscriptionDAO {

	public List<Subscription> getSubscriptionList(Account account);
	
	public void addSubscription(Account account,boolean isUpdate);
	public void subscribe(Account account);
}