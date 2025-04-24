//o Write a simple Java program to connect to a MySQL database using JDBC
package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Lab_1_Connect_mysql 
{	
	public static void main(String[] args)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment","root","");
			System.out.println("Connection established...");
			
			Statement st=cn.createStatement();
			
			ResultSet rs=st.executeQuery("select * from employee");
			
			while(rs.next())
			{
				System.out.println("Employee Id is :- "+rs.getInt(1));
				System.out.println("Employee name is :- "+rs.getString(2));
				System.out.println("Employee age is :- "+rs.getInt(3));
				System.out.println("Employee salary is :- "+rs.getInt(4));
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
