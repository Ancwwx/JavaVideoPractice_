package com.hspedu.jdbc.myjdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class statement_ {
	public static void main(String[] args) throws FileNotFoundException, IOException, SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入管理员姓名");

		String admin_name = scanner.nextLine();// next 空格回车表示结束 nextline回车才表示结束
		System.out.println("请输入管理员密码");
		String admin_pwd = scanner.nextLine();

		Properties properties = new Properties();
		properties.load(new FileInputStream(
				"/Users/dreamtank117/Programming/Java/JavaVideoPractice_/Chapter25/src/main/java/mysql.properties"));
		String user = properties.getProperty("user");
		String password = properties.getProperty("password");
		String url = properties.getProperty("url");
		Connection connection = DriverManager.getConnection(url, user, password);
		Statement statement = connection.createStatement();
		String sql = "select  NAME,pwd from admin where NAME= '" + admin_name + "'  and pwd= '" + admin_pwd + "' ";
		ResultSet resultSet = statement.executeQuery(sql);
		if (resultSet.next()) {
			System.out.println("登录成功 ");

		} else {
			System.out.println("登录失败 ");
		}
		resultSet.close();
		statement.close();
		connection.close();
	}

}
