package com.pchat.learn;

import java.lang.reflect.Array;
import java.util.Arrays;

public class DupArray {

	public static void main(String[] args) {
		int inArray[] = {1,4,1,6,8,9,3,2,4,8,9,10};
		int outArray[] = new int[0];
				int k=0;
		for(int i=0;i<inArray.length; i++){
			int eqCount=0;
			for(int j=0;j<inArray.length;j++){
				if(inArray[i]==inArray[j]){
					eqCount++;
				}
			}
			if(eqCount==1){
				outArray = Arrays.copyOf(outArray, outArray.length+1);
				outArray[k++]=inArray[i];	
			}
		}
		Arrays.sort(outArray);
		for(int i=0;i<outArray.length;i++){
			System.out.println(outArray[i]);
		}
	}
}
