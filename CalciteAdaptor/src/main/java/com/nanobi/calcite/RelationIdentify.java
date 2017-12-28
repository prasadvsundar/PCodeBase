package com.nanobi.calcite;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class RelationIdentify {
		  public static void main(String[] args) throws Exception {
		    Connection conn = getSqlConnection();
		    System.out.println("Got Connection.");
		    Statement st = conn.createStatement();
		    st.executeUpdate("drop table survey;");
		    st.executeUpdate("create table survey (id int primary key,name varchar(30));");
		    st.executeUpdate("insert into survey (id,name ) values (1,'nameValue')");

		    ResultSet rs = null;
		    DatabaseMetaData meta = conn.getMetaData();
		     // The Oracle database stores its table names as Upper-Case,
		     // if you pass a table name in lowercase characters, it will not work.
		     // MySQL database does not care if table name is uppercase/lowercase.
		     //
		     rs = meta.getExportedKeys(conn.getCatalog(), "dbo", "survey");
		     while (rs.next()) {
		       String fkTableName = rs.getString("FKTABLE_NAME");
		       String fkColumnName = rs.getString("FKCOLUMN_NAME");
		       int fkSequence = rs.getInt("KEY_SEQ");
		       System.out.println("getExportedKeys(): fkTableName="+fkTableName);
		       System.out.println("getExportedKeys(): fkColumnName="+fkColumnName);
		       System.out.println("getExportedKeys(): fkSequence="+fkSequence);
		     }

		    st.close();
		    conn.close();
		  }
		  
		  public static Connection getSqlConnection() throws Exception {
			  
			  /*dataSource.setUrl("jdbc:sqlserver://172.16.0.201:1433");
		        dataSource.setUsername("TRUNKDBADMIN");
		        dataSource.setPassword("TrunkDBAdmin$123");
		        dataSource.setDefaultCatalog("DevRelease_1.8_98");
		        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");*/
		        
			    String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			    String url = "jdbc:sqlserver://172.16.0.201:1433";
			    String username = "TRUNKDBADMIN";
			    String password = "TrunkDBAdmin$123";

			    Class.forName(driver);
			    Connection conn = DriverManager.getConnection(url, username, password);
			    conn.setCatalog("DevRelease_1.8_98");
			    return conn;
			  }

}
