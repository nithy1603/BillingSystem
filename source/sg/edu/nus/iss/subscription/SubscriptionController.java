package sg.edu.nus.iss.subscription;

import java.util.ArrayList;
import java.util.List;

import sg.edu.nus.iss.system.ApplicationMaster;
import sg.edu.nus.iss.utility.BTSKeyWords;
import sg.edu.nus.iss.utility.BTSPropertyBundle;


class SubscriptionController implements BTSKeyWords{

	private static final String MODULE = "Subscription";

	private BTSPropertyBundle propertyBundle = null;

	private SubscriptionView subView = null;

	private SubscriptionDAO subscriptionDAO = null;

	SubscriptionController() {
		propertyBundle = new BTSPropertyBundle(MODULE);
		subscriptionDAO = new SubscriptionFileDAO();
	}

	/*public void getSubscriptions(Account acc){
		if(acc.getAccountNumber()!=null && acc.getAccountNumber().trim().length()>0){

		List<Subscription> subs = new ArrayList<Subscription>();
		subs = subscriptionDAO.getSubscriptionList(acc);
		Account a = new Account();
		a.setAccountNumber("Accno2");
        Iterator<Subscription> sub = subs.iterator();
        while(sub.hasNext()){
        	Subscription si = sub.next();
        	a.setSubscriptions(si);
		} 
        JFrame jf = new JFrame("Subscriptions");
		subView.displaySubscriptions(acc);
		subView.setEnabled(false);
		jf.add(subView);
		jf.setResizable(true);

		jf.setVisible(true);
	} }*/

	public SubscriptionView displaySubscriptionView(Account acc, char mode) { 

		if(subView == null) {
			subView = new SubscriptionView(){
				public void cancelAction() {
					disposeSubscriptionView();
				}
			};
			subView.setController(this);
			ApplicationMaster.addScreen(subView);
			
			
		}

		subView.setTitle(getValue("TTLscrxxxxx040SubDetailsScreen"));


		if(acc.getAccountNumber()!=null && acc.getAccountNumber().trim().length()>0){

			List<Subscription> subs = new ArrayList<Subscription>();
			subs = subscriptionDAO.getSubscriptionList(acc);

			if(mode != Subscription.ADD && (subs==null || subs.isEmpty())){

				if(mode == Subscription.MODIFY) {
					int i = subView.showMessage(subView.MSG_QUESTION, getValue("InfomsgxxxxxSubscriptionsEmpty"));
					if(i!=0){
						return null;
					}
				}
				else if(mode == Subscription.VIEW) {
					subView.showMessage(subView.MSG_ERROR, getValue("InfomsgxxxxxSubscriptionsEmptyViewMode"));
					return null;
				}

			}
			subView.displaySubscriptions(acc,mode);


		}

		subView.setVisible(true);
		return subView;
	}

	/**
	 * This method, is used to dispose the UserDetailsScreen.
	 */
	void disposeSubscriptionView() {
		if(subView != null) {
			subView.setVisible(false);
			ApplicationMaster.removeScreen(subView);


			subView.destroy();
			subView = null;
		}
	}

	public String getValue(String key) {
		return propertyBundle.getValue(key);
	}

	public List<Subscription> getSubscriptionSet (Account account){
		List <Subscription> subList = subscriptionDAO.getSubscriptionList(account);
		if (subList != null){
			return subList;
		}
		else {
			return null;
		}
	}
	public void subscribe(Account account) {
		subscriptionDAO.subscribe(account);
	}

} 
