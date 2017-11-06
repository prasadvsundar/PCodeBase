package com.codebase.hashmapTreemap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ListRemove {

	public static void main(String[] args) {
		List<String> myList = new ArrayList<String>();
		myList.add("Prasad");
		myList.add("Prasad1");
		myList.add("Prasad2");
		myList.add("Prasad3");
		myList.add("Prasad4");
		myList.add("Prasad5");
		myList.add("Prasad6");
		myList.add("Prasad7");
		myList.add("Prasad8");

		// for(String s : myList){ myList.remove(s); }

		Iterator<String> it = myList.iterator();
		// it.remove();
		while (it.hasNext()) {
			// myList.remove(it.next());
			System.out.println(it.next());
			it.remove();
		}
		System.out.println(myList);
	}

	public static void mainm(String[] args) {
		Map<String, String> premiumPhone = new HashMap<String, String>();
		premiumPhone.put("Apple", "iPhone");
		premiumPhone.put("HTC", "HTC one");
		premiumPhone.put("Samsung", "S5");

		Iterator iterator = premiumPhone.keySet().iterator();

		while (iterator.hasNext()) {
			System.out.println(premiumPhone.get(iterator.next()));
			premiumPhone.put("Sony", "Xperia Z");
		}

	}
}
