package com.library.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.dao.SignupCrendentials;
@WebServlet("/signup")
public class Signup extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html");
	String username=req.getParameter("username");
	String password=req.getParameter("password");
	SignupCrendentials.save(username, password);
	PrintWriter out=resp.getWriter();
	resp.sendRedirect("adminLogin.html");
	out.flush();
	out.close();
	
}
}
