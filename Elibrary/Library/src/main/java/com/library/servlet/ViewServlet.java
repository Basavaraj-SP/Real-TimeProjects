package com.library.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.beans.Book;
import com.library.dao.BookDao;

@WebServlet("/viewbookinfo")
public class ViewServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html");
	PrintWriter out=resp.getWriter();
	out.print("<!DOCTYPE html>");
	out.print("<html>");
	out.println("<head>");
	out.println("<title>Login Section</title>");
	out.println("<link rel='stylesheet' href='header.css'>");
	out.println("</head>");
	out.println("<body>");
	req.getRequestDispatcher("header.html").include(req, resp);
	out.println("<div class='content'>");
	out.println("<table class='table'><thead> "
			+ "<tr> "
			+ "<th> Id</th>"
			+"<th> Book Name</th>"
			+"<th> Book Author</th>"
			+"<th> Book YOP</th>"
			+"<th> Added By</th>"
			+"<th>Delete</th>"
			+"</tr></thead>"
			);
	List<Book> list=BookDao.view();
	for (Book book : list) {
		out.println("<tr><td>"+book.getBookId()+"</td>"
				+ "<td>"+book.getBookName()+"</td>"
				+ "<td>"+book.getAuthor()+"</td>"
				 +"<td>"+book.getYop()+"</td>"
				 +"<td>"+book.getAddedBy()+"</td>"
				 +"<td><a class='del'  href='deleteServelet?id="+book.getBookId()+"'>Delete</a></td>"
				 		+ "</tr>");
	}
	out.println("</table>");
	out.println("</div>");
	
	
	req.getRequestDispatcher("Footer.html").include(req, resp);
	out.close();
	
}
	
}
