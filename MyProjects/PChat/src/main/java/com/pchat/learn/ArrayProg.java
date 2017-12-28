package com.pchat.learn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayProg {
	public static void main(String[] args) {
		int a[] = {1,2,3,4};
		int b[] = {1,2,3,4,5,6,7,8,9};
		int count=0;
		for(int ib = 0; ib<b.length; ib++){	
			if(count<a.length){
				System.out.println(b[ib]*a[count]);
				count++;
			}else{
				count=0;
				System.out.println(b[ib]*a[count]);
				count++;
			}			
		}
	}
	
	
	
	
}
