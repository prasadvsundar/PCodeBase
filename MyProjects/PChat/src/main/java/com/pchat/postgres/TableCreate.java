package com.pchat.postgres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TableCreate {
	public static void main( String args[] )
    {
      Connection c = null;
      Statement stmt = null;
      try {
        Class.forName("org.postgresql.Driver");
        c = DriverManager
           .getConnection("jdbc:postgresql://172.16.0.202:5432/trunkdb",
           "kcxgxgrwsdhmdmt", "UwfmkXmrpgtXnhj");
        System.out.println("Opened database successfully");

        stmt = c.createStatement();
        String sql = "CREATE TABLE names_tab_0002 (id serial, name varchar(20));";
        stmt.executeUpdate(sql);
        stmt.close();
        c.close();
      } catch ( Exception e ) {
        System.err.println( e.getClass().getName()+": "+ e.getMessage() );
        e.printStackTrace();
        //System.exit(0);
      }
      System.out.println("Table created successfully");
    }
}
