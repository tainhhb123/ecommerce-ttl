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
 * Servlet implementation class CliAddBrand
 */
@WebServlet("/CliAddBrand")
public class CliAddBrand extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String country = request.getParameter("country");
		String status = request.getParameter("status");
		javax.servlet.http.HttpSession session = request.getSession();
		int idUser = (int) session.getAttribute("idUser");
		Dao dao = new Dao();
		
		if(status.equals("on")) {
			dao.insertBrand(name, country, idUser, 1);
		}else{
			dao.insertBrand(name, country, idUser, 0);
		}
		request.setAttribute("signal", "Inserted successfully.");
		
		RequestDispatcher rd = request.getRequestDispatcher("clibrand.jsp");
		rd.forward(request, response);
	}

}
