package com.hspedu.jdbc.datasource;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;


public class JDBCUtilsByDruid_USE {

	@Test
	public void testSelect() {
		Connection connection = null;
		String sql = "select * from actor";
		PreparedStatement preparedStatement = null;
		ResultSet set = null;
		try {
			connection = JDBCUtilesByDruid.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			set = preparedStatement.executeQuery();

			while (set.next()) {
				int id = set.getInt("id");
				String name = set.getString("name");
				String sex = set.getString("sex");
				Date borndate = set.getDate("borndate");
				String phone = set.getString("phone");
				System.out.println(id + "\t" + name + "\t" + sex + "\t" + borndate + "\t" + phone);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtilesByDruid.close(set, preparedStatement, connection);
		}

	}

}
