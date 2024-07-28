package connect;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import model.User;

import java.util.Locale.Category;

public class Dao {
	Connect cn = new Connect();
	Connection conn = cn.getConnection();
	
	public ArrayList<model.Category> getCategory() {
		ArrayList<model.Category> listCate = new ArrayList();	
		String sqly = "SELECT * FROM categoryproduct";
		PreparedStatement stmy = null;
		try {
			stmy = conn.prepareStatement(sqly);
			ResultSet rs = stmy.executeQuery();
			while (rs.next()) {
				model.Category cate = new model.Category();
//				t.add(rs.getInt(1));
//				t.add(rs.getInt(2));
//				t.add(rs.getDouble(3));
//				t.add(rs.getString(4));
//				System.out.println(rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return listCate;
	}
	
	public Vector geUser(String name, String pass) {
		Vector t = new Vector();
		String sqly = "SELECT * FROM users where UserName=? and Password=?";
		PreparedStatement stmy;
		try {
			stmy = conn.prepareStatement(sqly);
			stmy.setString(1, name);
			stmy.setString(2, pass);
			ResultSet rs = stmy.executeQuery();
			if (rs.next()) {
				t.add(rs.getInt(1));
				t.add(rs.getString(2));
				t.add(rs.getString(3));
				t.add(rs.getString(4));
				t.add(rs.getString(5));
				t.add(rs.getString(6));
				t.add(rs.getString(7));
				t.add(rs.getInt(8));
				t.add(rs.getInt(9));
			}else {
				t = null;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return t;
	}
	public Vector geRoleOfUser(int id) {
		Vector list = new Vector();
		String sqly = "SELECT * FROM roles where userId=?";
		PreparedStatement stmy;
		try {
			stmy = conn.prepareStatement(sqly);
			stmy.setInt(1, id);
			ResultSet rs = stmy.executeQuery();
			while (rs.next()) {
				Vector t = new Vector();
				t.add(rs.getInt(1));
				t.add(rs.getString(2));
				t.add(rs.getInt(3));
				t.add(rs.getInt(4));
				list.add(t);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return list;
	}
	
	// admin
	
	//lấy dữ liệu thông tin người dùng từ database
//	public List<User> getAllUsers() {
//        List<User> userList = new ArrayList<>();
//        Connection conn = null;
//        
//        try {
//            Connect db = new Connect();
//            conn = db.getConnection();
//
//            String sql = "SELECT u.UserID, u.FullName, u.UserName, u.Email, u.PhoneNumber, u.dayofbirth, r.approval "
//                       + "FROM users u "
//                       + "LEFT JOIN roles r ON u.UserID = r.userId";
//            PreparedStatement stmt = conn.prepareStatement(sql);
//            ResultSet rs = stmt.executeQuery();
//
//            while (rs.next()) {
//                User user = new User();
//                user.setUserid(rs.getInt("UserID"));
//                user.setFullName(rs.getString("FullName"));
//                user.setUserName(rs.getString("UserName"));
//                user.setEmail(rs.getString("Email"));
//                user.setPhoneNumber(rs.getString("PhoneNumber"));
//                user.setDateOfBirth(rs.getDate("dayofbirth"));
//                user.setStatus(rs.getInt("approval"));
//                userList.add(user);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            if (conn != null) {
//                try {
//                    conn.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return null;
//    }
	
	//tìm kiếm trang listuser
//		public List<User> searchUsers(String searchQuery) {
//			List<User> users = new ArrayList<>();
//	        String sql = "SELECT * FROM Users WHERE FullName LIKE ? OR UserName LIKE ? OR Email LIKE ? OR PhoneNumber LIKE ?";
//	        try {
//	            PreparedStatement stmt = conn.prepareStatement(sql);
//	            String query = "%" + searchQuery + "%";
//	            stmt.setString(1, query);
//	            stmt.setString(2, query);
//	            stmt.setString(3, query);
//	            stmt.setString(4, query);
//
//	            ResultSet rs = stmt.executeQuery();
//	            while (rs.next()) {
//	                User user = new User();
//	                user.setFullName(rs.getString("FullName"));
//	                user.setUserName(rs.getString("UserName"));
//	                user.setEmail(rs.getString("Email"));
//	                user.setPhoneNumber(rs.getString("PhoneNumber"));
//	                user.setDateOfBirth(rs.getDate("dayofbirth"));
//	                user.setStatus(rs.getInt("Status"));
//	                users.add(user);
//	            }
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	        }
//	        return users;
//	    }
		
		   // Phương thức để lấy tổng số người dùng
	    public int getTotalUserCount() {
	        int count = 0;
	        String sql = "SELECT COUNT(*) FROM Users";
	        try (PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                count = rs.getInt(1);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return count;
	    }


	 // Lấy danh sách người dùng theo trang
	    public List<User> getUsersByPage(int page, int pageSize) {
	        List<User> userList = new ArrayList<>();
	        int offset = (page - 1) * pageSize;
	        Connection conn = null;
	        
	        try {
	            Connect db = new Connect();
	            conn = db.getConnection();
	            
	            String sql = "SELECT u.UserID, u.FullName, u.UserName, u.Email, u.PhoneNumber, u.dayofbirth ,u.status, r.RoleName "
	                       + "FROM users u "
	                       + "LEFT JOIN roles r ON u.UserID = r.userId "
	                       + "LIMIT ? OFFSET ?";
	            PreparedStatement stmt = conn.prepareStatement(sql);
	            stmt.setInt(1, pageSize);
	            stmt.setInt(2, offset);
	            ResultSet rs = stmt.executeQuery();
	            
	            while (rs.next()) {
	                User user = new User();
	                user.setUserid(rs.getInt("UserID"));
	                user.setFullName(rs.getString("FullName"));
	                user.setUserName(rs.getString("UserName"));
	                user.setEmail(rs.getString("Email"));
	                user.setPhoneNumber(rs.getString("PhoneNumber"));
	                user.setDateOfBirth(rs.getDate("dayofbirth"));
	                user.setRoleName(rs.getString("roleName"));
	                user.setStatus(rs.getInt("status"));
	                userList.add(user);
	            }
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
	        return userList;
	    }
	    

	    //lấy tổng
	    public int getSearchUserCount(String searchQuery) {
	    	int count = 0;
    	    String sql = "SELECT COUNT(*) FROM Users WHERE FullName LIKE ? OR UserName LIKE ? OR Email LIKE ? OR PhoneNumber LIKE ?";
    	    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
    	        String query = "%" + searchQuery + "%";
    	        stmt.setString(1, query);
    	        stmt.setString(2, query);
    	        stmt.setString(3, query);
    	        stmt.setString(4, query);
    	        try (ResultSet rs = stmt.executeQuery()) {
    	            if (rs.next()) {
    	                count = rs.getInt(1);
    	            }
    	        }
    	    } catch (SQLException e) {
    	        e.printStackTrace();
    	    }
    	    return count;
	    }

	    // tiìm kiếm ng dùng
	    public List<User> searchUsers(String searchQuery, int page, int pageSize) {
	    	List<User> usersListSearch = new ArrayList<>();
	        int offset = (page - 1) * pageSize;
	        String sql = "SELECT u.UserID, u.FullName, u.UserName, u.Email, u.PhoneNumber, u.dayofbirth, r.RoleName "
                    + "FROM users u "
                    + "LEFT JOIN roles r ON u.UserID = r.userId "
	                + "WHERE u.FullName LIKE ? OR u.UserName LIKE ? OR u.Email LIKE ? OR u.PhoneNumber LIKE ? "
	                + "LIMIT ? OFFSET ?";
	   
	        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
	            String query = "%" + searchQuery + "%";
	            stmt.setString(1, query);
	            stmt.setString(2, query);
	            stmt.setString(3, query);
	            stmt.setString(4, query);
	            stmt.setInt(5, pageSize);
	            stmt.setInt(6, offset);
	            try (ResultSet rs = stmt.executeQuery()) {
	                while (rs.next()) {
	                    User user = new User();
	                    user.setUserid(rs.getInt("UserID"));
	                    user.setFullName(rs.getString("FullName"));
	                    user.setUserName(rs.getString("UserName"));
	                    user.setEmail(rs.getString("Email"));
	                    user.setPhoneNumber(rs.getString("PhoneNumber"));
	                    user.setDateOfBirth(rs.getDate("dayofbirth"));
	                    user.setRoleName(rs.getString("roleName"));
	                    usersListSearch.add(user);
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return usersListSearch;
	    }
	    
	    public boolean updateUserStatus(int userId, int status) {
	        Connection conn = null;
	        boolean isUpdated = false;

	        try {
	            Connect db = new Connect();
	            conn = db.getConnection();
	            
	            String sql = "UPDATE users SET status = ? WHERE UserID = ?";
	            PreparedStatement stmt = conn.prepareStatement(sql);
	            stmt.setInt(1, status);
	            stmt.setInt(2, userId);
	            int rowsAffected = stmt.executeUpdate();
	            isUpdated = rowsAffected > 0;
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
	        return isUpdated;
	    }
	    
	
	
	// client


	
	// customer
	
}
