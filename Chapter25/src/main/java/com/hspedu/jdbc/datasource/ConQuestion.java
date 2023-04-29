package com.hspedu.jdbc.datasource;

import java.sql.Connection;

import org.junit.Test;

import com.hspedu.jdbc.utils.JDBCUtiles;

public class ConQuestion {
	@Test
	public void testCon() {
	long start=System.currentTimeMillis();
	for(int i=0;i<5000;i++) {
		Connection connection=JDBCUtiles.getConnection();
		
		JDBCUtiles.close(null, null, connection);
	}
	long end=System.currentTimeMillis();
	System.out.println("总时长= "+(end-start));
	}

}
