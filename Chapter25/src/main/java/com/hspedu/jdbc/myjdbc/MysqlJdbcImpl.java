package com.hspedu.jdbc.myjdbc;

public class MysqlJdbcImpl implements JdbcInterface{

	@Override
	public Object getConnection() {
		System.out.println("得到 mysql 的连接");
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void crud() {
		System.out.println("完成 mysql 的增删改查");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void close() {
		System.out.println("关闭 mysql 的连接");
		// TODO Auto-generated method stub
		
	}

}
