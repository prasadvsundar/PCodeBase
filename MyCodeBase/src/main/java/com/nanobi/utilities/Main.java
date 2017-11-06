package com.nanobi.utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class HDTV implements Comparable<HDTV> {
	private int size;
	private String brand;
 
	public HDTV(int size, String brand) {
		this.size = size;
		this.brand = brand;
	}
 
	public int getSize() {
		return size;
	}
 
	public void setSize(int size) {
		this.size = size;
	}
 
	public String getBrand() {
		return brand;
	}
 
	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int compareTo(HDTV o) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*@Override
	public int compareTo(HDTV tv) {
 
		return getBrand().compareTo(tv.getBrand());
	}*/
}
 
/*class SizeComparator implements Comparator<HDTV> {
	@Override
	public int compare(HDTV tv1, HDTV tv2) {
		int tv1Size = tv1.getSize();
		int tv2Size = tv2.getSize();
 
		if (tv1Size > tv2Size) {
			return 1;
		} else if (tv1Size < tv2Size) {
			return -1;
		} else {
			return 0;
		}
	}
}*/
public class Main {
	public static void main(String[] args) {
		/*HDTV tv1 = new HDTV(55, "Samsung");
		HDTV tv2 = new HDTV(60, "Sony");
		HDTV tv4 = new HDTV(65, "A");
 
		if (tv1.compareTo(tv2) > 0) {
			System.out.println(tv1.getBrand() + " is better.");
		} else {
			System.out.println(tv2.getBrand() + " is better.");
		}
		
		//HDTV tv1 = new HDTV(55, "Samsung");
		//HDTV tv2 = new HDTV(60, "Sony");
		HDTV tv3 = new HDTV(42, "Panasonic");
 
		ArrayList<HDTV> al = new ArrayList<HDTV>();
		al.add(tv1);
		al.add(tv2);
		al.add(tv3);
		al.add(tv4);
 
		Collections.sort(al);
		for (HDTV a : al) {
			System.out.println(a.getBrand());
		}
		
		Collections.sort(al, new SizeComparator());
		for (HDTV a : al) {
			System.out.println(a.getBrand());
		}*/
		List list = new ArrayList();  
		list.add("hello");  
		String s = (String) list.get(0);//typecasting  
		System.out.println(s);
		
		List<String> list1 = new ArrayList<String>();  
		list1.add("hello");  
		String s1 = list1.get(0);  
		System.out.println(s1);
	}
}
