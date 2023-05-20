package com.library.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.dao.BookDao;

@WebServlet("/deleteServelet")
public class DeleteServelet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String bookid=req.getParameter("id");
	BookDao.delete(bookid);
	resp.sendRedirect("viewbookinfo");
}
}
