package com.codebase.singleton;

public class TestSingleton{
	public static void main(String[] args) {
		Singleton s = Singleton.getObj();
		
	}
}



class Singleton {

	private static Singleton obj;
	
	private Singleton(){};
	
	public synchronized static Singleton getObj(){
		
			if(obj==null){
				obj = new Singleton();
			}
		//synchronized (obj) {
			return obj;
		//}
	}
}