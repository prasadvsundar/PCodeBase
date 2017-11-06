package com.codebase.regularexp;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExp {
	public static void main(String[] args) throws MalformedURLException {
		/*String s = "-100U~+100M~1527877800000ED";
		String pattern = "[-+]*[0-9]+U~[-+]*[0-9]+M~[0-9]+ED";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(s);  
		boolean b = m.matches();
		System.out.println(b);*/
		
		String referer="http://tatdemo.cloudapp.net:90/NanoClientApplication";
		
			referer = referer.startsWith("http")?referer:"http://"+referer;
			URL aURL = new URL(referer);
			referer = aURL.getProtocol()+"://"+aURL.getAuthority();
			System.out.println(referer);
		
	}
}
