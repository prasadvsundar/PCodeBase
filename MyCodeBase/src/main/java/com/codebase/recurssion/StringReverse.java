package com.codebase.recurssion;

public class StringReverse {
	public static void main(String[] args) {
		//System.out.println("Hello world");
		String str = "world";
		System.out.print(reverseString(str));
	}
	
	static String reverseString(String str){
		if(str.length()>0){
			//System.out.print(str.charAt(str.length()-1));
			//return reverseString(str.substring(0,str.length()-1));
			return reverseString(str.substring(1))+str.charAt(0);
		}
		
		return "";
	}
}
