//Modify the program to use PreparedStatement for parameterized queries. 


//Write a Java program that performs the following CRUD operations: 
//Insert a new record. 
//Update an existing record. 
//Select and display records. 
//Delete a record from the database.

package com.jdbc;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.util.PreparedStatementUtil;


class stetament implements ActionListener {
	JFrame frame;
	JLabel l1, l2, l3, msg;
	JTextField t1, t2, t3;
	JButton b1, b2, b3, b4;

	public stetament() {
		frame = new JFrame("JDBC Assignment");
		frame.setLayout(new GridLayout(6, 2));
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		l1 = new JLabel("Enter your Id :");
		l2 = new JLabel("Enter your firstname :");
		l3 = new JLabel("Enter your lastname :");
		msg = new JLabel(" ");

		t1 = new JTextField(15);
		t2 = new JTextField(15);
		t3 = new JTextField(15);

		b1 = new JButton("Insert");
		b1.addActionListener(this);
		b2 = new JButton("Update");
		b2.addActionListener(this);
		b3 = new JButton("Delete");
		b3.addActionListener(this);
		b4 = new JButton("Display");
		b4.addActionListener(this);

		frame.add(l1);
		frame.add(t1);
		frame.add(l2);
		frame.add(t2);
		frame.add(l3);
		frame.add(t3);
		frame.add(b1);
		frame.add(b2);
		frame.add(b3);
		frame.add(b4);
		frame.add(msg);
	}

@Override
public void actionPerformed(ActionEvent e) 
{
	
	if(e.getSource()==b1)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/java1","root","");
			System.out.println("Connection succesfully established");
			
			Statement st=cn.createStatement();
			PreparedStatement ps = cn.prepareStatement("insert into student(id,firstname , lastname) values(?,?,?)");
			ps.setString(1,t1.getText());
			ps.setString(2,t2.getText());
			ps.setString(3,t3.getText());
		
			int x=ps.executeUpdate();
			
			if(x>0)
			{
				msg.setText("Record is Succesfully Inserted");
				
			}
			else
			{
				msg.setText("Record is not inserted");
			}
			cn.close();
			
		} 
		catch (Exception e1) 
		{
			e1.printStackTrace();
		}
	}
	else if (e.getSource() == b2) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/java1","root","");
			System.out.println("Connection succesfully established");
			
			Statement st=cn.createStatement();
			PreparedStatement ps = cn.prepareStatement("update student set firstname = ?  , lastname = ? where id=?");
			ps.setString(1,t2.getText());
			ps.setString(2,t3.getText());
			ps.setString(3,t1.getText());
		

			int x = ps.executeUpdate();

			if (x > 0) {
				msg.setText("Records is succesfully  Updated");
			} else {
				msg.setText("Records not succesfully Updated");
			}
			

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}	
	else if (e.getSource() == b3) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/java1","root","");
			System.out.println("Connection succesfully established");
			
			Statement st=cn.createStatement();
			PreparedStatement ps = cn.prepareStatement("delete from student  where id=?");
			ps.setString(1,t1.getText());
		

			int x = ps.executeUpdate();

			if (x > 0) {
				msg.setText("Records is succesfully  deleted");
			} else {
				msg.setText("Records not succesfully deleted");
			}
			

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}	
	
//	Write a program that executes a SELECT query and processes the ResultSet to 
//	display records from the database. 
	else if(e.getSource()==b4)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/java1","root","");
			System.out.println("Connection succesfully established");
			
			Statement st=cn.createStatement();
			PreparedStatement ps = cn.prepareStatement("select * from student where id=?");
			ps.setInt(1, Integer.parseInt(t1.getText()));
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				String fetchedRecord = "employee: Id: " + rs.getInt(1) + ", firstame: " + rs.getString(2)
				+ ", lastname: " + rs.getString(3);

				// This line Display record in the Screen
				msg.setText(fetchedRecord);
			}
			else
			{
				msg.setText("Record is not found..");
			}
			cn.close();
			
		} 
		catch (Exception e1) 
		{
			e1.printStackTrace();
		}
	}
		
}
}

public class Lab_5_PreparedStatement 
{

	public static void main(String[] args)
	{
		new stetament();
	}
}


