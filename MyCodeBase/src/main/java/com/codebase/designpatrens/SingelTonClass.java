package com.codebase.designpatrens;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//Java code to explain effect of Reflection
//on Singleton property

import java.lang.reflect.Constructor;

//Singleton class
class Singleton implements Cloneable{
//implements Serializable {
	// public instance initialized when loading the class
	public static Singleton instance = new Singleton();

	private Singleton() {
		if (instance != null) {
			throw new RuntimeException("Not able to create");
		}
	}

	// implement readResolve method
	protected Object readResolve() {
		return instance;
	}

	protected Object clone() throws CloneNotSupportedException {
		return instance;
	}
}

public class SingelTonClass {
	/* Using Reflection */
	public static void mainp(String[] args) {
		Singleton instance1 = Singleton.instance;
		Singleton instance2 = null;
		try {
			Constructor[] constructors = Singleton.class.getDeclaredConstructors();
			for (Constructor constructor : constructors) {
				// Below code will destroy the singleton pattern
				constructor.setAccessible(true);
				instance2 = (Singleton) constructor.newInstance();
				break;
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("instance1.hashCode():- " + instance1.hashCode());
		System.out.println("instance2.hashCode():- " + instance2.hashCode());
	}

	/* Using Serialization */
	public static void mainr(String[] args) {
		try {
			Singleton instance1 = Singleton.instance;
			ObjectOutput out = new ObjectOutputStream(new FileOutputStream("file.text"));
			out.writeObject(instance1);
			out.close();

			// deserailize from file to object
			ObjectInput in = new ObjectInputStream(new FileInputStream("file.text"));

			Singleton instance2 = (Singleton) in.readObject();
			in.close();

			System.out.println("instance1 hashCode:- " + instance1.hashCode());
			System.out.println("instance2 hashCode:- " + instance2.hashCode());
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		Singleton instance1 = Singleton.instance;
		Singleton instance2 = (Singleton) instance1.clone();
		System.out.println("instance1 hashCode:- " + instance1.hashCode());
		System.out.println("instance2 hashCode:- " + instance2.hashCode());
	}
}