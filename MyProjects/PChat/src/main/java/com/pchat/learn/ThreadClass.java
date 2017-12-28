package com.pchat.learn;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
public class ThreadClass {
    public static void main(String[] args) throws Exception{

    	MyThrad t= new MyThrad();
    	t.start();
    	final ExecutorService executor = 
   			 Executors.newSingleThreadExecutor();
        try {
           // getException();
        } catch (Exception e) {
        System.out.println(e);

        }

    }

    private static void getException() throws Exception{
    	 final ExecutorService executor = 
    			 Executors.newSingleThreadExecutor();
    	 Thread t = ((Thread)stuffToDo);
        try{
        	
            final Future future = executor.submit(t);
              // This does not cancel the already-scheduled task.
            
            future.get(0, TimeUnit.MICROSECONDS);

            executor.shutdownNow();
            
            
            }
            catch(Exception e){
            	System.out.println(t.isAlive());
            	System.out.println("Time out");
                throw e;
            }
    }

    final static  Runnable  stuffToDo = new Thread()  {
          @Override
          public void run()  {
        	  System.out.println(getName());
              try {
                  Thread.sleep(1000);
              } catch (InterruptedException e) {
                  System.out.println(e);
              }
                int a;
                int b=1;
                for(int i=0; i<5;i++){
                    b=b+i;
                }

            System.out.println(b);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println("DOne");
          }
        };

      
        
/*  public void getSum(){
        int a;
        int b=1;

        for(int i=0; i<5;i++){
            b=b+i;
        }
    System.out.println(b);
    }*/
}

class MyThrad extends Thread{
	public void run()  {
		System.out.println("Running...");
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Stop...");
	}
}