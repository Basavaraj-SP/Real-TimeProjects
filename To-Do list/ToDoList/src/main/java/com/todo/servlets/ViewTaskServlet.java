package com.todo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.todo.beans.TodoList;
import com.todo.dao.ListDAO;

@WebServlet("/viewtasks")
public class ViewTaskServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Login Section</title>");
		out.println("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">");
		out.println("<link rel='stylesheet' href='viewtasks.css'>");
		out.println("</head>");
		out.println("<body>");
		out.println(" <div class=\"text\">" 
				+ "        <h2>Dream it.</h2>" 
				+ "        <h2>List it.</h2>"
				+ "        <h2>Do it.</h2>" 
				+ "    </div>");
		out.println(" <table class=\"table\">");
		List<TodoList> list = ListDAO.view();
		for (TodoList todo : list) {
			out.println("<tr class='row'><td class='data'>" + todo.getTask() + "</td>"
					+ "<td><a class='icon'  href='deletetask?task="
					+ todo.getTask() + "'><i class=\"fa fa-times-circle-o\" aria-hidden=\"true\"></a></td>" + "</tr>");
		}
		out.println(" </table>");
		out.println("  <a href=\"AddingTask.html\" class=\"add\"> ADD NEW TASK</a>");
		out.println("</form>");
		out.println("</div>");
		out.close();

	}
}
