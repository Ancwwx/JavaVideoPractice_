package com.hspedu.preparedstatement_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class PreparedStatementDML_ {
	public static void main(String[] args) throws FileNotFoundException, IOException, SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入要删除的管理员姓名");

		String admin_name = scanner.nextLine();
//		System.out.println("请输入修改的管理员密码");
//		String admin_pwd = scanner.nextLine();

		Properties properties = new Properties();
		properties.load(new FileInputStream(
				"/Users/dreamtank117/Programming/Java/JavaVideoPractice_/Chapter25/src/main/java/mysql.properties"));
		String user = properties.getProperty("user");
		String password = properties.getProperty("password");
		String url = properties.getProperty("url");
		Connection connection = DriverManager.getConnection(url, user, password);
		
		//String sql = "insert into admin values(?,?) ";
		//String sql = "update admin set pwd=? where name=? ";
		String sql = "delete from admin where name=? ";
		
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
	   preparedStatement.setString(1, admin_name);
	   //preparedStatement.setString(2, admin_name);
	 
	   // 如果执行的是 dml (update, insert , delete) executeupdate()
		int rows = preparedStatement.executeUpdate();
		System.out.println(rows>0?"成功":"失败");
		preparedStatement.close();
		connection.close();
	}

}
