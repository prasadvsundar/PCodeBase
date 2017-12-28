package com.pchat.learn;

import java.io.Serializable;

public class Employee implements Serializable{
	  static String var;
	   public String firstName;
	   transient public String lastName;
	   private static final long serialVersionUID = 5462223600l;
}
