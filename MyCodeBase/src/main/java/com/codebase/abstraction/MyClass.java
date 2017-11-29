package com.codebase.abstraction;

import java.util.List;
import java.util.Set;

interface Interface1 {

	void method1(String str);
	
	default void log(String str){
		System.out.println("I1 logging::"+str);
	}
	
	static boolean isNull(String str) {
		System.out.println("Interface Null Check");

		return str == null ? true : "".equals(str) ? true : false;
	}
	public String toString();
}
 
 class Interface2 {

		//void method2(String str);
		
		void log(String str){
			System.out.println("I2 logging::"+str);
		}
	}
 
 public class MyClass extends Interface2 implements Interface1 {

	public void method2(String str) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method1(String str) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean isNull(String str) {
		System.out.println("Impl Null Check");

		return str == null ? true : false;
	}
	
	public boolean isNull(Integer str) {
		System.out.println("Impl Null Check");
		return true;
		//return str == null ? true : false;
	}

	@Override
	public void log(String str) {
		// TODO Auto-generated method stub
		Interface1.super.log(str);
		super.log(str);
		//Interface1.isNull("p");
	}

	public static void main(String[] args) {
		MyClass myclass=new MyClass();
		myclass.log("abc");
		myclass.in
	}
	
		
	}