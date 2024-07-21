package connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoCheckLogin {
	 Connect cn = new Connect();
	    Connection conn = cn.getConnection();

	    public int checkLogin(String email, String password) {
	        String sql = "SELECT status FROM users WHERE Email = ? AND Password = ?";
	        PreparedStatement stmt = null;
	        try {
	            stmt = conn.prepareStatement(sql);
	            stmt.setString(1, email);
	            stmt.setString(2, password);
	            System.out.println("Executing query: " + sql);
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	                int status = rs.getInt("status");
	                System.out.println("User status: " + status);
	                return status;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (stmt != null) stmt.close();
	                if (conn != null) conn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        return -1; 
	    }
}
