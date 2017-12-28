package com.pchat.serialize;

import java.io.Serializable;

public class Emp implements Serializable{
	String name;
	int age;
	
	public Emp(String name, int age){
		this.name=name;
		this.age=age;
	}
	
	@Override
	public String toString() {
		return "Name : "+name+" Age : "+age;
	}
}
