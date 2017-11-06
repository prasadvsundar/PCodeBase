package com.codebase.thread;

import org.apache.drill.exec.expr.fn.impl.DateTypeFunctions.CurrentTime;
import org.omg.CORBA.Current;

public class DeamanThread {
	public static void main(String[] args) {
		//Thread.currentThread().setDaemon(true);
		Thread t = new DeamanThreadDemo();
		//t.setDaemon(true);
		t.start();
	}
}

class DeamanThreadDemo extends Thread {
	DeamanThreadDemo() {
		//setDaemon(true);
	}
	@Override
	public void run() {
		for(int i=0; i<100; i++){
			/*try {
				//sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			System.out.println(i);
		}
	}
}
