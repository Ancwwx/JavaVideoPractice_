package com.hspedu.jdbc.batch_;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import com.hspedu.jdbc.utils.JDBCUtiles;

public class Batch_ {

	public void noBatch() throws SQLException {
		Connection connection = JDBCUtiles.getConnection();
		String sql = "insert into admin2 values (null,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		System.out.println("开始执行");
		long start = System.currentTimeMillis();
		for (int i = 0; i < 5000; i++) {
			preparedStatement.setString(1, "jack" + i);
			preparedStatement.setString(2, "666");
			preparedStatement.executeUpdate();

		}
		long end = System.currentTimeMillis();
		System.out.println("所用时间= " + (end - start));
		JDBCUtiles.close(null, preparedStatement, connection);

	}

	@Test
	public void batch() throws SQLException {
		Connection connection = JDBCUtiles.getConnection();
		String sql = "insert into admin2 values (null,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		System.out.println("开始执行");
		long start = System.currentTimeMillis();
		for (int i = 0; i < 5000; i++) {
			preparedStatement.setString(1, "jack" + i);
			preparedStatement.setString(2, "666");
			preparedStatement.addBatch();
			if ((i + 1) % 1000 == 0) {
				preparedStatement.executeBatch();
				preparedStatement.clearBatch();
			}

		}
		long end = System.currentTimeMillis();
		System.out.println("所用时间= " + (end - start));
		JDBCUtiles.close(null, preparedStatement, connection);

	}

}
