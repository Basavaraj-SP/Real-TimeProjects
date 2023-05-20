package com.todo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginValidate {

	public boolean isValidate(String username, String password) {
		String usname = null;
		String ps = null;
		boolean validate = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/to-do", "root",
					"root");

			PreparedStatement preparedStatement = connection.prepareStatement("select * from login where username=?");
			preparedStatement.setString(1, username);
			ResultSet resultset = preparedStatement.executeQuery();
			while (resultset.next()) {
				usname = resultset.getString("username");
				ps = resultset.getString("password");
			}
			
			if ((usname!=null && ps!=null) && usname.equals(username) && ps.equals(password)) {

				return validate = true;

			}

			connection.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return validate;
	}
}

	

