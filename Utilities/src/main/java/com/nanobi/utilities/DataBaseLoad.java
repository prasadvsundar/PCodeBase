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

public class DataBaseLoad {
	final String NB_HOME = System.getenv("NB_HOME");
	//String insertQuery = "SELECT * INTO dataload_history.tenant_TENANTID FROM nbmdc_dataload_history WHERE nbmdm_tenants_row_id  = ?";
	String insertQuery = "SELECT * INTO dataload_history.tenant_TENANTID FROM dataload_history.tenant_TENANTIDFULL WHERE nbmdm_tenants_row_id  = ?";

	String createTable  = "CREATE TABLE tenant_TENANT( row_id varchar2(45) NOT NULL, nbmds_users_row_id varchar2(45) NOT NULL, nbmdc_nanomarts_row_id varchar2(45), nbmdc_nanomart_tables_row_id varchar2(45), icon_path varchar2(255), si_id varchar2(45), icon_content varchar2(255), tablename varchar2(255), martname varchar2(255), active_flag char(1), mis_date timestamp, created_by_user_id varchar2(45), loaded_date_of_data timestamp, updated_by_user_id varchar2(45), operation_mode varchar2(15), records_added int, status_message varchar2(255), records_deleted int, records_updated int, records_failed int, status_code varchar2(1000), error_filepath varchar2(1000), file_name varchar2(500), time_taken numeric(18,6), nbmdm_tenants_row_id varchar2(45), column_name varchar2(255))";
	String dbType;
	String dbURL;
	String dbName;
	String dbUsername;
	String dbPassword;
	Connection conn;

	private void setConnection() throws ClassNotFoundException, SQLException, IOException {
		setDatabaseProp();
		if ("mssql".equalsIgnoreCase(dbType)) {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} else if ("postgresql".equalsIgnoreCase(dbType)) {
			Class.forName("org.postgresql.Driver");
		} else if ("oracle".equalsIgnoreCase(dbType)) {
			Class.forName("oracle.jdbc.OracleDriver");
		}
		conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
	}

	public void createDataLoadHistoryTableForTenant() throws SQLException, ClassNotFoundException, IOException {
		setConnection();
		Statement sta = conn.createStatement();
		sta.setFetchSize(401028);
		String getTenantsQuery = "select * from vwzzwszkywkksgt.sales_analysis_fact600";
		//String getTenantsQuery = "select * from YFSzqJQSFfcHQzF.db_con_loading_perf_test";
		ResultSet rs = sta.executeQuery(getTenantsQuery);
		while (rs.next()) {
			try {
				System.out.println(rs.getString("ID"));
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
	}

	public void insert() throws SQLException, ClassNotFoundException, IOException{
		setConnection();
		Statement sta = conn.createStatement();
		for(int i=0; i<100000; i++){
			String insertStmt = "INSERT INTO vwzzwszkywkksgt.sales_analysis_fact600(bill_date, sale_date, tax_date, product_code, bill_no, salesrep_id, minutes_since_midnight, tax, channel_id, store_id, sale_type, promotion_id, bill_tm, quantity, total_price, unit_price, discount_price)VALUES(TO_DATE('2011-01-03','YYYY-MM-DD'), TO_DATE('2013-10-02','YYYY-MM-DD'), TO_DATE('2016-06-28','YYYY-MM-DD'), '114', '20131218-2-316110"+i+"', 7, 1221, 1353, 1, '1', 'Promotion', 4, NULL, 1, 694, 738, 44)";
			sta.executeUpdate(insertStmt);
			String insertStmt2 = "INSERT INTO vwzzwszkywkksgt.sales_analysis_fact600(bill_date, sale_date, tax_date, product_code, bill_no, salesrep_id, minutes_since_midnight, tax, channel_id, store_id, sale_type, promotion_id, bill_tm, quantity, total_price, unit_price, discount_price)VALUES(TO_DATE('2011-01-03','YYYY-MM-DD'), TO_DATE('2013-10-02','YYYY-MM-DD'), TO_DATE('2016-06-28','YYYY-MM-DD'), '114', '20131218-2-3105100"+i+"', 7, 1221, 1353, 1, '1', 'Promotion', 4, NULL, 1, 694, 738, 44)";
			sta.executeUpdate(insertStmt2);
			System.out.println("inserted "+i);
		}
	}

	private void setDatabaseProp() throws IOException {
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
		DataBaseLoad t = new DataBaseLoad();
		//t.insert();
		t.createDataLoadHistoryTableForTenant();
		// t.createDataLoadHistorySchema();
	}
}
