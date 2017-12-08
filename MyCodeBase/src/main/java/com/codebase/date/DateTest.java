package com.codebase.date;

import java.text.ParseException;

public class DateTest {
	public static void main(String[] args) throws ParseException {
		java.text.DateFormat format = new java.text.SimpleDateFormat("dd/MM/yy");
		java.util.Date date = format.parse("10/12/17");
		java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());
		System.out.println(timestamp);
	}
}
