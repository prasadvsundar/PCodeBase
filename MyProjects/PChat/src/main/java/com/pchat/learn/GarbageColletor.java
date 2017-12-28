package com.pchat.learn;

public class GarbageColletor {
	public static void main(String args[]){
		System.out.println(Runtime.getRuntime().freeMemory());

		    for (int i=0;i<= 100000;i++) {
		    Double d = new Double(225);
		    }
		    System.out.println(Runtime.getRuntime().freeMemory());
		    System.gc();
		    System.out.println(Runtime.getRuntime().freeMemory());
		    
		}
}
