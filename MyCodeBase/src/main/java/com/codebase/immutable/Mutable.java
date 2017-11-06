package com.codebase.immutable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class Immutable {
    private final List<String> value;

    public Immutable(ArrayList<String> value) {
        this.value = value;
    }

    public List getValue() {
        return value;
    }
}
public class Mutable  {
    /*private int realValue;

    public Mutable(int value) {

        realValue = value;
    }

    public int getValue() {
        return realValue;
    }
    public void setValue(int newValue) {
        realValue = newValue;
    }*/

   public static void main(String[] arg){
       /*Mutable obj = new Mutable(4);
       Immutable immObj = (Mutable)obj;              
       System.out.println(immObj.getValue());
       obj.setValue(8);
       System.out.println(immObj.getValue());*/
	   ArrayList<String> a = new ArrayList<String>();
	   a.add("p");
	   Immutable te = new Immutable(a);
		  for(int i=0; i<te.getValue().size(); i++){
			  System.out.println(te.getValue().get(i));
		  }
		  System.out.println("------------");
		  te.getValue().add("pp");
		  
		  for(int i=0; i<te.getValue().size(); i++){
			  System.out.println(te.getValue().get(i));
		  }
   }
}