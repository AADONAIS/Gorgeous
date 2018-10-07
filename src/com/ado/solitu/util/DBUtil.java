package com.ado.solitu.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class DBUtil {

	private static DataSource dataSource=null;
	private static Properties properties=new Properties();
	private static ThreadLocal<Connection> threadlocal=new ThreadLocal<Connection>();
	
	static {
		try {
			properties.load(DBUtil.class.getClassLoader().getResourceAsStream("./databases.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			dataSource=BasicDataSourceFactory.createDataSource(properties);//º”‘ÿ≈‰÷√Œƒº˛
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConnection() {
		Connection connection=threadlocal.get();
		if(null==connection) {
			try {
				connection=dataSource.getConnection();
				threadlocal.set(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}	
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
