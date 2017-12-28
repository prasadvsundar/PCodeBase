package com.pchat.learn;

public class VarargsClass {
	public void displayData(String... values) {
		System.out.println("Number of arguments passed " + values.length);
		for (String s : values) {
			System.out.println(s + " ");
		}
	}
	
	public void displayData(String value1,String value2,String value3) {
		System.out.println("Number of arguments passed " + value1+value2+value3);	
	}

	public static void main(String[] args) {
		VarargsClass vObj = new VarargsClass();
		// four args
		vObj.displayData("var", "args", "are", "passed");
		// three args
		vObj.displayData("Three", "args", "passed");
		// no-arg
		vObj.displayData();
	}
}