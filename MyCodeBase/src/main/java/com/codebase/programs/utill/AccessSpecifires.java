package com.codebase.programs.utill;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;

public class AccessSpecifires {
public static void main(String[] args) throws FileNotFoundException {
	//int i=10/0;
	throw new FileNotFoundException();
	//System.out.println();
}
}

class A{
	protected String a;
	protected String getA() {
		Collection c = new ArrayList();
		return a;
	}
}
class B extends A{
	//public String a;
	public String getA() {
		return a;
	}
}