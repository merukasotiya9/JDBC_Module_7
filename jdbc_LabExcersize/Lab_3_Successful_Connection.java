//Write a Java program to establish a connection to a database and print a confirmation message upon successful connection.
package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Lab_3_Successful_Connection
{

	public static void main(String[] args) throws SQLException 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/java1","root","");
			System.out.println("Connection Successfull...");
		} 
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
	}

}
