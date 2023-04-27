package com.hspedu.jdbc.myjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Jdbc01 {
	public static void main(String[] args) throws SQLException {
		//Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/hsp_db01","root","mt123456");
		
		// 注册驱动
		//Driver driver = new com.mysql.cj.jdbc.Driver();
		// 得到连接 serverTimezone=UTC&useSSL=false   ?useUnicode=true&characterEncoding=utf8
//		String url = "jdbc:mysql://localhost:3306/hsp_db01";
//		Properties properties = new Properties();
//		properties.setProperty("user", "root");
//		properties.setProperty("password", "mt123456");
//		Connection connect =  driver.connect(url, properties);

		// 执行sql
		//String sql = "insert into actor values(null,'刘德华','男','1970-11-11','110')";
		//String sql="update actor set name='周星驰' where id=1";
		String sql="delete from actor where id=1";
		Statement statement =  connect.createStatement();
		int rows = statement.executeUpdate(sql);
		System.out.println(rows > 0 ? "成功" : "失败");

		// 关闭连接资源
		statement.close();
		connect.close();
	}

}
