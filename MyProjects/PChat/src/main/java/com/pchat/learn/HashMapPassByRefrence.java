package com.pchat.learn;

import java.util.HashMap;
import java.util.Map;

public class HashMapPassByRefrence {
	public static void main(String[] args) {
		Map<String,Object> mapOne = new HashMap<String,Object>();
		Map<String,Object> mapTow = new HashMap<String,Object>();
		mapOne.put("p", "Prasad");
		mapTow.putAll(mapOne);
	
		System.out.println(mapTow.equals(mapOne));
		System.out.println("MapTow : "+mapTow);
		mapOne.put("s", "s");
		System.out.println("MapTow : "+mapTow);
		mapTow.put("ps", "ps");
		System.out.println("MapOne : "+mapOne);
		
		
	}
}
