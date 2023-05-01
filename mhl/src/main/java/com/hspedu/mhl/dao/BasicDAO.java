package com.hspedu.mhl.dao;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.hspedu.mhl.utils.JDBCUtilesByDruid;

public class BasicDAO<T> {
	private QueryRunner qr = new QueryRunner();

	public int update(String sql, Object... parameters) {

		Connection connection = null;
		try {

			connection = JDBCUtilesByDruid.getConnection();
			int update = qr.update(connection, sql, parameters);
			return update;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JDBCUtilesByDruid.close(null, null, connection);

		}
	}

	public List<T> queryMulti(String sql, Class<T> clazz, Object... parameters) {
		Connection connection = null;
		try {

			connection = JDBCUtilesByDruid.getConnection();
			return qr.query(connection, sql, new BeanListHandler<T>(clazz), parameters);

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JDBCUtilesByDruid.close(null, null, connection);

		}

	}

	public T querySingle(String sql, Class<T> clazz, Object... parameters) {
		Connection connection = null;
		try {

			connection = JDBCUtilesByDruid.getConnection();
			return qr.query(connection, sql, new BeanHandler<T>(clazz), parameters);

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JDBCUtilesByDruid.close(null, null, connection);

		}

	}
	public Object queryScalar(String sql,Object...parameters) {
		
		Connection connection = null;
		try {

			connection = JDBCUtilesByDruid.getConnection();
			return qr.query(connection, sql, new ScalarHandler(), parameters);

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JDBCUtilesByDruid.close(null, null, connection);

		}
		
	}

}
