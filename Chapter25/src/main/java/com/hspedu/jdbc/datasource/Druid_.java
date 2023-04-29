package com.hspedu.jdbc.datasource;

import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import org.junit.Test;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class Druid_ {
	@Test
	public void testDruid() throws Exception {
		Properties properties = new Properties();
		properties.load(new FileInputStream(
				"/Users/dreamtank117/Programming/Java/JavaVideoPractice_/Chapter25/src/main/java/druid.properties"));
		DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

		long start = System.currentTimeMillis();
		for (int i = 0; i < 5000; i++) {
			Connection connection = dataSource.getConnection();

			connection.close();
		}
		long end = System.currentTimeMillis();
		System.out.println("druid方式 总时长= " + (end - start));

	}

}
