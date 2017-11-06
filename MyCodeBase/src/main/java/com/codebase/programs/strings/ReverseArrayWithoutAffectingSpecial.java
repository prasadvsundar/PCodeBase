package com.codebase.programs.strings;

import java.util.Arrays;

public class ReverseArrayWithoutAffectingSpecial {
	public static void main(String[] args) {
		//String s ="Ab,c,de!$";
		//a!!!b.c.d,e'f,ghi;
		//i!!!h.g.f,e'd,cba;
		String s ="a!!!b.c.d,e'f,ghi";
		System.out.println(reverseString(s));
	}
	
	public static String reverseString(String input) {  
	     char[] inputArr = input.toCharArray();  
	     // Initialize left and right pointers
	     int l = 0;  
	     int r = inputArr.length - 1;
	 	 // Traverse string from both ends until
		 // 'l' and 'r'
	     while (l < r) {  
	       // Ignore special characters	 
	       if (!Character.isAlphabetic(inputArr[l])) {  
	         l++;  
	       } else if (!Character.isAlphabetic(inputArr[r])) {  
	         r--;  
	       } else {  // Both str[l] and str[r] are not spacial
	         char tempChar = inputArr[l];  
	         inputArr[l] = inputArr[r];  
	         inputArr[r] = tempChar;  
	         l++;  
	         r--;  
	       }  
	     }  
	     return new String(inputArr);  
	   }  
}
