package br.unibh.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtil {
	private static Connection con;
	
	public static Connection getConnection()throws Exception{
		if(con==null || con.isClosed()){
			con=DriverManager.getConnection(
					"jdbc:mysql://http://127.0.0.1:3306/unibh","root","vertrigo");
			System.out.println("conectou no banco");
		}
		return con;
		}
	
public static void closeConnection()throws Exception{
	if(con!=null && ! con.isClosed()){
		con.close();
	}
}

}
