//Demonstrate the process of loading a JDBC driver and establishing a connection
//Identify which driver your Java program uses to connect to MySQL.

package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Lab_2_Loading_JDBC
{

	public static void main(String[] args) 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");  //loading the jdbc driver
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment","root","");
			// connection established 
			System.out.println("Connection established...");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		
	}

}
