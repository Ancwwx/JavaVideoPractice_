package com.hspedu.jdbc.utils;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;




public class JDBCUtiles {

	private static String user;
	private static String password;
	private static String url;

	static {
		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream(
					"/Users/dreamtank117/Programming/Java/JavaVideoPractice_/Chapter25/src/main/java/mysql.properties"));
			user = properties.getProperty("user");
			password = properties.getProperty("password");
			url = properties.getProperty("url");

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
	
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public static void close(ResultSet set,Statement statement,Connection connection) {
		try {
			if (set != null) {
				set.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			} 
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
