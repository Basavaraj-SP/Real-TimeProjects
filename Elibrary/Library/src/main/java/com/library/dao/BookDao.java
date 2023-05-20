package com.library.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.library.beans.Book;

public class BookDao {

	public static void insert(Book book) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/e_library", "root",
					"root");
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into book_info values(?,?,?,?,?)");
			preparedStatement.setString(1, book.getBookId());
			preparedStatement.setString(2, book.getBookName());
			preparedStatement.setString(3, book.getAuthor());
			preparedStatement.setString(4, book.getYop());
			preparedStatement.setString(5, book.getAddedBy());
			preparedStatement.executeUpdate();
			connection.close();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static LinkedList<Book> view() {
		LinkedList<Book> l = new LinkedList<Book>();
		Connection connection;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/e_library", "root", "root");
			PreparedStatement preparedStatement = connection.prepareStatement("select * from book_info ");
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Book book = new Book();
				book.setBookId(resultSet.getString("id"));
				book.setBookName(resultSet.getString("name"));
				book.setAuthor(resultSet.getString("author"));
				book.setYop(resultSet.getString("yop"));
				book.setAddedBy(resultSet.getString("addedby"));

				l.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return l;

	}

	public static void delete(String bookId) {
		int status = 0;
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/e_library", "root",
					"root");
			PreparedStatement preparedStatement = connection.prepareStatement("delete from  book_info where id=?");
			preparedStatement.setString(1, bookId);
			status = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
