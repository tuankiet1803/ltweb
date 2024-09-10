package ltweb.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ltweb.config.DBConnectMySQL;
import ltweb.dao.IUserDAO;
import ltweb.models.UserModel;

public class userDAOimplement extends DBConnectMySQL implements IUserDAO {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public List<UserModel> findall() {
		String sql = "select * from users";
		List<UserModel> list = new ArrayList<UserModel>();
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new UserModel(rs.getInt("id"), rs.getString("fullname"), rs.getString("email"),
						rs.getString("phone"), rs.getString("image"), rs.getString("password")));
			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserModel findByID(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM users where id = ?";
		List<UserModel> list = new ArrayList<UserModel>();
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new UserModel(rs.getInt("id"), rs.getString("fullname"), rs.getString("phone"),
						rs.getString("image"), rs.getString("password"), rs.getString("email")));
			}
			UserModel user = list.getFirst();
			return user;

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public void insert(UserModel user) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO users (id, fullname, email, image, phone, password) VALUES (?,?, ?, ?, ?, ?)";
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);

			ps.setInt(1, user.getId());
			ps.setString(2, user.getFullname());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getImage());
			ps.setString(5, user.getPhone());
			ps.setString(6, user.getPassword());

			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public UserModel findByPhone(String phone) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM users where phone = ?";
		List<UserModel> list = new ArrayList<UserModel>();
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, phone);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new UserModel(rs.getInt("id"), rs.getString("fullname"), rs.getString("phone"),
						rs.getString("image"), rs.getString("password"), rs.getString("email")));
			}
			UserModel user = list.getFirst();
			return user;

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public boolean checkExistEmail(String email) {
		// TODO Auto-generated method stub
		boolean duplicate = false;
		String sql = "select * from users where email = ?";
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return duplicate;
	}

	@Override
	public boolean checkExistPhone(String phone) {
		// TODO Auto-generated method stub
		boolean duplicate = false;
		String sql = "select * from users where phone = ?";
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, phone);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return duplicate;
	}

	public static void main(String[] args) {
		try {
			userDAOimplement a = new userDAOimplement();
//			a.insert(new UserModel(0,"aaa", "bbb", "ccc", "ddd", "eee"));
//			List<UserModel> list = a.findall();
//			for (UserModel userModel : list) {
//				System.out.println(userModel.getId());
//			}
			UserModel b = a.findByPhone("s");
			System.out.println(b);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
