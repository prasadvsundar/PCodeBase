package com.codebase.abstraction;

public class AbstractClassTest {

}

abstract class Abstract{
	abstract void test();
	abstract void test1();
	void test(String str) {
		System.out.println("Inside Abstract");
	}
	Abstract(String a){}
}

abstract class A extends Abstract{
	A(String a) {
		super(a);
		// TODO Auto-generated constructor stub
	}

	void test1() {
		System.out.println("Inside A");
	}
}

class B extends A{
	B(String a) {
		super(a);
		// TODO Auto-generated constructor stub
	}

	void test() {
	}	
}