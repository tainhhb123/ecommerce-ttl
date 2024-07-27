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
 * Servlet implementation class CliBrandActive
 */
@WebServlet("/CliBrandActive")
public class CliBrandActive extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String idBrand = request.getParameter("idBrand");
		String status = request.getParameter("status");
		Dao dao = new Dao();
		if((int)Integer.parseInt(status)==1) {
			dao.editstatusBrand(0, (int)Integer.parseInt(idBrand));
		}
		else if((int)Integer.parseInt(status)==0) {
			dao.editstatusBrand(1, (int)Integer.parseInt(idBrand));
		}
		RequestDispatcher rd = request.getRequestDispatcher("clibrand.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
