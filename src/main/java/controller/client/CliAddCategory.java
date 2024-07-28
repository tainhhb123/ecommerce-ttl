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
 * Servlet implementation class CliAddCategory
 */
@WebServlet("/CliAddCategory")
public class CliAddCategory extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String status = request.getParameter("status");
		javax.servlet.http.HttpSession session = request.getSession();
		int idUser = (int) session.getAttribute("idUser");
		Dao dao = new Dao();
		
		if(status.equals("on")) {
			dao.insertCategory(name, description, idUser, 1);
		}else{
			dao.insertCategory(name, description, idUser, 0);
		}
		request.setAttribute("signal", "Inserted successfully.");
		
		RequestDispatcher rd = request.getRequestDispatcher("clicategory.jsp");
		rd.forward(request, response);
	}

}
