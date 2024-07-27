package controller.client;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connect.Dao;

/**
 * Servlet implementation class CliEditCategory
 */
@WebServlet("/CliEditCategory")
public class CliEditCategory extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("idCategory");
		Dao dao = new Dao();
		Vector cate = dao.getCategoryById((int) Integer.parseInt(id));
		System.out.println(cate);
		request.setAttribute("category", cate);
		RequestDispatcher rd = request.getRequestDispatcher("clieditcategory.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		System.out.println(description);
		String status = request.getParameter("status");
		String idCate = request.getParameter("idCate");
		Dao dao = new Dao();
		
		if(status != null) {
			dao.editCategory(name, description, 1, (int) Integer.parseInt(idCate));
		}else{
			dao.editCategory(name, description, 0, (int) Integer.parseInt(idCate));
		}
		request.setAttribute("signal", "Edited successfully.");
		
		RequestDispatcher rd = request.getRequestDispatcher("clicategory.jsp");
		rd.forward(request, response);
	}

}
