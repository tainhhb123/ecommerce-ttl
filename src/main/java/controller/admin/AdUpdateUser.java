package controller.admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

import connect.Dao;

/**
 * Servlet implementation class AdUpdateUser
 */
@WebServlet("/AdUpdateUser")
public class AdUpdateUser extends HttpServlet {
	   @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        int userId = Integer.parseInt(request.getParameter("userId"));
	        int status = Integer.parseInt(request.getParameter("status"));

	        Dao userDao = new Dao();
	        boolean isUpdated = userDao.updateUserStatus(userId, status);

	        if (isUpdated) {
	            response.setStatus(HttpServletResponse.SC_OK);
	        } else {
	            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	        }
	    }
	
}
