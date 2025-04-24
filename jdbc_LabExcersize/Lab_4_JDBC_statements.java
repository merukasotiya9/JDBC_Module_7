//Create a program that inserts, updates, selects, and deletes data using Statement. 
//o Write SQL queries for: 
//Inserting a record into a table. 
//Updating specific fields of a record. 
//Selecting records based on certain conditions. 
//Deleting specific records. 
//o Implement these queries in Java using JDBC. 

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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

class simple implements ActionListener
{
	JFrame frame;
	JLabel l1,l2,l3,l4,l5,msg;
	JTextField t1,t2,t3,t4;
	JPasswordField p1;
	JButton b1,b2,b3,b4,b5;
	
	public simple()
	{
		frame=new JFrame("JDBC Assignment");
		frame.setLayout(new GridLayout(8,2));
		frame.setSize(500,500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		l1=new JLabel("Enter your firstname:");
		l2=new JLabel("Enter your lastname:");
		l3=new JLabel("Enter your Username:");
		l4=new JLabel("Enter your age:");
		l5=new JLabel("Enter your password:");
		msg=new JLabel(" ");

		t1=new JTextField(15);
		t2=new JTextField(15);
		t3=new JTextField(15);
		t4=new JTextField(15);
		p1=new JPasswordField(15);
		
		b1=new JButton("Insert");
		b1.addActionListener(this);
		b2=new JButton("Update");
		b2.addActionListener(this);
		b3=new JButton("Delete");
		b3.addActionListener(this);
		b4=new JButton("Display");
		b4.addActionListener(this);
		
		frame.add(l1);
		frame.add(t1);
		frame.add(l2);
		frame.add(t2);
		frame.add(l3);
		frame.add(t3);
		frame.add(l4);
		frame.add(t4);
		frame.add(l5);
		frame.add(p1);
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
				
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment","root","");
				System.out.println("Connection succesfully established");
				
				Statement st=cn.createStatement();
//				PreparedStatement ps = cn.prepareStatement("insert into employee(firstname , lastname , username , age , password) values(?,?,?,?,?)");
//				ps.setString(1,t1.getText());
//				ps.setString(2,t2.getText());
//				ps.setString(3,t3.getText());
//				ps.setString(4, t4.getText());
//				ps.setString(5,p1.getText());
			
//				int x=ps.executeUpdate();
				int x=st.executeUpdate("insert into employee values('"+t1.getText()+"','"+t2.getText()+"','"+t3.getText()+"','"+Integer.parseInt(t4.getText())+"','"+p1.getText()+"')");
				
				
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
		
		else if(e.getSource()==b2)
		{
			try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment","root","");
			System.out.println("Connection Successfully established");
			
			Statement st=cn.createStatement();
//			PreparedStatement ps = cn.prepareStatement("update employee set firstname=? , lastname=? , username=? , password=? where age=?");
//			ps.setString(1,t1.getText());
//			ps.setString(2,t2.getText());
//			ps.setString(3,t3.getText());
//			ps.setInt(4,Integer.parseInt(t4.getText()));
//			ps.setString(5,p1.getText());
//		
//			int x=ps.executeUpdate();
//		
			int x=st.executeUpdate("update employee set firstname='"+t1.getText()+"',lastname='"+t2.getText()+"',username='"+t3.getText()+"',password='"+p1.getText()+"'where age='"+Integer.parseInt(t4.getText())+"'");
			
			if(x>0)
			{
				msg.setText("Record Is succesfully Updated.");
			}
			else
			{
				msg.setText("Record Is succesfully not Updated.");
			}
			cn.close();
			
			
		} catch (Exception e1) 
		{
			e1.printStackTrace();
		}
	}
		
		else if(e.getSource()==b3)
		{
			try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment","root","");
			System.out.println("Connection Succesfully established");
			
			Statement st=cn.createStatement();

		
			int x=st.executeUpdate("delete from employee where age='"+t4.getText()+"'");
			
			
			if(x>0)
			{
				msg.setText("Record successfully deleted..");
			}
			else
			{
				msg.setText("Record not successfully deleted..");
			}
			cn.close();
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
		
		else if(e.getSource()==b4)
		{
			try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment","root","");
			System.out.println("Connection succesfully established");
			
			Statement st=cn.createStatement();
			
			ResultSet rs=st.executeQuery("select * from employee");
			while(rs.next())
			{
				System.out.println("firstname :- "+rs.getString(1));
				System.out.println("lasttname :- "+rs.getString(2));
				System.out.println("username :- "+rs.getString(3));
				System.out.println("age :- "+rs.getInt(4));
				System.out.println("Password :- "+rs.getString(5));
				System.out.println();
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

public class Lab_4_JDBC_statements {

	public static void main(String[] args) 
	{
		new simple(); 
	}

}