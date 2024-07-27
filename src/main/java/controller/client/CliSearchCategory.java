package controller.client;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connect.Dao;

/**
 * Servlet implementation class CliSearchCategory
 */
@WebServlet("/CliSearchCategory")
public class CliSearchCategory extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		request.setAttribute("name", name);
		RequestDispatcher rd = request.getRequestDispatcher("clisearchcategory.jsp");
		rd.forward(request, response);
	}

}
