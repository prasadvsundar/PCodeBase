package com.nanobi.customlog4j;

public class MyNewClass {
	MyLogger m = new MyLogger();

	{
		m.init(MyNewClass.class);
	}

	public void printSomething() {

		m.getLogger().info("something");
	}
}
