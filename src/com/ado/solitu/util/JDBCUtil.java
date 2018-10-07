package com.ado.solitu.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {

	private static ThreadLocal<Connection> threadlocal=new ThreadLocal<Connection>();
	private static Properties properties=new Properties();
	private static String driver=null;
	private static String url=null;
	private static String username=null;
	private static String password=null;
	static {
		try {
			properties.load(JDBCUtil.class.getClassLoader().getResourceAsStream("databases.properties"));
			driver=properties.getProperty("driver");
			url=properties.getProperty("url");
			username=properties.getProperty("username");
			password=properties.getProperty("password");
			Class.forName(driver);	
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
	}
	
	public static Connection getConnection() {
		Connection connection=null;
		try {
			connection=DriverManager.getConnection(url, username, password);
			threadlocal.set(connection);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return connection;
	}
	
	public static void closeConnection() {
		Connection connection=threadlocal.get();
		if(connection!=null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
