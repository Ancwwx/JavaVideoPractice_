package com.hspedu.jdbc.datasource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

public class DBUtils_USE {

	public void testQueryMany() throws SQLException {
		Connection connection = JDBCUtilesByDruid.getConnection();

		QueryRunner queryRunner = new QueryRunner();

		String sql = "select * from actor where id >=?";
		List<Actor> list = queryRunner.query(connection, sql, new BeanListHandler<>(Actor.class), 1);

		System.out.println("输出集合的信息");
		for (Actor actor : list) {
			System.out.println(actor);
		}

		JDBCUtilesByDruid.close(null, null, connection);

	}

	// @Test
	// 演示 apache-dbutils + druid 完成 返回的结果是单行记录（单个对象）
	public void testQuerySingle() throws SQLException {
		Connection connection = JDBCUtilesByDruid.getConnection();
		QueryRunner queryRunner = new QueryRunner();
		String sql = "select * from actor where id=?";
		Actor actor = queryRunner.query(connection, sql, new BeanHandler<>(Actor.class), 4);
		System.out.println(actor);

		JDBCUtilesByDruid.close(null, null, connection);
	}

	// @Test
	// 演示 apache-dbutils + druid 完成 返回的结果是单行单列 (返回的是object）
	public void testScalar() throws SQLException {
		Connection connection = JDBCUtilesByDruid.getConnection();
		QueryRunner queryRunner = new QueryRunner();
		String sql = "select name from actor where id=?";
		Object obj = queryRunner.query(connection, sql, new ScalarHandler(), 4);
		System.out.println(obj);

		JDBCUtilesByDruid.close(null, null, connection);

	}

	@Test
	// 演示 apache-dbutils + druid 完成 返回的结果是单行单列 (返回的是object）
	public void testDML() throws SQLException {
		Connection connection = JDBCUtilesByDruid.getConnection();
		QueryRunner queryRunner = new QueryRunner();
		//String sql = "update actor set name =?  where id=?"; 
		//String sql = "INSERT INTO actor VALUES(NULL,?,?,?,?)";
		String sql = "delete from actor where id=?";
		
		// 返回受影响的行数
		//int affectedRow = queryRunner.update(connection, sql, "林青霞","女","1966-10-16","116");
		int affectedRow = queryRunner.update(connection, sql, 5);
		
		
		System.out.println(affectedRow > 0 ? "执行成功" : "未影响数据库");
		JDBCUtilesByDruid.close(null, null, connection);

	}

}
