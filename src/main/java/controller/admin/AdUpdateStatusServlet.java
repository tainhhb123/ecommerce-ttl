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

import connect.Connect;

@WebServlet("/AdUpdateStatusServlet")
public class AdUpdateStatusServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("UserID");
        int newStatus = Integer.parseInt(request.getParameter("status"));

        Connection conn = null;
        try {
            Connect db = new Connect();
            conn = db.getConnection();

            String sql = "UPDATE users SET status = ? WHERE UserName = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, newStatus);
            stmt.setString(2, userId);
            stmt.executeUpdate();

            response.sendRedirect("AdUserServlet");
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
