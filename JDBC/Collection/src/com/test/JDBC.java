package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.utils.ConnectionUtils;

public class JDBC {

	public static void main(String[] args) {
		try {

			/*
			 * Class.forName("com.mysql.jdbc.Driver"); // 2.Create Connection Object
			 * Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root","root");
			 */ 
			Connection con = ConnectionUtils.getConnection(); // 3.Create Statement

			Statement st = con.createStatement();

			// 4.Excute Query
			ResultSet rs = st.executeQuery("select * from emp");
			while (rs.next())
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));

			// 5.Close The Connection
			con.close();
		} catch (Exception e) 
		{
			System.out.println(e);
		}
	}
}
