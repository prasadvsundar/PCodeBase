package com.nanobi.Strings;

import java.util.ArrayList;
import java.util.List;

public class LongestString {
	public static void main(String[] args) {
		List<String> strList = new ArrayList<String>();
		strList.add("aman");
		strList.add("raman");
		strList.add("uthaaman");
		strList.add("samantha");
		strList.add("thasamantha");
		
		String longestSubstring = strList.get(0);
		
		for(int i=0; i<strList.size(); i++){
			for(int j=0; j<strList.size(); j++){
				if(strList.get(j).contains(strList.get(i)) && j!=i){
					if(longestSubstring.length()<strList.get(i).length()){
						longestSubstring=strList.get(i);
					}
				}
			}
		}
		System.out.println(longestSubstring);
	}
}
