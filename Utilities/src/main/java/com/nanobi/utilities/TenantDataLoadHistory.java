package com.nanobi.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author Prasad V S(EmpId:1036)
 * @version 1.0
 * @organization NanoBi Analytics
 * @Date Aug 09, 2014
 */
public class TenantDataLoadHistory {
	final String NB_HOME = System.getenv("NB_HOME");
	String insertQuery = "SELECT * INTO dataload_history.tenant_TENANTID FROM nbmdc_dataload_history WHERE nbmdm_tenants_row_id  = ?";
	//String insertQuery = "SELECT * INTO dataload_history.tenant_TENANTID FROM dataload_history.tenant_TENANTIDFULL WHERE nbmdm_tenants_row_id  = ?";

	//String createTable  = "CREATE TABLE tenant_TENANTID( row_id varchar(45) NOT NULL, nbmds_users_row_id varchar(45) NOT NULL, nbmdc_nanomarts_row_id varchar(45), nbmdc_nanomart_tables_row_id varchar(45), icon_path varchar(255), si_id varchar(45), icon_content varchar(255), tablename varchar(255), martname varchar(255), active_flag char(1), mis_date timestamp, created_by_user_id varchar(45), loaded_date_of_data timestamp, updated_by_user_id varchar(45), operation_mode varchar(15), records_added int, status_message varchar(255), records_deleted int, records_updated int, records_failed int, status_code varchar(1000), error_filepath varchar(1000), file_name varchar(500), time_taken numeric(18,6), nbmdm_tenants_row_id varchar(45), column_name varchar(255))";
	String dbType;
	String dbURL;
	String dbName;
	String dbUsername;
	String dbPassword;
	Connection conn;

	public Connection getConnection (){
		return conn;
	}
	void setConnection() throws ClassNotFoundException, SQLException {
		if ("mssql".equalsIgnoreCase(dbType)) {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} else if ("postgresql".equalsIgnoreCase(dbType)) {
			Class.forName("org.postgresql.Driver");
		} else if ("oracle".equalsIgnoreCase(dbType)) {
			Class.forName("oracle.jdbc.OracleDriver");
		}
		conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
	}

	private void createDataLoadHistoryTableForTenant() throws SQLException {
		Statement sta = conn.createStatement();
		String getTenantsQuery = "select * from nbmdm_tenants";
		ResultSet rs = sta.executeQuery(getTenantsQuery);
		createDataLoadHistorySchema();

		while (rs.next()) {
			try {
				String tenantId = rs.getString("row_id");
				String tenantIdFull = tenantId;
				tenantId = tenantId.substring(0, tenantId.lastIndexOf("-"));
				String tenantIdWithoutHiphen = tenantId.replace("-", "");
				String tenantIdWithoutHiphenFull = tenantIdFull.replace("-", "");
				String tenantInsertQuery = insertQuery.replace("TENANTIDFULL",
						tenantIdWithoutHiphenFull);
				tenantInsertQuery = tenantInsertQuery.replace("TENANTID",
						tenantIdWithoutHiphen);
				System.out.println(tenantInsertQuery);
				PreparedStatement psta = conn
						.prepareStatement(tenantInsertQuery);
				psta.setString(1, tenantId);
				ResultSet rs2 = psta.executeQuery();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
	}

	private boolean createDataLoadHistorySchema() throws SQLException {
		Statement sta = conn.createStatement();
		try {
			if ("oracle".equalsIgnoreCase(dbType)) {
				sta.executeUpdate("CREATE USER  dataload_history IDENTIFIED BY nanobi");
				sta.executeUpdate("GRANT CONNECT TO dataload_history");
				sta.executeUpdate("GRANT RESOURCE TO dataload_history");
			} else {
				sta.executeUpdate("CREATE SCHEMA dataload_history");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			sta.close();
		}
		return true;
	}

	void setDatabaseProp() throws IOException {
		if (NB_HOME != null) {
			Properties prop = new Properties();
			FileInputStream fis = new FileInputStream(NB_HOME
					+ "/database.properties");
			InputStream inputStream = fis;

			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException(
						"property file database.properties not found in the NB_HOME");
			}
			dbType = prop.getProperty("database");
			dbURL = prop.getProperty("dataobject.jdbc.url");
			dbName = prop.getProperty("dataobject.db");
			dbUsername = prop.getProperty("dataobject.jdbc.username");
			dbPassword = prop.getProperty("dataobject.jdbc.password");
		} else {
			System.out.println("NB_HOME not set");
			throw new RuntimeException("NB_HOME not set");
		}
	}

	public static void main(String[] args) throws IOException,
			ClassNotFoundException, SQLException {
		String value = System.getenv("NB_HOME");
		System.out.println(value);
		TenantDataLoadHistory t = new TenantDataLoadHistory();
		t.setDatabaseProp();
		t.setConnection();
		t.createDataLoadHistoryTableForTenant();
		// t.createDataLoadHistorySchema();
	}
}
