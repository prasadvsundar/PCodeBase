package com.pchat.learn;

//used as return type
class A {
	String name;

	A(String name) {
		this.name = name;
	}
}

// sub-class of A, also used as return type
class B extends A {
	B(String name) {
		super(name);
	}
}

class C {
	public A getValue() {
		return new A("Test A");
	}
}

class D extends C {

	public B getValue() {
		return new B("Test B");
	}
	
	public B getValueTow() {
		return new B("Test B");
	}
}

public class CovariantReturn {
	public static void main(String[] args) {
		// Reference of Class C
		C c;
		// pointing to class C
		c = new C();
		System.out.println("Value from class C " + c.getValue().name);
		// now pointing to class D
		c = new D();
		System.out.println("Value from class D " + c.getValue().name);
		//System.out.println("Value from class D " + c.getValueTow().name);

	}

}
