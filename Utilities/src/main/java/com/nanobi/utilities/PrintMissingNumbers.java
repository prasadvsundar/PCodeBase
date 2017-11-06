package com.nanobi.utilities;

public class PrintMissingNumbers {
	 
private static void findMissingNumber(int[] number){
 
	int sum=0;
	for(int i=1; i<=100; i++){
		sum+=i;
	}
	System.out.println(sum);
	System.out.println(100*(100+1)/2);
	
        // take max length as last number in array
/*    int k[] = new int[number[number.length-1]];
        
  int m=0;
 
  if(number[0]!=1){
   for (int x = 1; x < number[0]; x++) {
       k[m] =  x;
       m++;
       }
  }
        
 for (int i = 0; i < number.length -1; i++) {
    
    int j = i+1;
    int difference = number[j] - number[i] ;
            
            
   if(difference != 1 ){
        
  for (int x = 1; x < difference; x++) {
 
          k[m] = number[i] + x;
           m++;
    
}
            
 }*/
/* }
        
System.out.println("missing numbers in array ::");
        
for (int l = 0; l < m ; l++) {
    System.out.println( k[l]+" ");
}*/
}
 public static void main(String[] args) {
        
   int a[]= {2,4,6,9,10,20};
 
   //if Array is not sorted :To sort array use Arrays.sort(a); 
 
  findMissingNumber(a);
 
   
}
}