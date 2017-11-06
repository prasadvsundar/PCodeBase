package com.nanobi.programs.arrays;

import java.util.HashMap;

/***
 <p> Find the largest subarray with 0 sum
  Given an array of integers, find length of the largest subarray with sum equals to 0.

	<br>Examples:

	<br>Input: arr[] = {15, -2, 2, -8, 1, 7, 10, 23};
    <br>Output: 5
	<br>The largest subarray with 0 sum is -2, 2, -8, 1, 7
<hr>
	<br>Input: arr[] = {1, 2, 3}
	<br>Output: 0
	<br>There is no subarray with 0 sum

	<br>Input: arr[] = {1, 0, 3}
	<br>Output: 1
	</p>
 */  
public class LargestSubarray0Sum {
	public static void main(String[] args) {
		int arr[] = {15, -2, 2, 1, 7, 10, 23,-8};
		//int arr[] = {0,0,-1,1};
		System.out.println(findLargestSubArray(arr));
		System.out.println(maxLen(arr));
	}
	
	static int findLargestSubArray(int a[]) {
		int maxLen = 0;
		for(int i=0; i<a.length; i++) {
			int sum=0;
			for(int j=i; j<a.length; j++) {
				sum = sum+a[j];
				if(sum == 0) {
					int len = j-i+1;
					maxLen=maxLen>len?maxLen:len;
				}
			}
		}
		return maxLen;
	}
	
	 static int maxLen(int arr[])
	    {
	        // Creates an empty hashMap hM
	        HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();
	 
	        int sum = 0;      // Initialize sum of elements
	        int max_len = 0;  // Initialize result
	 
	        // Traverse through the given array
	        for (int i = 0; i < arr.length; i++)
	        {
	            // Add current element to sum
	            sum += arr[i];
	 
	            if (arr[i] == 0 && max_len == 0)
	                max_len = 1;
	 
	            if (sum == 0)
	                max_len = i+1;
	 
	            // Look this sum in hash table
	            Integer prev_i = hM.get(sum);
	 
	            // If this sum is seen before, then update max_len
	            // if required
	            if (prev_i != null)
	               max_len = Math.max(max_len, i-prev_i);
	            else  // Else put this sum in hash table
	               hM.put(sum, i);
	        }
	 
	        return max_len;
	    }
}
