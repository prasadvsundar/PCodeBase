package com.pchat.learn;

import java.util.Scanner;

public class TE {
	public static void main(String[] args)
	{
        /* System.out.println("Enter the number series");
         Scanner dd = new Scanner(System.in);
         int[] vars = new int[5];
         for(int i=0;i<vars.length;i++)
         {
           System.out.println("Enter the next variable");
           vars[i]=dd.nextInt();
         }
          
         if(var[i]/3==0)
         {
         	System.out.print("");
         }
          if(var[i]/3==0 && var[i]/5==0)
          {
          	System.out.println("");
          }*/
		int F=3;
		int B=5;
		
		for(int i =1; i<=15; i++){
			if(i%F == 0 && i%B == 0){
				System.out.print("FB ");
			}else if(i%F == 0){
				System.out.print("F ");
			}else if(i%B == 0){
				System.out.print("B ");
			}else{
				System.out.print(i+" ");
			}
		}
		
	}

}
