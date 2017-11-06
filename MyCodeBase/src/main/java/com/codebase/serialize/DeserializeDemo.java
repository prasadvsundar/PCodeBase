package com.codebase.serialize;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class DeserializeDemo {

	   public static void main(String [] args) {
		   Employee e = null;
	      try {
	         FileInputStream fileIn = new FileInputStream("/home/nanobi/Eclipse-Workspace/Utilities/tmp/employee.ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         List<Employee> elist = (List<Employee>) in.readObject();
	         
	         e = elist.get(0);
	         in.close();
	         fileIn.close();
	      }catch(IOException i) {
	         i.printStackTrace();
	         return;
	      }catch(ClassNotFoundException c) {
	         System.out.println("Employee class not found");
	         c.printStackTrace();
	         return;
	      }
	      System.out.println("Deserialized Employee...");
	      System.out.println("Name: " + e.name);
	      System.out.println("Address: " + e.address);
	      System.out.println("SSN: " + e.SSN);
	      System.out.println("Number: " + e.number);
	   }
	}