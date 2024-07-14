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
}
