package net.ukr.p454.task611;

import java.util.Calendar;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar dateTo = Calendar.getInstance();

		Calendar dateFrom = Calendar.getInstance();
		dateFrom.add(Calendar.MONTH, -1);			
		
		System.out.println("Amount ms: " + getDiffTime(dateFrom, dateTo));
		
	}
	
	static long getDiffTime(Calendar dateFrom, Calendar dateTo){
		
		return dateTo.getTimeInMillis()  - dateFrom.getTimeInMillis(); 
	}

}
