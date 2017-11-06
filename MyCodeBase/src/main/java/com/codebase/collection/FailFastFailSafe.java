package com.codebase.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class FailFastFailSafe {
/*	 public static void main(String[] args) 
	    {
	        //Creating an ArrayList of integers
	         
	        ArrayList<Integer> list = new ArrayList<Integer>();
	         
	        //Adding elements to list
	         
	        list.add(1452);
	         
	        list.add(6854);
	         
	        list.add(8741);
	         
	        list.add(6542);
	         
	        list.add(3845);
	         
	        //Getting an Iterator from list
	         
	        Iterator<Integer> it = list.iterator();
	         
	        while (it.hasNext())
	        {
	            Integer integer = (Integer) it.next();
	            //it.remove(); 
	            list.remove(integer);
	            //list.add(8457);      //This will throw ConcurrentModificationException
	        }
	    } 
	 */
	 
	 public static void main(String[] args) 
	    {
	        //Creating a ConcurrentHashMap
	         
	        HashMap<String, Integer> map = new HashMap<String, Integer>();
	         
	        //Adding elements to map
	         
	        map.put("ONE", 1);
	         
	        map.put("TWO", 2);
	 
	        map.put("THREE", 3);
	         
	        map.put("FOUR", 4);
	         
	        //Getting an Iterator from map
	         
	        Iterator<String> it = map.keySet().iterator();
	         
	        while (it.hasNext())
	        {
	            String key = (String) it.next();
	            it.remove();
	            System.out.println(key+" : "+map.get(key));
	             
	            map.put("FIVE", 5);     //This will not be reflected in the Iterator
	        }
	    }    
}
