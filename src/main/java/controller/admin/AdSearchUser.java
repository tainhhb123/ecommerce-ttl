package controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connect.Dao;

import model.User;

/**
 * Servlet implementation class SearchAdUserServlet
 */
@WebServlet("/AdSearchUser")
public class AdSearchUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Dao searchUserDao = new Dao();
    	String searchQuery = request.getParameter("searchuser");
        int page = 1;
        int pageSize = 2;

        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));       
        }

        List<User> searchResults = searchUserDao.searchUsers(searchQuery, page, pageSize);
        int totalUsers = searchUserDao.getSearchUserCount(searchQuery);
        int totalPages = (int) Math.ceil((double) totalUsers / pageSize);

        request.setAttribute("searchResults", searchResults);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("currentPage", page);
        request.setAttribute("searchQuery", searchQuery);
        
        request.getRequestDispatcher("/adListuser.jsp").forward(request, response);
    }
}
