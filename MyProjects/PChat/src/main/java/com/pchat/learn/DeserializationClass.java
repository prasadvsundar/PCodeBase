package com.pchat.learn;

import java.io.*;

public class DeserializationClass {
	public static void main(String[] args) {
		Employee emp = null;
		try {
			FileInputStream fileIn = new FileInputStream("./employee.txt");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			emp = (Employee) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
			return;
		} catch (ClassNotFoundException c) {
			System.out.println("Employee class not found");
			c.printStackTrace();
			return;
		}
		System.out.println("Deserializing Employee...");
		System.out.println("First Name of Employee: " + emp.firstName);
		System.out.println("Last Name of Employee: " + emp.lastName);
		System.out.println("Last Name of Employee: " + emp.var);
	}
}
