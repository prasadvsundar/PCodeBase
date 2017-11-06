package com.nanobi.thread;

public class T extends Thread{
	Mutex m;
	String tname;
	int time;
	T(Mutex m, String tname, int time){
		this.m=m;
		this.tname=tname;
		this.time=time;
	}
	@Override
	public void run() {
		super.run();
		//for (int i = 0; i < 10; i++) {
		//	System.out.println(tname);
		try {
			sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			m.dispaly(tname);
			
			//System.out.println("-------------");
		//}
	}
	public static void main(String[] args) {
		Mutex m1= new Mutex("one");
		//Mutex m2= new Mutex("tow");
		Thread t1 = new T(m1, "t1", 4);
		Thread t2 = new T(m1, "t2", 5);
		t1.start();
		t2.start();
	}
}

class Mutex{
	
	String name;
	String tname;
	public void setName(String name) {
		this.tname = name;
	}
	public Mutex(String name){
		this.name = name;
	}
	
	synchronized public void dispaly(String tname){
		for (int i = 0; i < 10; i++) {
			System.out.println(this.name+" "+tname);	
		}
	}
}

