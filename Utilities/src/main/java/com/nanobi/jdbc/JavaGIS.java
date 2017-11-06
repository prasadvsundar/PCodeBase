package com.nanobi.jdbc;

import java.sql.*;
import java.util.*;
import java.lang.*;
import org.postgis.*;

public class JavaGIS {

	public static void main(String[] args) {
		java.sql.Connection conn;
		try {
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://localhost:5432/gis_data";
			conn = DriverManager.getConnection(url, "postgres", "");

			((org.postgresql.PGConnection)conn).addDataType("geometry",Class.forName("org.postgis.PGgeometry"));
			((org.postgresql.PGConnection)conn).addDataType("box3d",Class.forName("org.postgis.PGbox3d"));

			Polygon geo = new Polygon(
							new LinearRing[] {
								new LinearRing(
									new Point[] {
										new Point(-1.0d, -1.0d,  0.5d),
										new Point( 1.0d, -1.0d,  0.0d),
										new Point( 1.0d,  1.0d, -0.5d),
										new Point(-1.0d,  1.0d,  0.0d),
										new Point(-1.0d, -1.0d,  0.5d)
									}
								)
							}
						);
			PreparedStatement s = conn.prepareStatement("INSERT INTO sample_table (key_value, large_poly) VALUES (?, ?)");
			s.setString(1, "poly1");
			s.setObject(2, new PGgeometry(geo));

			int rows = s.executeUpdate();

			if (rows > 0) {
				System.out.println(" Successful insert! ");
			} else {
				System.out.println(" Failed insert!");
			}
			s.close();

			Statement qs = conn.createStatement();
			ResultSet r = qs.executeQuery("SELECT key_value, large_poly FROM sample_table");
			while( r.next() ) {
				/*
				* Retrieve the geometry as an object then cast it to the geometry type.
				* Print things out.
				*/
				String key = r.getString(1);
				PGgeometry geom = (PGgeometry)r.getObject(2);

				if (geom.getGeoType() == Geometry.POLYGON) {
					System.out.println("Found a polygon with key " + key);
				} else {
					System.out.println("Found a PostGIS geometry object " + geom.getGeoType() + " having key " + key);
				}
			}
			qs.close();
			conn.close();
		}
		catch( Exception e ) {
			e.printStackTrace();
		}
	}
}