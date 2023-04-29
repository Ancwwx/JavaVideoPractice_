package com.hspedu.jdbc.utils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

public class JDBCUtiles_Use {
	
	
	@Test
	public void testSelect() {
	Connection connection=null;
		String sql="select * from actor";
		PreparedStatement preparedStatement=null;
		ResultSet set=null;
		try {
			connection=JDBCUtiles.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			set= preparedStatement.executeQuery();
			
			while(set.next()) {
				int id = set.getInt("id");
				String name = set.getString("name");
				String sex = set.getString("sex");
				Date borndate = set.getDate("borndate");
				String phone=set.getString("phone");
				System.out.println(id + "\t" + name + "\t" + sex + "\t" + borndate+"\t"+phone);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtiles.close(set,preparedStatement,connection);
		}
		
	}
	@Test
	public void testDML() {
	Connection connection=null;
		String sql="update actor set name=? where id=? ";
		PreparedStatement preparedStatement=null;
		try {
			connection=JDBCUtiles.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "kitty");
			preparedStatement.setInt(2, 4);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtiles.close(null,preparedStatement,connection);
		}
		
	}

}
