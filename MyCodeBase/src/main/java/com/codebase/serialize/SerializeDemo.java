package com.codebase.serialize;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SerializeDemo {

	   public static void main(String [] args) {
	      Employee e = new Employee();
	      e.name = "Reyan Ali";
	      e.address = "Phokka Kuan, Ambehta Peer";
	      e.SSN = 11122333;
	      e.number = 101;
	      
	      try {
	         FileOutputStream fileOut = new FileOutputStream("/home/nanobi/Eclipse-Workspace/Utilities/tmp/employee.ser");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         List<Employee> l = new ArrayList<Employee>();
	         l.add(e);
	         out.writeObject(l);
	         out.close();
	         fileOut.close();
	         System.out.printf("Serialized data is saved in /tmp/employee.ser");
	      }catch(IOException i) {
	         i.printStackTrace();
	      }
	   }
	}

class Employee implements Serializable, Cloneable {
	   public transient String name;
	   public String address;
	   public transient int SSN;
	   public int number;
	   
	   public void mailCheck() {
	      System.out.println("Mailing a check to " + name + " " + address);
	   }
	}