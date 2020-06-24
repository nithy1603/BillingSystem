package sg.edu.nus.iss.utility;



public interface BTSKeyWords {
	
	//BTS Date Format
	public static final String DATE_FORMAT = "dd-MMM-yyyy";
	public static final String DATE_TIME_FORMAT = "dd-MMM-yyyy HH:mm:ss";
	
	//Sequence Table
	public static final String SEQUENCE_TABLE = "bts_sequence.txt";

	//Sequence Table Column Count
	public static final int ST_COLUMN_COUNT = 2;

	//Sequence Table Columns & Column Order
	public static final int ST_SEQUENCE_ID = 0;
	public static final int ST_CURRENT_VALUE = 1;


	//User Column Count
	public static final int UT_COLUMN_COUNT = 10;


	//Customer Table
	public static final String CUSTOMER_TABLE = "bts_customer.txt";
	
	//Customer Table Column Count
	public static final int CUST_COLUMN_COUNT = 16;
	
	public static final String CUSTOMERID_SEQUENCE = "customer_id";
	public static final String ACCOUNTNO_SEQUENCE = "account_no";
	
	//Customer Table Columns and Column Order
	public static final int CUST_ID = 0;
	public static final int CUST_ACCOUNT_NO = 1;
	public static final int CUST_FIRST_NAME = 2;
	public static final int CUST_MIDDLE_NAME = 3;
	public static final int CUST_LAST_NAME = 4;
	public static final int CUST_NRIC = 5;
	public static final int CUST_ADDR_LINE1 = 6;
	public static final int CUST_ADDR_LINE2 = 7;
	public static final int CUST_COUNTRY = 8;
	public static final int CUST_POSTAL_CODE = 9;
	public static final int CUST_CONTACT_NO = 10;
	public static final int CUST_EMAIL_ADDR = 11;
	public static final int CUST_INTERESTS = 12;
	public static final int CUST_ACC_STAT = 13;
	public static final int CUST_FROMDATE = 14;
	public static final int CUST_TODATE = 15;
	

	//Plans
	public static final String DIGITALPLAN   		= "Digital";
	public static final String MOBILEPLAN    		= "Mobile";
	public static final String CABLETV       		= "CableTV";
	
	//Feature IDs
	public static final String DIGITAL_SUBSCRIPTION = "dLine"; 
	public static final String DIGITAL_LOCAL 		= "dLocal";
	public static final String DIGITAL_IDD   		= "dIDD";
	public static final String DIGITAL_CALLTRANSFER	= "dCallTransfer";
	public static final String MOBILE_SUBSCRIPTION 	= "mMobile";
	public static final String MOBILE_LOCAL  		= "mLocal";
	public static final String MOBILE_IDD    = "mIDD";
	public static final String MOBILE_ROAMINGSUBSCRIPTION = "mRoamingSubscription";
	public static final String MOBILE_ROAMING= "mRoaming";
	public static final String MOBILE_DATASERVICES	= "mDataServices";
	public static final String CABLETV_SUBSCRIPTION = "cStandard";
	public static final String ADDITIONALCHANNELS	= "cAdditionalChannels";
	public static final String STANDARDCHANNELS	= "cStandard";
	
	public static final String EMPTY_STRING  = "";
	public static final String EMPTY_SPACE   = " ";
	public static final int ZERO_VALUE       = 0;

	
	//Messages
	public static final String MSG_SEARCH_SUCCESS = "Search completed successfully.";
	public static final String MSG_NO_DATA = "No Data Found.";
	
	//General
	public static final String TEXT_SEARCH = "Search";
	public static final String TEXT_RESULT = "Result";
	

	//	Feature Table
	public static final String FEATURE_TABLE = "bts_feature.txt";
	
	//Feature Table Column Count
	public static final int FT_COLUMN_COUNT = 7;
	
	//Feature Table Columns & Column Order
	public static final int ACCOUNT_NO = 0;
	public static final int SUBSCRIPTION_ID = 1;
	public static final int FEATURE_ID = 2;
	public static final int ASSIGNED_TELEPHONE_NO = 3;
	public static final int ADDITIONAL_CHANNELS_NO = 4;
	public static final int DATE_COMMENCED = 5;
	public static final int DATE_TERMINATED = 6;
	

}
