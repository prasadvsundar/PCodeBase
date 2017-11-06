package com.codebase.maps;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class MapTestClass {
	public static void main(String[] args) {
		/* Sorted order by asc */
		TreeMap<String,String> treeMap = new TreeMap<String,String>();
		treeMap.put("p", "prasad");
		treeMap.put("n", "nanobi");
		treeMap.put("m", "mysore");
		treeMap.put("a", null);
		//treeMap.put(null, null);
		System.out.println("Tree Map "+treeMap);
		
		LinkedHashMap<String,String> linkedHasMap = new LinkedHashMap<String,String>();
		linkedHasMap.put("p", "prasad");
		linkedHasMap.put("n", "nanobi");
		linkedHasMap.put("m", "mysore");
		linkedHasMap.put("o", null);
		linkedHasMap.put(null, null);
		System.out.println("Linked HasMap "+linkedHasMap);
		
		HashMap<String,String> hashMap = new HashMap<String,String>();
		hashMap.put("p", "prasad");
		hashMap.put("n", "nanobi");
		hashMap.put("m", "mysore");
		hashMap.put("o", null);
		hashMap.put(null, null);
		System.out.println("HasMap "+hashMap);
		
		Hashtable<String,String> hashTable = new Hashtable<String,String>();
		hashTable.put("p", "prasad");
		hashTable.put("n", "nanobi");
		hashTable.put("m", "mysore");
		//hashTable.put("o", null);
		System.out.println("Hash Table "+hashTable);
		
	}
}
