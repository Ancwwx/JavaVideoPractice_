package com.hspedu.jdbc.myjdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.Test;

public class JdbcConn {
	@Test
	public void connect02() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		Properties properties= new Properties();
		properties.load(new FileInputStream("/Users/dreamtank117/Programming/Java/JavaVideoPractice_/Chapter25/src/main/java/mysql.properties"));
	    String user=properties.getProperty("user");
	    String password=properties.getProperty("password");
	   
	    String url=properties.getProperty("url");
	    //String driver=properties.getProperty("driver");
	    
	   // Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection connection=DriverManager.getConnection(url,user,password);
	    System.out.println("连接"+connection);
	
	
	}

}
