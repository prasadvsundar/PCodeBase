package com.codebase.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
	public static void main(String[] args) {
		List<String> l =new ArrayList<String>();
		l.add(null);
		l.add("p");
		l.add("pr");
		l.add("s");
		l.add(5, "pp");
		Iterator iterator = l.iterator();
		while(iterator.hasNext()){
		  //l.g
		  String element = (String) iterator.next();
		}
		System.out.println(l);
		l.remove("pr");
		System.out.println(l);
		Map<String, String> map = new HashMap<String, String>();

		// populate the map
		map.put("1", "ALIVE ");
		map.put("2", "IS");
		map.put("3", "AWESOME");
		map.put("4", null);
		map.put(null, "AWESOME");

		// create a synchronized map
		Map<String, String> syncMap = Collections.synchronizedMap(map);

		System.out.println("Synchronized map :" + syncMap);
		
		Map<String, String> tmap = new Hashtable<String, String>();

		// populate the map
		tmap.put("1", "ALIVE ");
		tmap.put("2", "IS");
		tmap.put("3", "AWESOME");
		//tmap.put("4", null);
		tmap.put(null, "AWESOME");

		// create a synchronized map
		Map<String, String> synctmap = Collections.synchronizedMap(tmap);

		System.out.println("Synchronized map :" + synctmap);
		
		Map<String, String> cmap = new ConcurrentHashMap<String, String>();

		// populate the map
		cmap.put("1", "ALIVE ");
		cmap.put("2", "IS");
		cmap.put("3", "AWESOME");
		cmap.put("4", null);
		cmap.put(null, "AWESOME");

		// create a synchronized map
		Map<String, String> synccmap = Collections.synchronizedMap(cmap);

		System.out.println("Synchronized map :" + synccmap);
	}
}
