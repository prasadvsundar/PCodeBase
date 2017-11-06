package com.codebase.genrics;

public class GenricsTest {
	public static void main(String args[]) {
		Genrics<Genrics<String>> m = new Genrics<Genrics<String>>();
		m.add(new Genrics<String>());
		//m.add("vivek");
		//Compile time error
		System.out.println(m.get());
		Integer[] k = {1,2,3,4,5};
		m.printArray(k);
	}
}
