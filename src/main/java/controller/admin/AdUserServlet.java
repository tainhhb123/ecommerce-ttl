package controller.admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connect.Connect;
import model.AdUser;

@WebServlet("/AdUserServlet")
public class AdUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = null;
        ArrayList<AdUser> userList = new ArrayList<>();

        try {
            Connect db = new Connect();
            conn = db.getConnection();

            String sql = "SELECT FullName, UserName, Email, PhoneNumber, dayofbirth, status FROM users";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                AdUser user = new AdUser();
                user.setFullName(rs.getString("FullName"));
                user.setUserName(rs.getString("UserName"));
                user.setEmail(rs.getString("Email"));
                user.setPhoneNumber(rs.getString("PhoneNumber"));
                java.sql.Date dateOfBirth = rs.getDate("dayofbirth");
                if (dateOfBirth == null || dateOfBirth.toString().equals("0000-00-00")) {
                    // Handle null or zero date value
                    user.setDateOfBirth(null); // or some default value
                } else {
                    user.setDateOfBirth(dateOfBirth);
                }
                user.setDateOfBirth(rs.getDate("Dayofbirth"));
                user.setStatus(rs.getInt("status"));
                userList.add(user);
            }

            System.out.println("User List Size: " + userList.size()); // Thêm dòng này để kiểm tra kích thước danh sách
            for (AdUser user : userList) {
                System.out.println(user.getFullName() + ", " + user.getUserName()); // In ra thông tin người dùng
            }
            
            request.setAttribute("userList", userList);
            request.getRequestDispatcher("./AdListuser.jsp").forward(request, response);
     


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
