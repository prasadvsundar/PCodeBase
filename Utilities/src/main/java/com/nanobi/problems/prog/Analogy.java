package com.nanobi.problems.prog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Analogy {
	public static void main(String[] args) {
		String text = "sin,zn,nis,act,cat";
		String[] textArray = text.split(",");
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (int i = 0; i < textArray.length; i++) {
			String sortString = sort(textArray[i]);
			if (map.containsKey(sortString)) {
				List<String> anList = map.get(sortString);
				anList.add(textArray[i]);
			} else {
				List<String> anList = new ArrayList<String>();
				anList.add(textArray[i]);
				map.put(sortString, anList);
			}
		}
		/*for (String key : map.keySet()) {
			System.out.println(map.get(key));
		}*/
		
		Map<String, String> map1 = new HashMap<String, String>();
		map1.put("a", "a");
		map1.put("kd", "d");
		map1.put("kfa", "f");
		map1.put("kh", "h");
		map1.put("ai", "i");
		map1.put("kg", "g");
		map1.put("kv", "c");
		map1.put("bk", "b");
		
		map1 = sortByValue1(map1);
		for (String key : map1.keySet()) {
			System.out.println(map1.get(key));
		}
	}
	
	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue1(Map<K, V> map) {
	    return map.entrySet()
	              .stream()
	              .sorted(Map.Entry.comparingByValue(/*Collections.reverseOrder()*/))
	              .collect(Collectors.toMap(
	                Map.Entry::getKey, 
	                Map.Entry::getValue, 
	                (e1, e2) -> e1, 
	                LinkedHashMap::new
	              ));
	}

	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(
			Map<K, V> map) {
		List<Map.Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>(
				map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
			public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});

		Map<K, V> result = new LinkedHashMap<K, V>();
		for (Map.Entry<K, V> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}

	public static String sort(String text) {
		char[] ar = text.toCharArray();
		Arrays.sort(ar);
		return String.valueOf(ar);
	}
}
