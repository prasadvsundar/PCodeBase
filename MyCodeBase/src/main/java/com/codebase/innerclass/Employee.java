package com.codebase.innerclass;

import java.util.Comparator;

public class Employee {
	int id;
	String name;
	int age;

	static class AgeCompare implements Comparator<Employee> {

		public int compare(Employee o1, Employee o2) {
			// TODO Auto-generated method stub
			return 0;
		}
	}

	public static void main(String[] args) {
		new Employee.AgeCompare();
	}
}
