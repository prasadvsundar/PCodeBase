package com.pchat.threads;

import java.util.concurrent.locks.LockSupport;

public class ThreadExample extends Thread {
	public void run() {
		try {
			setName("Park");
			synchronized (this) {
				wait(8000);
			}
			//Thread.sleep(1000);
			LockSupport.park();//(Thread.currentThread());
			synchronized (this) {
				wait(8000);
			}
			
			System.out.println("task");
		} catch (InterruptedException e) {
			System.out.println("Exception handled " + e);
		}
		System.out.println("thread is running...");
	}

	public static void main(String args[]) {
		ThreadExample t1 = new ThreadExample();
		t1.start();
		
		ThreadPExample t2 = new ThreadPExample();
		t2.start();
		//LockSupport.unpark(t1);
		/* for (Thread t : Thread.getAllStackTraces().keySet()) {
		        System.out.println(t.getName()+" "+t.getState());
		    }*/
		 
		
				
			
	//	t1.interrupt();

		
	}
	public Thread getThreadByName(String threadName) {
	    for (Thread t : Thread.getAllStackTraces().keySet()) {
	        if (t.getName().equals(threadName)) return t;
	    }
	    return null;
	}
}

class ThreadPExample extends Thread {
	public void run() {
		try {
			setName("Check Park");
			synchronized (this) {
				wait(10000);
			}
			notify();
		 for (Thread t : Thread.getAllStackTraces().keySet()) {
		        System.out.println(t.getName()+" "+t.getState());
		        if(t.getName().equalsIgnoreCase("park")){
		        	//LockSupport.unpark(t);
		        }
		    }
			
		 
			System.out.println("task");
		} catch (InterruptedException e) {
			System.out.println("Exception handled " + e);
		}
		System.out.println("thread is running...");
	}
	public Thread getThreadByName(String threadName) {
	    for (Thread t : Thread.getAllStackTraces().keySet()) {
	        if (t.getName().equals(threadName)) return t;
	    }
	    return null;
	}
}
