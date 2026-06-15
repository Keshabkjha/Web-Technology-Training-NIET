package nnnnnnnnnn;

import java.text.DateFormat;

public class Date{
	Date date = new Date();
	DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT);
	String formatedDate = dateFormat.format(date);
	System.out.println(formatedDate);
}