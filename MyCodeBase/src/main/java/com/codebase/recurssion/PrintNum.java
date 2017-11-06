package com.codebase.recurssion;

public class PrintNum {

	int i;
	
	public int getNum(int j){
		if(j>0)
			System.out.println(getNum(--j));
			return i++;
		
	}
	
	public static void main(String[] args) {
		PrintNum b= new PrintNum();
		b.getNum(11);
	}
}
