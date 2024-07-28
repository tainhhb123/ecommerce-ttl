package connect;

import java.io.InputStream;
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

import javax.servlet.http.HttpServletRequest;

public class Dao {
	Connect cn = new Connect();
	Connection conn = cn.getConnection();
	
	
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
				t.add(rs.getString(8));
				t.add(rs.getInt(10));
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
		System.out.println(list);

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


	
	public Vector getCategoryOfShop(HttpServletRequest request) {
		Vector list = new Vector();
		String sqly = "SELECT * FROM categoryproduct WHERE userId=?";
		javax.servlet.http.HttpSession session = request.getSession();
		PreparedStatement stmy;
		try {
			stmy = conn.prepareStatement(sqly);
			stmy.setInt(1, (int) session.getAttribute("idUser"));
			ResultSet rs = stmy.executeQuery();
			while (rs.next()) {
				Vector t = new Vector();
				t.add(rs.getInt(1));
				t.add(rs.getString(2));
				t.add(rs.getString(3));
				t.add(rs.getInt(5));
				list.add(t);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	public Vector getCategoryById(int id) {
		Vector cate = new Vector();
		String sqly = "SELECT * FROM categoryproduct WHERE categoryID=?";
		PreparedStatement stmy;
		try {
			stmy = conn.prepareStatement(sqly);
			stmy.setInt(1, id);
			ResultSet rs = stmy.executeQuery();
			if (rs.next()) {
				cate.add(rs.getInt(1));
				cate.add(rs.getString(2));
				cate.add(rs.getString(3));
				cate.add(rs.getInt(5));	
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(cate);
		return cate;
	}
	
	public Vector getCategoryOfShopByName(HttpServletRequest request, String name) {
		Vector list = new Vector();
		String sqly = "SELECT * FROM categoryproduct WHERE userId=? and categoryName like ?";
		javax.servlet.http.HttpSession session = request.getSession();
		PreparedStatement stmy;
		try {
			stmy = conn.prepareStatement(sqly);
			stmy.setInt(1, (int) session.getAttribute("idUser"));
			stmy.setString(2, "%"+name+"%");
			ResultSet rs = stmy.executeQuery();
			while (rs.next()) {
				Vector t = new Vector();
				t.add(rs.getInt(1));
				t.add(rs.getString(2));
				t.add(rs.getString(3));
				t.add(rs.getInt(5));
				list.add(t);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(list);
		return list;
	}
	
	public void editstatusCategory(int sta, int id) {
		try {
			String sql = "UPDATE categoryproduct SET status =? WHERE categoryID =?";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setInt(1, sta);
			stm.setInt(2, id);
			stm.executeUpdate();
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
	}
	
	public void editCategory(String name, String des, int status, int id) {
		try {
			String sql = "UPDATE categoryproduct SET categoryName=?, categoryDecs=?, status =? WHERE categoryID =?";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, name);
			stm.setString(2, des);
			stm.setInt(3, status);
			stm.setInt(4, id);
			stm.executeUpdate();
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
	}
	
	public void insertCategory(String name, String description,int userid, int status) {
		try {
			String sql = "INSERT INTO categoryproduct VALUES(null,?,?,?,?)";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, name);
			stm.setString(2, description);
			stm.setInt(3, userid);
			stm.setInt(4, status);
			stm.execute();
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
	}
	
	
	public Vector getBrandOfShop(HttpServletRequest request) {
		Vector list = new Vector();
		String sqly = "SELECT * FROM brand WHERE userId=?";
		javax.servlet.http.HttpSession session = request.getSession();
		PreparedStatement stmy;
		try {
			stmy = conn.prepareStatement(sqly);
			stmy.setInt(1, (int) session.getAttribute("idUser"));
			ResultSet rs = stmy.executeQuery();
			while (rs.next()) {
				Vector t = new Vector();
				t.add(rs.getInt(1));
				t.add(rs.getString(2));
				t.add(rs.getString(3));
				t.add(rs.getInt(5));
				list.add(t);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	public void editstatusBrand(int sta, int id) {
		try {
			String sql = "UPDATE brand SET status =? WHERE brandID =?";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setInt(1, sta);
			stm.setInt(2, id);
			stm.executeUpdate();
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
	}
	
	public void insertBrand(String name, String country,int userid, int status) {
		try {
			String sql = "INSERT INTO brand VALUES(null,?,?,?,?)";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, name);
			stm.setString(2, country);
			stm.setInt(3, userid);
			stm.setInt(4, status);
			stm.execute();
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
	}
	
	public Vector getBrandOfShopByName(HttpServletRequest request, String name) {
		Vector list = new Vector();
		String sqly = "SELECT * FROM brand WHERE userId=? and brandName like ?";
		javax.servlet.http.HttpSession session = request.getSession();
		PreparedStatement stmy;
		try {
			stmy = conn.prepareStatement(sqly);
			stmy.setInt(1, (int) session.getAttribute("idUser"));
			stmy.setString(2, "%"+name+"%");
			ResultSet rs = stmy.executeQuery();
			while (rs.next()) {
				Vector t = new Vector();
				t.add(rs.getInt(1));
				t.add(rs.getString(2));
				t.add(rs.getString(3));
				t.add(rs.getInt(5));
				list.add(t);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(list);
		return list;
	}
	
	public Vector getSex() {
		Vector list = new Vector();
		String sqly = "SELECT * FROM sex";
		PreparedStatement stmy;
		try {
			stmy = conn.prepareStatement(sqly);
			ResultSet rs = stmy.executeQuery();
			while (rs.next()) {
				Vector t = new Vector();
				t.add(rs.getInt(1));
				t.add(rs.getString(2));
				list.add(t);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	
	public void insertProduct(int idpro, String name, String des,int idbrand, int idcate , int idsex,int aff,int userid, int status) {
		try {
			String sql = "INSERT INTO products VALUES(?,?,?,?,?,?,?,?,?)";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setInt(1, idpro);
			stm.setString(2, name);
			stm.setString(3, des);
			stm.setInt(4, idbrand);
			stm.setInt(5, idcate);
			stm.setInt(6, idsex);
			stm.setInt(7, aff);
			stm.setInt(8, userid);
			stm.setInt(9, status);
			stm.execute();
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
	}
	
	public void insertImgProduct(int id, InputStream inputStream) {
		try {
			String sql = "INSERT INTO products VALUES(null,?,?)";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setInt(1, id);
			stm.setBlob(2, inputStream);
			stm.execute();
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
	}
	
	public Vector getOrderOfShop(HttpServletRequest request) {
		Vector list = new Vector();
		String sqly = "SELECT o.* FROM orders o INNER JOIN orderdetails od ON o.orderCode=od.orderCode INNER JOIN products p on p.productid = od.productId WHERE p.userid=?";
		javax.servlet.http.HttpSession session = request.getSession();
		PreparedStatement stmy;
		try {
			stmy = conn.prepareStatement(sqly);
			stmy.setInt(1, (int) session.getAttribute("idUser"));
			ResultSet rs = stmy.executeQuery();
			while (rs.next()) {
				Vector t = new Vector();
				t.add(rs.getString(1));
				t.add(rs.getString(2));
				t.add(rs.getInt(3));
				t.add(rs.getInt(4));
				t.add(rs.getDouble(5));
				t.add(rs.getInt(6));
				t.add(rs.getString(7));
				t.add(rs.getString(8));
				t.add(rs.getString(9));
				t.add(rs.getInt(10));
				list.add(t);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(list);
		return list;
	}
	
	public void editstatusOrder(int sta, int id) {
		try {
			String sql = "UPDATE orders SET orderStatusId =? WHERE orderCode =?";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setInt(1, sta);
			stm.setInt(2, id);
			stm.executeUpdate();
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
	}
	
	public Vector getOrderByIdOrder(String id) {
		Vector t = new Vector();
		String sqly = "SELECT * FROM orders WHERE orderCode=?";
		PreparedStatement stmy;
		try {
			stmy = conn.prepareStatement(sqly);
			stmy.setString(1, id);
			ResultSet rs = stmy.executeQuery();
			if (rs.next()) {
				t.add(rs.getString(1));
				t.add(rs.getString(2));
				t.add(rs.getInt(3));
				t.add(rs.getInt(4));
				t.add(rs.getDouble(5));
				t.add(rs.getInt(6));
				t.add(rs.getString(7));
				t.add(rs.getString(8));
				t.add(rs.getString(9));
				t.add(rs.getInt(10));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return t;
	}
	
	public Vector getOrderDetailByIdOrder(String id) {
		Vector list = new Vector();
		String sqly = "SELECT * FROM orderdetails WHERE orderCode=?";
		PreparedStatement stmy;
		Dao dao = new Dao();
		
		try {
			stmy = conn.prepareStatement(sqly);
			stmy.setString(1, id);
			ResultSet rs = stmy.executeQuery();
			while (rs.next()) {
				Vector t = new Vector();
				t.add(rs.getInt(1));
				t.add(rs.getString(2));
				t.add(rs.getInt(3));
				t.add(rs.getString(4));
				t.add(rs.getString(5));
				t.add(rs.getString(6));
				t.add(rs.getInt(7));
				Vector pro = new Vector();
				pro = dao.getProductByIdProduct(rs.getInt(3));
				t.add(pro.get(1));
				list.add(t);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	public Vector getProductByIdProduct(int id) {
		Vector t = new Vector();
		String sqly = "SELECT * FROM products WHERE productId=?";
		PreparedStatement stmy;
		try {
			stmy = conn.prepareStatement(sqly);
			stmy.setInt(1, id);
			ResultSet rs = stmy.executeQuery();
			if (rs.next()) {
				t.add(rs.getInt(1));
				t.add(rs.getString(2));
				t.add(rs.getString(3));
				t.add(rs.getInt(4));
				t.add(rs.getInt(5));
				t.add(rs.getInt(6));
				t.add(rs.getInt(7));
				t.add(rs.getInt(8));
				t.add(rs.getInt(9));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return t;
	}
	
	public Vector getVoucherOfShop(HttpServletRequest request) {
		Vector list = new Vector();
		String sqly = "SELECT * FROM `voucher` WHERE userId=?";
		javax.servlet.http.HttpSession session = request.getSession();
		PreparedStatement stmy;
		try {
			stmy = conn.prepareStatement(sqly);
			stmy.setInt(1, (int) session.getAttribute("idUser"));
			ResultSet rs = stmy.executeQuery();
			while (rs.next()) {
				Vector t = new Vector();
				t.add(rs.getInt(1));
				t.add(rs.getInt(2));
				t.add(rs.getDouble(3));
				t.add(rs.getString(4));
				t.add(rs.getString(5));
				t.add(rs.getDouble(6));
				t.add(rs.getInt(7));
				t.add(rs.getInt(8));
				list.add(t);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	// customer
	
}
