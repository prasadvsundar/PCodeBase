package com.nanobi.Strings;

public class Test {
	  protected int wrapped;

	  public Test(final int value) {
	    this.wrapped = value;
	  }

	  public int operator_plus(final Test e2) {
	    return (this.wrapped + e2.wrapped);
	  }
	}


	