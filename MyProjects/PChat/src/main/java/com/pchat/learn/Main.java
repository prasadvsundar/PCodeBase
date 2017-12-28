package com.pchat.learn;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		
		
		BufferedReader br = null;

		try {

			String sCurrentLine;

			br = new BufferedReader(new FileReader(args[1]));

			while ((sCurrentLine = br.readLine()) != null) {
				//String text= "2 7 15";
				String contentArray[] = sCurrentLine.split(" ");
				int fizz = Integer.parseInt(contentArray[0]);
				int buzz = Integer.parseInt(contentArray[1]);
				int n = Integer.parseInt(contentArray[2]);
				
				StringBuilder output= new StringBuilder();
				for(int i=1;i<=n; i++){
					
					if(((i%buzz)==0)&&((i%fizz)==0)){
						output.append(" FB");
					}else if((i%fizz)==0){
						output.append(" F");
					}else if((i%buzz)==0){
						output.append(" B");
					}else{
						output.append(" "+i);
					}
					
				}
				System.out.println(output.toString());
			}

		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}
}
