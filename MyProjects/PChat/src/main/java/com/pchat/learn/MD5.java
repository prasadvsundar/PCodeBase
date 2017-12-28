package com.pchat.learn;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class MD5 {
	public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		long seconds= System.currentTimeMillis()/1000;
		seconds = seconds+60;
		Date date=new Date();
		System.out.println(date.getTime()/1000);
		System.out.println(seconds);
		//String yourString = "api_key=6e1d93f2fbfcfdc02d9fe933ff3c73d4expire="+seconds+"funnel_id=1170191e12280a34f447c7a7aa4859e526d16e5";

		String yourString = "api_key=6e1d93f2fbfcfdc02d9fe933ff3c73d4event=[\"Homepage Viewed\",\"Maternity | page\",\"Diaper | page\",\"Clothes | page\"]expire="+seconds+"interval=7type=averageunit=daye12280a34f447c7a7aa4859e526d16e5";
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(yourString.getBytes());
        
        byte byteData[] = md.digest();
 
        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
     
        System.out.println("Digest(in hex format):: " + sb.toString());
		
		 
	}
}
