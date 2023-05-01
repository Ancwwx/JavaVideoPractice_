package com.hspedu.mhl.utils;

import java.sql.Connection;
import java.sql.SQLException;
//测试类

public class Test {
	public static void main(String[] args) throws SQLException {
		System.out.println("请输入一个整数");
		int i = Utility.readInt();
		System.out.println("i= " + i);

		Connection connection = JDBCUtilesByDruid.getConnection();
		System.out.println(connection);

	}

}
