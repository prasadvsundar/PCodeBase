package com.nanobi.immutable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class P {
	public static void main(String[] args) throws ParseException {
		
		String time  = "02:36 PM";
		SimpleDateFormat format = new SimpleDateFormat("hh:mm a");
		Date d  = format.parse(time);
		System.out.println(d);
		SimpleDateFormat format2 = new SimpleDateFormat("HH:mm");
		System.out.println(format2.format(d));
		/*HashSet<String> set = new HashSet<String>();
		set.add("Prasad");
		Imm im = new Imm(10,set);
				
		System.out.println(im.getI());
		System.out.println(im.getSet());
		set.add("Prasad2");
		int k= im.getI();
		k=6;
		im.getSet().add("Pramod");
		System.out.println(k);
		System.out.println(im.getSet());
		System.out.println(im.getI());*/
		
			/*Integer i1 =100;            
			Integer i2 =100;            
	 
	        if(i1 == i2)        
	            System.out.println("EQUAL !");
	        else
	            System.out.println("NOT equal !");
	 
	        i1 = 128;          
	        i2 = 128;
	        
	            #
		       ##
		      ###
		     ####
		    #####
		   ######
		  #######
		 ########
		#########
	 
	        if(i1 == i2)
	            System.out.println("EQUAL !");
	        else
	            System.out.println("NOT equal !");*/
		
		for(int i=1; i<10; i++){
			for(int j=0; j<i; j++){
				System.out.print("#");
			}
			System.out.println();
		}
		
		 Map<String, Integer> map = new HashMap<String, Integer>();
	        map.put("java", 20);
	        map.put("C++", 45);
	        map.put("Java2Novice", 2);
	        map.put("Unix", 67);
	        map.put("MAC", 26);
	        map.put("Why this kolavari", 93);
	        Set<Entry<String, Integer>> set = map.entrySet();
	        
	        List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);
	        
	        Collections.sort( list, new Comparator<Map.Entry<String, Integer>>()
	        {
	            public int compare( Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2 )
	            {
	                return (o1.getValue()).compareTo( o2.getValue() );
	            }
	        } );
	        for(Map.Entry<String, Integer> entry:list){
	            System.out.println(entry.getKey()+" ==== "+entry.getValue());
	        }
		 
	}
}

final class Imm {
	final private Integer i;
	final private HashSet<String> set;
	
	Imm(Integer i, HashSet<String> set) {
		this.i = i;
		this.set = (HashSet<String>) set.clone();
		Object o = new Object();
		;
		System.out.println(o.getClass());
	}

	public int getI() {
		return i;
	}
	
	public HashSet<String> getSet() {
		return (HashSet<String>) set.clone();
	}
}