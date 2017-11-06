package com.codebase.utilities;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		TenantDataLoadHistory t = new TenantDataLoadHistory();
		t.setDatabaseProp();
		t.setConnection();
		Connection con = t.getConnection();
		String getTenantsQuery = "DECLARE @sqlp AS varchar(max) DECLARE @select_list AS varchar(max) SELECT @select_list =(COALESCE(@select_list + ', ', '') + '[' + column_name + ']') FROM (select DISTINCT column_name from dataload_history.tenant_1853d0df0f934870a5d0 where nbmdc_nanomarts_row_id = 'a435e223-57f4-4522-9856-17f1a11c2a40' ) x SET @sqlp = 'SELECT * FROM ( SELECT convert(varchar(10),mis_date, 111) nano_mis_date, column_name, convert(varchar(10),mis_date, 111) mis_date FROM dataload_history.tenant_1853d0df0f934870a5d0 where nbmdc_nanomarts_row_id = '?') as s PIVOT ( min(mis_date) FOR [column_name] IN ('+@select_list+') )AS pvt order by nano_mis_date desc' PRINT (@sqlp) EXEC (@sqlp)";
		PreparedStatement sta = con.prepareStatement(getTenantsQuery);
		sta.setString(1, "a435e223-57f4-4522-9856-17f1a11c2a40");
		//sta.setString(2, "a435e223-57f4-4522-9856-17f1a11c2a40");
		ResultSet rs = sta.executeQuery();

		while (rs.next()) {
			try {
				System.out.println(rs.getString("nano_mis_date"));
				System.out.println(rs.getString("tax_date"));
				System.out.println(rs.getString("bill_date"));
				System.out.println(rs.getString("Sale_date"));
				System.out.println("------------");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
	}
}
