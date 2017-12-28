package com.pchat.learn;

import java.util.ArrayList;
import java.util.List;

public class StackUsingList {
	public static void main(String[] args) {
		List<String> aList = new ArrayList<String>();
		aList.add("A");
		aList.add("B");
		aList.add("C");
		System.out.println(aList);
		System.out.println(aList.remove(aList.size()-1));
	}
}
