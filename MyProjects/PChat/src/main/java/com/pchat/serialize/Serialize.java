package com.pchat.serialize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Serialize {

	public static void main(String[] args) throws IOException, ClassNotFoundException 
    {
        FileOutputStream fos = new FileOutputStream("prasad.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        Emp emp = new Emp("Prasad",25);

        oos.writeObject(emp);

        oos.flush();
        oos.close();
        fos.close();

        //READING FROM THE FILE

        FileInputStream fis = new FileInputStream("prasad.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);


        Emp emp2 = (Emp) ois.readObject();
        System.out.println(emp2.toString());
        
        ois.close();
        fis.close();


    }
}
