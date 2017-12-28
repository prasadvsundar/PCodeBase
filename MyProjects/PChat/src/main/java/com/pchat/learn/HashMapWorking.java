package com.pchat.learn;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapWorking {
	public static void main(String[] args) {
		Map<Key, String> cityMap = new HashMap<Key, String>();
		cityMap.put(new Key(1, "NY"), "New York City");
		cityMap.put(new Key(2, "ND"), "New Delhi");
		cityMap.put(new Key(3, "NW"), "Newark");
		cityMap.put(new Key(4, "NP"), "Newport");

		System.out.println("size before iteration " + cityMap.size());
		Iterator<Key> itr = cityMap.keySet().iterator();
		while (itr.hasNext()) {
			System.out.println(cityMap.get(itr.next()));
		}
		System.out.println("size after iteration " + cityMap.size());
	}

}

// This class' object is used as key
// in the HashMap
class Key {
	int index;
	String Name;

	Key(int index, String Name) {
		this.index = index;
		this.Name = Name;
	}

	@Override
	// A very bad implementation of hashcode
	// done here for illustrative purpose only
	public int hashCode() {
		return 5;
	}

	@Override
	// A very bad implementation of equals
	// done here for illustrative purpose only
	public boolean equals(Object obj) {
		return true;
	}

}
