package com.hspedu.jdbc.datasource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0_ {
	 //@Test
	public void testC3P0_01() throws FileNotFoundException, IOException, SQLException {
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		Properties properties = new Properties();
		properties.load(new FileInputStream(
				"/Users/dreamtank117/Programming/Java/JavaVideoPractice_/Chapter25/src/main/java/mysql.properties"));
		String user = properties.getProperty("user");
		String password = properties.getProperty("password");
		String url = properties.getProperty("url");

		comboPooledDataSource.setJdbcUrl(url);
		comboPooledDataSource.setUser(user);
		comboPooledDataSource.setPassword(password);

		comboPooledDataSource.setInitialPoolSize(10);
		comboPooledDataSource.setMaxPoolSize(50);
		long start = System.currentTimeMillis();
		for (int i = 0; i < 5000; i++) {
			Connection connection = comboPooledDataSource.getConnection();

			connection.close();
		}
		long end = System.currentTimeMillis();
		System.out.println("C3P0第一种方式 总时长= " + (end - start));
	}

	@Test
	public void testC3P0_02() throws SQLException {
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("hsp");
		
		long start = System.currentTimeMillis();
		for (int i = 0; i < 5000; i++) {
			Connection connection = comboPooledDataSource.getConnection();

			connection.close();
		}
		long end = System.currentTimeMillis();
		System.out.println("C3P0第二种方式 总时长= " + (end - start));

	}

}
