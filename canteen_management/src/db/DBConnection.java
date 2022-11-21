package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	static Connection connection;
	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/c";
		String user="root";
		String password="Root123";
		Class.forName(driver);
		connection=DriverManager.getConnection(url,user,password);
		return connection;
	}
}
