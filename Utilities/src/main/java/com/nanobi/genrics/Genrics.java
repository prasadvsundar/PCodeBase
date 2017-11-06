package com.nanobi.genrics;

public class Genrics<A> {
	A obj;

	void add(A obj) {
		this.obj = obj;
	}

	A get() {
		return obj;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "p";
	}

	public static <B> void printArray(B[] elements) {
		for (B element : elements) {
			System.out.println(element);
		}
		System.out.println();
	}
}
