package connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
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
	
	// client
	
	// customer
	
}
