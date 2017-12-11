package com.codebase.designpatrens.strategy;

public class CloneTest {
public static void main(String[] args) throws CloneNotSupportedException {
	Test3 t1 = new Test3();
     t1.a = 10;
     t1.b = 20;
     t1.c = 30;

     Test3 t2 = (Test3)t1.clone();
//return statement in finally count down latch
     // Creating a copy of object t1 and passing
     //  it to t2

     // Change in primitive type of t2 will not
     // be reflected in t1 field

     // Change in object type field will be
     // reflected in both t2 and t1(shallow copy)
     System.out.println(t1.a + " " + t1.b 
                         );
     System.out.println(t2.a + " " + t2.b 
                       );
     System.out.println(t2.c + " " + t2.c 
             );
}
}

class Test2 implements Cloneable{
	int a;
	int b;

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	public void test() throws NullPointerException {
		
	}
}

class Test3 extends Test2 implements Cloneable{
	int c;
	public void test() {
		
	}
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
