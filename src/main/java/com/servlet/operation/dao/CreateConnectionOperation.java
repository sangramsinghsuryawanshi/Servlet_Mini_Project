package com.servlet.operation.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class CreateConnectionOperation 
{
	public static Connection isConnected()
	{
		Connection conn =null;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servletoperation","root","12345");
		} 
		catch (Exception e) 
		{
			
		}
		return conn;
	}
}
