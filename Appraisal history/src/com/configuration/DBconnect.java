package com.configuration;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.sun.jdi.connect.spi.Connection;
public class DBconnect {
	private static  String url="jdbc:mysql://localhost:3307/appraisal";
	private static  String username="root";
	private static  String password="root";


	public static java.sql.Connection getConnection()
	{
		java.sql.Connection con=null;
		try {
			con=DriverManager.getConnection(url,username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}
