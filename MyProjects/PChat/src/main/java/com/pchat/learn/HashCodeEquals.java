package com.pchat.learn;

import java.util.HashMap;
import java.util.Map;

class Customer {
    private int customerID;
    private String firstName;
    private String lastName;

    public Customer(int customerID, String firstName, String lastName) {
      super();
      this.customerID = customerID;
      this.firstName = firstName;
      this.lastName = lastName;
    }

   @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + customerID;
        result = prime * result
                + ((firstName == null) ? 0 :   firstName.hashCode());
        result = prime * result
                + ((lastName == null) ? 0 : lastName.hashCode());
      //  System.out.println(result);
        return result;
    }

   /* @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Customer other = (Customer) obj;
        if (customerID != other.customerID)
            return false;
        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;
        if (lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName))
            return false;
        return true;
    }*/
}
public class HashCodeEquals {

  public static void main(String[] args) {
      Map<Customer, String> m = new HashMap<Customer, String>();
      Customer cust = new Customer(1, "Roger", "Cox");
      Customer cust2 =  new Customer(1, "Roger", "Cox");
      System.out.println(cust.hashCode());
      System.out.println(cust2.hashCode());
      System.out.println(cust.equals(cust2));
      m.put(cust,"Roger Cox");
         // retrieving using another instance
      System.out.println(m.get(cust2));
         // retrieving using same instance
      System.out.println(m.get(cust));            
	  
	  
  }
}