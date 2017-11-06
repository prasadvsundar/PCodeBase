package com.codebase.jdbc;

import java.awt.Point;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQL {

	public static void main(String[] args) throws Exception {
		final Class<?> jdbcClass = Class.forName("com.mysql.jdbc.Driver");
		System.out.println("jdbc class: " + jdbcClass);

		String jdbcUrl = "jdbc:mysql://tatdemo.cloudapp.net:3306/nanobi_testdb?tinyInt1isBit=false";
		//String jdbcUrl = "jdbc:postgresql://172.16.0.202:5432/trunkdb";
		String mysqlUsername = "nanobi";
		String mysqlPassword = "Welcome1";

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DriverManager.getConnection(jdbcUrl, mysqlUsername, mysqlPassword);

			DatabaseMetaData dbMetaData = connection.getMetaData();
			System.out.println(" MySQL server version: " + dbMetaData.getDatabaseProductVersion());
			System.out.println(" Driver Name: " + dbMetaData.getDriverName());
			System.out.println(" Driver Version: " + dbMetaData.getDriverVersion());

			System.out.println("url: " + jdbcUrl);

			statement = connection.createStatement();

			StringBuilder query = new StringBuilder();

			query.append("SELECT * FROM nanobiproducts");
		//	query.append("\n LEFT JOIN test_category ON (test_category.id = test_entity.category_id)");
		//	query.append("\n LEFT JOIN test_property ON (test_property.test_entity_id = test_entity.id)");
		//	query.append("\n WHERE test_entity.id = 1");
	//		query.append("\n ORDER BY is_active"); // comment this line to get expected result

			System.out.println("the test query:\n" + query.toString());

			statement.execute(query.toString());

			resultSet = statement.getResultSet();

			while (resultSet.next()) {
				//Object entityId = resultSet.getObject("city_id");
				//Object categoryId = resultSet.getObject("city_name");
				String categoryBoolean = resultSet.getString("ProductPoint");
				Class<?> categoryImportantClass = categoryBoolean.getClass();

				System.out.println("hit: ProductPoint: " + categoryBoolean + "(class:" + categoryImportantClass
						+ ")");
			}
			System.out.println("-----------end of resultSet---------------");

		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (Throwable t) {
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (Throwable t) {
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (Throwable t) {
				}
			}
		}
	}

}