package com.library.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SignupCrendentials {
	
	public static void save(String username, String password) {
		String usname=username;
		String psw=password;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/e_library", "root",
					"root");
			PreparedStatement preparedStatement =connection.prepareStatement("insert into admin_login values(?,?)");
			preparedStatement.setString(1, usname);
			preparedStatement.setString(2, psw);
			preparedStatement.execute();
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
	
	
	
	
}
