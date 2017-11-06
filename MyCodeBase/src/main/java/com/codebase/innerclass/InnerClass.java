package com.codebase.innerclass;

public class InnerClass {
	public static void main(String... args) {
			InnTest inT = new InnTest();
			inT.display();
			InnTest.Inner inn = new InnTest().new Inner();
			System.out.println();
			
			
		}
	public static void pmain(String args[]) {
	/*	InnTest inT = new InnTest();
		inT.display();
		InnTest.Inner inn = new InnTest().new Inner();*/
		System.out.println();
		
		
	}
}


class InnTest{
	public class Inner {
		int i;
	}

	public void display() {
		Inner in = new Inner();
		System.out.println(in.i);
	}
	
	
}