package com.nanobi.thread;

class RunnableDemo implements Runnable {
	   private Thread t;
	   private String threadName;
	   RunnableDemo( String name) {
	      threadName = name;
	      System.out.println("Creating " +  threadName );
	   }
	   
	   public void run() {
	      System.out.println("Running " +  threadName );
	      try {
	         for(int i = 4; i > 0; i--) {
	            System.out.println("Thread: " + threadName + ", " + i);
	            // Let the thread sleep for a while.
	            Thread.sleep(50);
	         }
	      }catch (InterruptedException e) {
	         System.out.println("Thread " +  threadName + " interrupted.");
	      }
	      System.out.println("Thread " +  threadName + " exiting.");
	   }
	   
	   public native void start ();
	   
	  /* public native void start () {
	      System.out.println("Starting " +  threadName );
	      if (t == null) {
	         t = new Thread (this, threadName);
	         t.start ();
	      }
	   }*/
	}

class Th extends Thread{
	
	@Override
	public void run() {
		try {
	         for(int i = 4; i > 0; i--) {
	            System.out.println("Thread: "  + i);
	            // Let the thread sleep for a while.
	            Thread.sleep(50);
	         }
	      }catch (InterruptedException e) {
	         System.out.println("Thread interrupted.");
	      }
	}
	
	@Override
	public synchronized void start() {
		
		System.out.println("start");
		super.start();
	}
}

public class TestThread {

	   public static void main(String args[]) throws InterruptedException {
		   /*  Th R1 = new Th();
	      R1.start();
	      
	      Th R2 = new Th();
	      R2.start();*/
	   Runtime.getRuntime().addShutdownHook( new Thread(
               new Runnable() {
                   public void run () {
                	   				System.out.println("Bye Bye");
		                   }
		                }
		  ));
	   Thread t = new Thread(
               new Runnable() {
                   public void run () {
                	   				System.out.println("prasad");
		                   }
		                }
		  );
	   Thread t1 = new Thread(new Runnable(){

		@Override
		public void run() {
			System.out.println("prasadp");
			
		}});
		
		  t.start(); // Line 15
		 // t.join();  // Line 16
		  t1.start();
	   }   
	}