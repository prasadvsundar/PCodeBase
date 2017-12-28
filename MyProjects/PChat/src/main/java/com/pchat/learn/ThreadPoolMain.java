package com.pchat.learn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolMain {
 public static void main(String[] args) {
	 ExecutorService p = Executors.newCachedThreadPool();//  newFixedThreadPool(5);//creating a pool of 5 threads  
	 //ThreadPool p = new ThreadPool(3, 5);
	try {
		p.execute(new MyThread("Hi","Test 1"));
		p.execute(new MyThread("Hi","Test 2"));
		 Thread.sleep(4000);
		p.execute(new MyThread("Hi","Test 3"));
		 Thread.sleep(4000);
		p.execute(new MyThread("Hi","Test 4"));
		 Thread.sleep(4000);
		p.execute(new MyThread("Hi","Test 5"));
		 Thread.sleep(4000);
		p.execute(new MyThread("Hi","Test 6"));
		p.execute(new MyThread("Hi","Test 6"));
		p.execute(new MyThread("Hi","Test 6"));
		p.execute(new MyThread("Hi","Test 6"));
		 Thread.sleep(500000);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 }  

}


class MyThread extends Thread{
	String message;
	public MyThread(String s, String name){  
		setName(name);
        this.message=s;  
    }  
     public void run() {  
        System.out.println(Thread.currentThread().getName()+" (Start) message = "+message);  
        processmessage();//call processmessage method that sleeps the thread for 2 seconds  
        System.out.println(Thread.currentThread().getName()+" (End)");//prints thread name  
    }  
    private void processmessage() {  
        try {  Thread.sleep(5000);  } catch (InterruptedException e) { e.printStackTrace(); }  
    }  
}

class BlockingQueue {

	  private List queue = new LinkedList();
	  private int  limit = 10;

	  public BlockingQueue(int limit){
	    this.limit = limit;
	  }


	  public synchronized void enqueue(Object item)
	  throws InterruptedException  {
	    while(this.queue.size() == this.limit) {
	      wait();
	    }
	    if(this.queue.size() == 0) {
	      notifyAll();
	    }
	    this.queue.add(item);
	  }


	  public synchronized Object dequeue()
	  throws InterruptedException{
	    while(this.queue.size() == 0){
	      wait();
	    }
	    if(this.queue.size() == this.limit){
	      notifyAll();
	    }

	    return this.queue.remove(0);
	  }
}

class PoolThread extends Thread {

    private BlockingQueue taskQueue = null;
    private boolean       isStopped = false;

    public PoolThread(BlockingQueue queue){
        taskQueue = queue;
    }

    public void run(){
        while(!isStopped()){
            try{
                Runnable runnable = (Runnable) taskQueue.dequeue();
                runnable.run();
            } catch(Exception e){
                //log or otherwise report exception,
                //but keep pool thread alive.
            }
        }
    }

    public synchronized void doStop(){
        isStopped = true;
        this.interrupt(); //break pool thread out of dequeue() call.
    }

    public synchronized boolean isStopped(){
        return isStopped;
    }
}

class ThreadPool {

    private BlockingQueue taskQueue = null;
    private List<PoolThread> threads = new ArrayList<PoolThread>();
    private boolean isStopped = false;

    public ThreadPool(int noOfThreads, int maxNoOfTasks){
        taskQueue = new BlockingQueue(maxNoOfTasks);

        for(int i=0; i<noOfThreads; i++){
            threads.add(new PoolThread(taskQueue));
        }
        for(PoolThread thread : threads){
            thread.start();
        }
    }

    public synchronized void  execute(Runnable task) throws Exception{
        if(this.isStopped) throw
            new IllegalStateException("ThreadPool is stopped");

        this.taskQueue.enqueue(task);
    }

    public synchronized void stop(){
        this.isStopped = true;
        for(PoolThread thread : threads){
           thread.doStop();
        }
    }

}
