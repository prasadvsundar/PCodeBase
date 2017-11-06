package com.nanobi.collection;

import java.util.HashMap;
import java.util.Map;

public class HahsTableDemo {

	public static void main(String args[]) {
		// Create a hash map
		/*Hashtable balance = new Hashtable();
		Enumeration names;
		String str;
		double bal;

		balance.put("Zara", new Double(3434.34));
		balance.put("Mahnaz", new Double(123.22));
		balance.put("Ayan", new Double(1378.00));
		balance.put("Daisy", new Double(99.22));
		balance.put("Qadir", new Double(-19.08));
		//balance.put("Qadirr",null);

		// Show all balances in hash table.
		names = balance.keys();

		while (names.hasMoreElements()) {
			str = (String) names.nextElement();
			System.out.println(str + ": " + balance.get(str));
		}
		System.out.println();

		// Deposit 1,000 into Zara's account
		bal = ((Double) balance.get("Zara")).doubleValue();
		balance.put("Zara", new Double(bal + 1000));
		System.out.println("Zara's new balance: " + balance.get("Zara"));*/
		
		
		Map<SameHashCode, String> m = new HashMap<SameHashCode, String>();
		m.put(new SameHashCode("prasad"), "prasad");
		m.put(new SameHashCode("nanobi"), "nanobi");
		
		System.out.println(m.get(new SameHashCode("prasad")));
		System.out.println(m.get(new SameHashCode("nanobi")));
		
		System.out.println(m);
		for(Map.Entry<SameHashCode, String> entry :  m.entrySet()){
			System.out.println(entry.getKey().getName() +" -> "+entry.getValue());
		}
		
	}
}

class SameHashCode{
	
	private String name;
	
	public String getName(){
		return name;
	}
	public SameHashCode(String name){
		this.name=name;
	}
	
    @Override
    public boolean equals(Object obj) {
    	SameHashCode sameHashCodeObj = (SameHashCode) obj;
    	return true;
    }
	
	@Override
	public int hashCode() {
		return 123;
	}
}
