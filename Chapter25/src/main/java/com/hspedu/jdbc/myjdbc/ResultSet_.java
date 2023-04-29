package com.hspedu.jdbc.myjdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ResultSet_ {
	public static void main(String[] args) throws FileNotFoundException, IOException, SQLException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(
				"/Users/dreamtank117/Programming/Java/JavaVideoPractice_/Chapter25/src/main/java/mysql.properties"));
		String user = properties.getProperty("user");
		String password = properties.getProperty("password");
		String url = properties.getProperty("url");
		Connection connection = DriverManager.getConnection(url, user, password);
		Statement statement = connection.createStatement();
		String sql = "select id,name,sex,borndate from actor";
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {

			int id = resultSet.getInt(1);
			String name = resultSet.getString(2);
			String sex = resultSet.getString(3);
			Date date = resultSet.getDate(4);
			System.out.println(id + "\t" + name + "\t" + sex + "\t" + date);

		}

		resultSet.close();
		statement.close();
		connection.close();

	}

}
