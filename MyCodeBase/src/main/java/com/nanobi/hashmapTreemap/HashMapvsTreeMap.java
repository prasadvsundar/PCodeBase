package com.nanobi.hashmapTreemap;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class HashMapvsTreeMap {
	public static void main(String[] args) {
		Hashtable balance = new Hashtable();
		Map<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("b", "bv");
		hashMap.put("nanobi", "dv");
		hashMap.put("xz", "zv");
		hashMap.put("c", "cv");
		hashMap.put("banglore", "av");
		hashMap.put("0", "0v");
		for(String key : hashMap.keySet()){
			System.out.println(key);
		}
		System.out.println(hashMap);
		System.out.println("--------------------");
		Map<String, String> treeMap = new TreeMap<String, String>();
		treeMap.put("b", "bv");
		treeMap.put("nanobi", "dv");
		treeMap.put("xz", "zv");
		treeMap.put("c", "cv");
		treeMap.put("banglore", "av");
		treeMap.put("0", "0v");
		for(String key : treeMap.keySet()){
			System.out.println(key);
		}
		System.out.println(treeMap);
		System.out.println("--------------------");
		Map<String, String> linkdeHashMap = new LinkedHashMap<String, String>();
		linkdeHashMap.put("b", "bv");
		linkdeHashMap.put("nanobi", "dv");
		linkdeHashMap.put("xz", "zv");
		linkdeHashMap.put("c", "cv");
		linkdeHashMap.put("banglore", "av");
		linkdeHashMap.put("0", "0v");
		for(String key : linkdeHashMap.keySet()){
			System.out.println(key);
		}
		System.out.println(linkdeHashMap);
	}
}
