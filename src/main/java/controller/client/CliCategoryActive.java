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
 * Servlet implementation class CliCategoryActive
 */
@WebServlet("/CliCategoryActive")
public class CliCategoryActive extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String idCategory = request.getParameter("idCategory");
		String status = request.getParameter("status");
		Dao dao = new Dao();
		if((int)Integer.parseInt(status)==1) {
			dao.editstatusCategory(0, (int)Integer.parseInt(idCategory));
		}
		else if((int)Integer.parseInt(status)==0) {
			dao.editstatusCategory(1, (int)Integer.parseInt(idCategory));
		}
		RequestDispatcher rd = request.getRequestDispatcher("clicategory.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
