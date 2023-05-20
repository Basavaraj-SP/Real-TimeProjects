package com.todo.servlets;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.todo.beans.TodoList;
import com.todo.dao.ListDAO;

@WebServlet("/addtasks")
public class InsertTasks extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html");
	PrintWriter out = resp.getWriter();
	HttpSession session=req.getSession();
	String msg=req.getParameter("task");
	TodoList todo=new TodoList(msg);
    ListDAO.insert(todo);
	req.getRequestDispatcher("AddingTask.html").include(req, resp);
	}
}
