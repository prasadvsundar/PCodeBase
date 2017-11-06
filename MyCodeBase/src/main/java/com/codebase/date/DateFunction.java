package com.codebase.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateFunction {
	public static void main(String[] args) throws ParseException {
		Date myDate = new Date();
		//System.out.println(myDate.getMonth());
	/*	int quarter = (myDate.getMonth() / 3) + 1;
		int half = (myDate.getMonth() / 6) + 1;
		System.out.println(quarter);
		System.out.println(half);*/
	/*	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Calendar c = Calendar.getInstance();
		c.setTime(myDate); // Now use today date.
		c.add(Calendar.DATE, 365); // Adding 5 days
		
		String output = sdf.format(c.getTime());
		System.out.println(output);*/
		
	/*	SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy"); //20 - 23 -3+1 = -2
		//String inputString1 = "01 06 2015";//2014-06-01 23   2015-05-24
		String inputString1 = "24 05 2015";//2014-06-01 23   2015-05-24
		String inputString2 = "05 04 2017";

		try {
		   
		    Date date2 = myFormat.parse(inputString2);
		    long diff = date2.getTime() - date1.getTime();
		    System.out.println ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
		} catch (Exception e) {
		    e.printStackTrace();
		}
		 Date date1 = myFormat.parse(inputString1);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date1);
		int week = cal.get(Calendar.WEEK_OF_YEAR);
		System.out.println(week);
		*/
		//getDate();
		
			Date d1 = new Date(2013, 9, 11);
			
			Date d2 = new Date(2013, 9,14);
			
			Date d3 = new Date(2013, 9, 15);
			
			//System.out.println(d2.compareTo(d1)>=0);
			//System.out.println(d2.compareTo(d3)<=0);
			
			System.out.println(d2.compareTo(d1)>=0 && d2.compareTo(d3)<=0);
			//slDate.compareTo(srDate)  >= 0 && slDate.compareTo(time.parse(srcCol[3]))  <= 0;	
		
	}
	
    public static void getDate(){
    	 // set the date
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());

        // "calculate" the start date of the week
        Calendar first = (Calendar) cal.clone();
        first.add(Calendar.DAY_OF_WEEK, 
                  first.getFirstDayOfWeek() - first.get(Calendar.DAY_OF_WEEK));

        // and add six days to the end date
        Calendar last = (Calendar) first.clone();
        last.add(Calendar.DAY_OF_YEAR, 6);

        // print the result
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(df.format(first.getTime()) + " -> " + 
                           df.format(last.getTime()));
    }
}
