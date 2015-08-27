package br.unibh.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtil {
	private static Connection con;

	public static Connection getConnection() throws Exception {
		if (con == null || con.isClosed()) {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/unibh", "root", "vertrigo");
			System.out.println("conectou no banco de dados");
		}
		return con;
	}

	public static void closeConnection() throws Exception {
		if (con != null && !con.isClosed()) {
			con.close();
			System.out.println("Fechou o banco de dados");
		}
	}

}
