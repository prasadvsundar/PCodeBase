package com.codebase.reflections;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionDemo {
	public static void main(String[] args) {
		ReflectionDemo obj = new ReflectionDemo();
		Class c = obj.getClass();
		System.out.println(c);
		
		Method method;
		try {
			method = obj.getClass().getMethod("doSomething", null);
			method.invoke(obj, null,1);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void doSomething(int i){
		System.out.println("do something");
	}
}
