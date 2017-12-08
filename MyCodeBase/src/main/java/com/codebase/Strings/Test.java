package com.codebase.Strings;

public class Test {
	protected int wrapped;

	public Test(final int value) {
		this.wrapped = value;
	}

	public int operator_plus(final Test e2) {
		return (this.wrapped + e2.wrapped);
	}

	public static void main(String[] args) {
		String p = "Prasad is p and p is prasad";
		System.out.println(p.length() - (p.replaceAll("p", "").length()));
	}
}
