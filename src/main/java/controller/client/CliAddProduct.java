package controller.client;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import connect.Dao;
import jakarta.servlet.annotation.MultipartConfig;

/**
 * Servlet implementation class CliAddProduct
 */
@WebServlet("/CliAddProduct")

public class CliAddProduct extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String description = request.getParameter("describe");
		String status = request.getParameter("status");
		String brandt = request.getParameter("brand");
		String categoryt = request.getParameter("category");
		String afft = request.getParameter("aff");
		String sext = request.getParameter("sex");
		System.out.print(brandt+ categoryt+ sext+ afft);
		int brand = Integer.parseInt(brandt);
		int category = Integer.parseInt(categoryt);
		int aff = Integer.parseInt(afft);
		int sex =Integer.parseInt(sext) ;
		
		javax.servlet.http.HttpSession session = request.getSession();
		int idUser = (int) session.getAttribute("idUser");
		Random random = new Random();
	    int idProduct = 10000 + random.nextInt(90000);
	    session.setAttribute("idProduct",idProduct);
		Dao dao = new Dao();
		if(status != null) {
			dao.insertProduct(idProduct, name, description, brand, category, sex, aff, idUser, 1);
		}else{
			dao.insertProduct(idProduct, name, description, brand, category, sex, aff, idUser, 0);
		}

		
		request.setAttribute("signal", "Inserted successfully."); 
		RequestDispatcher rd = request.getRequestDispatcher("cliaddproduct.jsp");
		rd.forward(request, response);
	}

}
