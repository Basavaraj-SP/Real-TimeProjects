package com.todo.dao;
import java.sql.*;
import java.util.LinkedList;

import com.todo.beans.TodoList;
public class ListDAO {

	public static void insert(TodoList todo) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/to-do", "root",
					"root");
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into tasks_info values(?)");
			preparedStatement.setString(1, todo.getTask());
			
			preparedStatement.executeUpdate();
			connection.close();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static LinkedList<TodoList> view() {
		LinkedList<TodoList> l = new LinkedList<TodoList>();
		Connection connection;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/to-do", "root", "root");
			PreparedStatement preparedStatement = connection.prepareStatement("select * from tasks_info ");
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				TodoList todo = new TodoList();
				todo.setTask(resultSet.getString("task"));
				
				l.add(todo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return l;

	}
	public static void delete(String name) {
		int status = 0;
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/to-do", "root",
					"root");
			PreparedStatement preparedStatement = connection.prepareStatement("delete from tasks_info where task=?");
			preparedStatement.setString(1, name);
			status = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
