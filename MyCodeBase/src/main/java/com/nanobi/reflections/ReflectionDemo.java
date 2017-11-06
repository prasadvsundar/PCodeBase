package com.nanobi.reflections;

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
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void doSomething(int i){
		System.out.println("do something");
	}
}
