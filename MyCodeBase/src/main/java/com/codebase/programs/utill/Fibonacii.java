package com.codebase.programs.utill;

import java.util.HashMap;
import java.util.Map;

public class Fibonacii {
	public static void main(String[] args) {
		Fibonacii f =new Fibonacii();
		System.out.println(f.fib(100));
	}
	Map<Long, Long> fibMap = new HashMap<Long, Long>();
	public long fib(long i) {
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
	}
}
