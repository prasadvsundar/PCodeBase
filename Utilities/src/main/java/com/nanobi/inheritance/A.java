package com.nanobi.inheritance;

public class A {
	A() {
		System.out.println("A");
	}
	
	private boolean getA(){
		return false;
	}
	
	public static void main(String[] args) {
		A a = new B();
		System.out.println(a.getA());
		
		//String s = "I Love India";
		//System.out.println(s.substring(5));
	}
}

class B extends A {
	B() {
		System.out.println("B");
	}
	
	private boolean getA(){
		return true;
	}
}