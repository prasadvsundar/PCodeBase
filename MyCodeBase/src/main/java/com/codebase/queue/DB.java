package com.codebase.queue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
	Connection con;
	
	DB() throws SQLException{
		con = DriverManager.getConnection("jdbc:sqlserver://10.5.50.143:1433;autoReconnect=true;databaseName=DevRelease_1.8_98", "TRUNKDBADMIN", "TrunkDBAdmin$123");
	}
	
	public Connection getConnection(){
		return con;
	}
	String getData() throws SQLException{
		Statement stmt = con.createStatement();
        stmt.setFetchSize(200);
        ResultSet rs = stmt.executeQuery("select * from dbo.testLoad");
        while (rs.next()) {
           System.out.println(rs.getString(1) + " " + rs.getString(2) + "\n");
        }
        return null;
	}
	
	void insertData(String sql) throws SQLException{
		Statement stmt = con.createStatement();
		stmt.executeUpdate(sql);
	}
	public static void main(String[] args) throws SQLException {
		DB d = new DB();
		d.getData();
	}
}
