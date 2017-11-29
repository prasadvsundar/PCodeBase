package com.codebase.programs.utill;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class FileSort {
	public static void main(String[] args) {
		List<MetaDataNodeDateTime> fileList = new ArrayList<MetaDataNodeDateTime>();
		File folder = new File("/home/dev/Desktop/Prasad");
		File[] listOfFiles = folder.listFiles();

		    for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		        //System.out.println("File " + listOfFiles[i].getName()+" " + new Date(listOfFiles[i].lastModified()));
		        fileList.add(new MetaDataNodeDateTime(new Date(listOfFiles[i].lastModified()), listOfFiles[i].getName()));
		      } 
		    }
		    Collections.sort(fileList);
		System.out.println(fileList);
	}
}



class MetaDataNodeDateTime implements Comparable<MetaDataNodeDateTime> {
	private Date date;
	private String name;
	//private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	//private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	public MetaDataNodeDateTime() {
		date = new Date();
	}

	public MetaDataNodeDateTime(Date date, String name){
		this.date = date;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Date getDate() {
		return date;
	}

	@Override
	public String toString() {
		return "File Name :"+name +", Date : "+date;
	}
	

	@Override
	public int compareTo(MetaDataNodeDateTime object) {
		return object.getDate().compareTo(this.date);
	}

}

