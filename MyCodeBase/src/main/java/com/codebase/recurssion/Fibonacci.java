package com.codebase.recurssion;

public class Fibonacci {
	public static void main(String[] args) {
		
		for(int i=0; i<=1000; i++){
			System.out.print(fib(i)+" ");
		}
	}
	
	static long fib(long n){
		if(n==0)
			return 0;
		if(n==1){
			return 1;
		}else{
			long fib = fib(n-1)+fib(n-2);
			return fib;
		}
	}
}
