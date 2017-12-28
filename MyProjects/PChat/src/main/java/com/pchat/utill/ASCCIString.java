package com.pchat.utill;

public class ASCCIString {
	public static void main(String[] args) {
		/*String s = "\n";
		//String s = "	";
		char character = s.charAt(0); // This gives the character 'a'
		int ascii = (int) character;
		System.out.println(character);
		System.out.println(ascii);*/
		
		// will be the sum of the numbers in the array.
		int arr[] = new int[2];
		for(int i=1; i<=2;i++){
			if(i==5){
				
			}else{
				arr[i-1]=i;
			}
		}
		int sum = 0;
		int idx = -1;
		for (int i = 0; i < arr.length; i++){
		    if (arr[i] == 0){
		         idx = i; 
		    } else {
		         sum += arr[i];
		    }
		}

		// the total sum of numbers between 1 and arr.length.
		int total = (arr.length + 1) * arr.length / 2;
		System.out.println(total);

		System.out.println("missing number is: " + (total - sum) + " at index " + idx);
	}
}
