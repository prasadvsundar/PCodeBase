package com.nanobi.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newFixedThreadPool(2);

		exec.execute(new Thread() {
		  public void run() {
		    System.out.println("Hello world");
		    System.out.println(getName());
		    try {
				sleep(20000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
		});
		
		exec.execute(new Thread() {
			  public void run() {
			    System.out.println("Hello world1");
			    System.out.println(getName());
			    try {
			    	for(int i=0; i<10;i++)
					sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			  }
			});
		
		exec.execute(new Thread() {
			  public void run() {
			    System.out.println("Hello world3");
			    System.out.println(getName());
			    try {
			    	for(int i=0; i<10;i++)
					sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			  }
			});
	}
}
