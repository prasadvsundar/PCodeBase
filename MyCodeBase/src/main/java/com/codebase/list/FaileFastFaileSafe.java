package com.codebase.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FaileFastFaileSafe {
	
	/*public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
	    
	    //Adding elements to list
	     
	    list.add(1452);
	     
	    list.add(6854);
	     
	    list.add(8741);
	     
	    list.add(6542);
	     
	    list.add(3845);
	     
	    //Getting an Iterator from list
	     
	    Iterator<Integer> it = list.iterator();
	     
	    while (it.hasNext()){
	        Integer integer = (Integer) it.next();
	         
	        list.add(8457);      //This will throw ConcurrentModificationException
	    }
	}*/
	
	public static void main(String[] args) {
		List <String> cityList = new CopyOnWriteArrayList<String>();
		  cityList.add("New York City");
		  cityList.add("New Delhi");
		  cityList.add("Newark");
		  cityList.add("Newport");  
		  Iterator<String> itr = cityList.iterator();
		  while (itr.hasNext())
		         {         
		          System.out.println(itr.next());
		          cityList.add("NewCity");
		          cityList.remove("NewCity");
		         }
		  System.out.println(cityList);
		 }

	
	
}
