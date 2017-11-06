package com.codebase.drill;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.drill.jdbc.DrillConnection;
import org.apache.drill.jdbc.Driver;

public class Test {
   /* public static void main(String[] args) throws SQLException {
        final String baseUrl = "jdbc:drill:zk";
        final String drillDirectoryZookeeper = "drill";
        final String clusterId = "MSSQL";
        final String zookeeperServer = "someserver.swissport.aero";
        final String schema = "MSSQL.dbo";
       // SELECT * FROM MSSQL.`dbo`.`nbmdc_nanomart
        DrillConnection connection;
        Statement statement;
        Driver.load();
        String url = baseUrl + "=" + zookeeperServer + "/" + drillDirectoryZookeeper + "/" + clusterId + ";" + "schema=" + schema;
        connection = (DrillConnection)DriverManager.getConnection(url);
        String query = "SELECT * FROM nbmdc_nanomart";
        statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery(query);
         while(resultset.next())
         {
             String name = resultset.getString("name");
             System.out.println("name: " + name );
         }
         resultset.close();
         connection.close();
    }*/
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
    	Class.forName("org.apache.drill.jdbc.Driver");
    	Connection connection =DriverManager.getConnection("jdbc:drill:drillbit=127.0.0.1;:21"
    			+ "81");
    	//jdbc:drill:zk=centos23.lab:2181/drill/docs41cluster-drillbits
    	Statement st = connection.createStatement();
    	
    	//ResultSet rs = st.executeQuery("SELECT * FROM MSSQL.`dbo`.`nbmdc_nanomarts`");
    	ResultSet rs = st.executeQuery("SELECT * FROM test.`/home/nanobi/Drill/CSV/branchmerge.csv`");
    	while(rs.next()){
    	System.out.println(rs.getString(1));
    	}
	}
}