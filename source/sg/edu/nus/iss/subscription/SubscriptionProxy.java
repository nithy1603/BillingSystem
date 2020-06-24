package sg.edu.nus.iss.subscription;

import java.util.List;


public class SubscriptionProxy {
	private static SubscriptionProxy proxy;
	private SubscriptionController subscriptionController;
	private SubscriptionView subscriptionView;
	
	
	private SubscriptionProxy(){
		if(subscriptionController == null) {
			subscriptionController = new SubscriptionController();
		}
	}
	
	public static SubscriptionProxy getInstance()
    {
		if(proxy==null)
			proxy=new SubscriptionProxy();
		return proxy;
    }
	
	public void destroy()
    {
		subscriptionController = null;
		proxy = null;
		subscriptionView = null;
    }
	
	public void displaySubscriptionView(Account account, char mode) {
		subscriptionView = subscriptionController.displaySubscriptionView(account,mode);
	}
	
	public List<Subscription> getSubscriptionList(Account account){
		List<Subscription> list = subscriptionController.getSubscriptionSet(account);
		if (list != null){
			return list;
		}
		else {
			return null;
		}
	}
	
	
}
