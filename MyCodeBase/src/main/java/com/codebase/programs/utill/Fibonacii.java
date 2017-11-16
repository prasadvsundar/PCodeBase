package com.codebase.programs.utill;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Fibonacii {
	public static void main(String[] args) {
		Fibonacii f =new Fibonacii();
		//System.out.println(f.fib(100));
		for(int i=0; i<1000000; i++) {
			System.out.print(f.fib(BigInteger.valueOf(i))+" ");
		}
	}
	Map<Long, Long> fibMap = new HashMap<Long, Long>();
	/*public long fib(long i) {
		if(i == 1 || i == 2) {
			//System.out.print(1);
			return (long) 1;
		}else {
			long n1=0,n2=0;
			if(!fibMap.containsKey(i-1)) {
			 n1=fib(i-1);
			 fibMap.put(i-1, n1);
			}else {
				n1=fibMap.get(i-1);
			}
			if(!fibMap.containsKey(i-2)) {
			 n2=fib(i-2);
			 fibMap.put(i-2, n2);
			}else {
				n2=fibMap.get(i-2);
			}
			
			long num = n1 +n2;
			
			return num;
		}
	}*/
	
	public int fibInt(int n) {
		if(n==0)
			return 0;
		if(n==1)
			return 1;
		else
			return fibInt(n-1)+fibInt(n-2);
		
	}
	
	/**
	 * BigInteger 
	 * @param n
	 * @return
	 */
	public BigInteger fib(BigInteger n) {
		if (n.equals(BigInteger.valueOf(0)))
			return BigInteger.valueOf(0);
		if (n.equals(BigInteger.valueOf(1))) {
			return BigInteger.valueOf(1);
		} else {
			BigInteger f1 = fib(n.subtract(BigInteger.valueOf(1)));
			BigInteger f2 = fib(n.subtract(BigInteger.valueOf(2)));
			return f1.add(f2);
		}
	}
}
