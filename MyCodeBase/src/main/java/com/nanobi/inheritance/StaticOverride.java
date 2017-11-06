package com.nanobi.inheritance;

class Base {
	static int i = 2;
	/*public static void text() {
		System.out.println("Base class "+i);
	}*/

	public void msg() {
		System.out.println("MSG of Base class");
	}
}

public class StaticOverride extends Base {

	//static int i = 1;
	public static void main(String[] args) {
		StaticOverride b = new StaticOverride();
		b.text();
		b.msg();
	}

	public static void text() {
		System.out.println("StaticOverride class "+i);
	}

	@Override
	public void msg() {
		System.out.println("MSG of StaticOverride class");
	}
}

