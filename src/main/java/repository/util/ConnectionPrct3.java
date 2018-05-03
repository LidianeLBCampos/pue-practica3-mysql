package repository.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPrct3 {
	private static Connection conDB = null;
	private static String DBUrl;
	

	public static void setURL(String dburl) {
		DBUrl = dburl;
	}

	public static Connection getConexion() {
		if (conDB == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
			} catch (Exception e) {
				System.out.println("No se ha encontrado el driver JDBC");
			}

			try {
				conDB = DriverManager.getConnection(DBUrl);
			} catch (SQLException sqle) {
				System.out.println("SQLException: " + sqle.getMessage());
				System.out.println("SQLState: " + sqle.getSQLState());
				System.out.println("VendorError: " + sqle.getErrorCode());
			}
		}
		return conDB;
	}


	public static void desconecta() {
		if (conDB != null) {
			try {
				conDB.close();
				conDB=null;
			} catch (SQLException sqle) {
				System.out.println("SQLException: " + sqle.getMessage());
				System.out.println("SQLState: " + sqle.getSQLState());
				System.out.println("VendorError: " + sqle.getErrorCode());

			}
		}
	}

}
