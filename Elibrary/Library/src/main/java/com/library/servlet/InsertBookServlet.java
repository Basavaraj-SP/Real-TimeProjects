package com.library.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.beans.Book;
import com.library.dao.BookDao;

@WebServlet("/bookinfo")
public class InsertBookServlet  extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html");
	PrintWriter out = resp.getWriter();
	HttpSession session=req.getSession();
	String id=req.getParameter("id");
	String bookName=req.getParameter("bname");
	String author=req.getParameter("bauthour");
	String yop=req.getParameter("byop");
	String addeby=(String) session.getAttribute("username");
	Book book= new Book(id,bookName,author,yop,addeby);
    BookDao.insert(book);
	req.getRequestDispatcher("bookinfo.html").include(req, resp);
	}
}
