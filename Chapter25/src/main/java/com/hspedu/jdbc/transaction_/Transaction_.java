package com.hspedu.jdbc.transaction_;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.Test;

import com.hspedu.jdbc.utils.JDBCUtiles;

public class Transaction_ {

	public void noTransaction() {
		Connection connection = null;
		String sql = "update account set balance=balance-100 where id=1 ";
		String sql2 = "update account set balance=balance+100 where id=2 ";
		
		PreparedStatement preparedStatement = null;
		try {
			connection = JDBCUtiles.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			
			int i=1/0;
			
			preparedStatement = connection.prepareStatement(sql2);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtiles.close(null, preparedStatement, connection);
		}

	}
@Test
       public void useTransaction() {
    		Connection connection = null;
    		String sql = "update account set balance=balance-100 where id=1 ";
    		String sql2 = "update account set balance=balance+100 where id=2 ";
    		
    		PreparedStatement preparedStatement = null;
    		try {
    			connection = JDBCUtiles.getConnection();
    			connection.setAutoCommit(false);
    			preparedStatement = connection.prepareStatement(sql);
    			preparedStatement.executeUpdate();
    			
    			preparedStatement = connection.prepareStatement(sql2);
    			preparedStatement.executeUpdate();
    			
    			connection.commit();
    		} catch (Exception e) {
    			System.out.println("执行发生了异常，撤销执行的sql");
    			try {
					connection.rollback();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				e.printStackTrace();
    		} finally {
    			JDBCUtiles.close(null, preparedStatement, connection);
    		}
	
}

}
