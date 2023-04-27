package com.hspedu.jdbc.myjdbc;

public class OracleJdbcImpl implements JdbcInterface{

	@Override
	public Object getConnection() {
System.out.println("得到 oracle的连接");
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void crud() {
		System.out.println("完成 oracle的增删改查");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void close() {
		System.out.println("关闭 oracle的连接");
		// TODO Auto-generated method stub
		
	}

}
