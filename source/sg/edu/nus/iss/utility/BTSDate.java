package sg.edu.nus.iss.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



public class BTSDate implements BTSKeyWords{

	private int daystoincrement = 15;
	String[] monthName = {"Jan", "Feb","Mar", "Apr", "May", "Jun", "Jul","Aug", "Sep", "Oct", "Nov","Dec"};

	SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);  
	Date date = new Date(); 
	Calendar cal = Calendar.getInstance();

	public String getCurrentDate(){		
		return dateFormat.format(date);
	}

	public static String getCurrentDate(String dateFormat){		
		SimpleDateFormat reqdDateFormat = new SimpleDateFormat(dateFormat);  
		return reqdDateFormat.format(new Date());
	}
	
	public String getNextDay(){	
		Date new_date = new Date();		
		cal.setTime(new_date);
		cal.add(Calendar.DATE, daystoincrement);
		new_date = cal.getTime();
		return dateFormat.format(new_date);
	}

	public String addMonth(String date, int count){	
		try{
			Date new_date = dateFormat.parse(date);		
			cal.setTime(new_date);
			cal.add(Calendar.MONTH, count);
			return dateFormat.format(cal.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getLastMonth(String date){
		Date new_date = new Date();
		try {
			new_date = dateFormat.parse(date);
			cal.setTime(new_date);
			cal.add(Calendar.MONTH, -1);
			cal.getTime();			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return monthName[cal.get(Calendar.MONTH)];
	}


	public String getLastYear(String date){
		Date new_date = new Date();
		try {
			new_date = dateFormat.parse(date);
			cal.setTime(new_date);
			cal.add(Calendar.YEAR, -1);
			new_date = cal.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return cal.get(cal.YEAR)+"";
	}

	public String getCurrentMonth(){		
		return  monthName[cal.get(Calendar.MONTH)];
	}	

	public String getMonth(String date){
		Date new_date = new Date();
		try {
			new_date = dateFormat.parse(date);
			cal.setTime(new_date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return monthName[cal.get(Calendar.MONTH)];
	}

	public String getYear(String date){
		Date new_date = new Date();
		try {
			new_date = dateFormat.parse(date);
			cal.setTime(new_date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return cal.get(cal.YEAR)+"";
	}

	public boolean isBefore(String firstDate,String secondDate){
		Date date_1 = new Date();
		Date date_2 = new Date();
		try {
			date_1 = dateFormat.parse(firstDate);
			date_2 = dateFormat.parse(secondDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (date_1.before(date_2)){
			return true;
		}else{
			return false;
		}		
	}

	public boolean isAfter(String firstDate,String secondDate){
		Date date_1 = new Date();
		Date date_2 = new Date();
		try {
			date_1 = dateFormat.parse(firstDate);
			date_2 = dateFormat.parse(secondDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (date_1.after(date_2)){
			return true;
		}else{
			return false;
		}		
	}
}