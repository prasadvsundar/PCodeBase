package com.nanobi.customlog4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

public class TestRoutingLog {

	private final static Logger log = LogManager
			.getLogger(TestRoutingLog.class);

	public static void main(String[] args) {
		/*ThreadContext.put("fileName", "Prasad");
		log.info("Error happened");

		ThreadContext.put("fileName", "Rohan");
		log.info("Something is broken");

		// log.error("Something is broken");

		ThreadContext.remove("fileName");
		*/
		
		for(int i=0; i<5;i++){
			MyThread t = new MyThread("Prasad "+i);
			t.start();
		}
	}
}

class MyThread extends Thread {
	private final Logger log = LogManager
			.getLogger(MyThread.class);

	String name;
	
	MyThread(String name){
		
		this.name=name;
	}
	
	public void run() {
		ThreadContext.put("fileName", name);
			for(int i=0; i<10; i++){
				log.info("Logging "+name+" "+i);
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
}