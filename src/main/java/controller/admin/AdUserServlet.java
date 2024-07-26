package controller.admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connect.Connect;
import connect.Dao;
import model.User;

@WebServlet("/AdUserServlet")
public class AdUserServlet extends HttpServlet {
	 private static final long serialVersionUID = 1L;

	    @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        Dao userDao = new Dao();
	        
	        int page = 1;
	        int pageSize = 3;
	        
	        if (request.getParameter("page") != null) {
	            page = Integer.parseInt(request.getParameter("page"));
	        }
	        
	        List<User> userList = userDao.getUsersByPage(page, pageSize);
	        int totalUsers = userDao.getTotalUserCount();
	        int totalPages = (int) Math.ceil((double) totalUsers / pageSize);
	        
	        request.setAttribute("userList", userList);
	        request.setAttribute("currentPage", page);
	        request.setAttribute("totalPages", totalPages);
	        request.getRequestDispatcher("/adListuser.jsp").forward(request, response);
	    }
}
