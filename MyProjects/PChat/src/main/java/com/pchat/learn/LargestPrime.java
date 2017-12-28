package com.pchat.learn;

public class LargestPrime {
	public static void main(String[] args) {
		int lagrgePrime=2;
		for (int n = 2; n < 100000; n++) {
			int m = n / 2;
			boolean flag = true;
			for (int i = 2; i <= m; i++) {
				if (n % i == 0) {
					//System.out.println(n+" Not a Prime");
					flag = false;
					break;
				}
			}
			if (flag) {
				//System.out.println(n+" Prime");
				int r, sum=0;
				int temp=n;
				while(temp>0){
					r=temp%10;
					sum=(sum*10)+r;
					temp=temp/10;
				}
				if(sum==n){
					if(lagrgePrime<n){
						lagrgePrime=n;
					}
			      //System.out.println(n+" Palindrom Prime");
				}
			}
		}
		System.out.println(" Palindrom Prime : "+lagrgePrime);
	}
}
