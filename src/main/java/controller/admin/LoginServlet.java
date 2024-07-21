package controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connect.Dao;
import connect.DaoCheckLogin;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	   private static final long serialVersionUID = 1L;

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String email = request.getParameter("signin-email");
	        String password = request.getParameter("signin-password");

	        DaoCheckLogin daoCheckLogin = new DaoCheckLogin();
	        int status = daoCheckLogin.checkLogin(email, password);

	        if (status == 1) {
	            response.sendRedirect("AdIndex.jsp");
	        } else if (status == 3) {
	            response.sendRedirect("cusindex.jsp");
	        } else {
	            response.sendRedirect("login.jsp?error=true");
	        }
	    }
}
