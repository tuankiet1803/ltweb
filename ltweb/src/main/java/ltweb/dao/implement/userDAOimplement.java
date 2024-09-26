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
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setUserName(rs.getString("username"));
				user.setFullName(rs.getString("fullname"));
				user.setPassWord(rs.getString("password"));
				user.setAvatar(rs.getString("image"));
				user.setRoleid(Integer.parseInt(rs.getString("roleid")));
				user.setPhone(rs.getString("phone"));
				user.setCreatedDate(rs.getDate("createDate"));
				list.add(user);
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
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			UserModel user = new UserModel();
			while (rs.next()) {
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setUserName(rs.getString("username"));
				user.setFullName(rs.getString("fullname"));
				user.setPassWord(rs.getString("password"));
				user.setAvatar(rs.getString("image"));
				user.setRoleid(Integer.parseInt(rs.getString("roleid")));
				user.setPhone(rs.getString("phone"));
				user.setCreatedDate(rs.getDate("createDate"));
			}
			return user;

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public void insert(UserModel user) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO `ltweb`.`users` (`fullname`, `email`, `image`, `phone`, `password`, `username`, `roleid`, `createDate`) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);

			ps.setString(1, user.getFullName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getAvatar());
			ps.setString(4, user.getPhone());
			ps.setString(5, user.getPassWord());
			ps.setString(6, user.getUserName());
			ps.setInt(7, user.getRoleid());
			ps.setDate(8, user.getCreatedDate());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void updatePassword(String email, String password) {
		String sql = "UPDATE users SET password = ? WHERE email = ?;";
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);

			ps.setString(1, password);
			ps.setString(2, email);
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
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, phone);
			rs = ps.executeQuery();
			UserModel user = new UserModel();
			while (rs.next()) {
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setUserName(rs.getString("username"));
				user.setFullName(rs.getString("fullname"));
				user.setPassWord(rs.getString("password"));
				user.setAvatar(rs.getString("image"));
				user.setRoleid(Integer.parseInt(rs.getString("roleid")));
				user.setPhone(rs.getString("phone"));
				user.setCreatedDate(rs.getDate("createDate"));
			}
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

	@Override
	public UserModel findByUsername(String username) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM ltweb.users where username = ?";
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();

			UserModel user = new UserModel();
			while (rs.next()) {
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setUserName(rs.getString("username"));
				user.setFullName(rs.getString("fullname"));
				user.setPassWord(rs.getString("password"));
				user.setAvatar(rs.getString("image"));
				user.setRoleid(Integer.parseInt(rs.getString("roleid")));
				user.setPhone(rs.getString("phone"));
				user.setCreatedDate(rs.getDate("createDate"));
			}
			return user;

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public void updateProfile(String fullname, String phone, String email, String image, int id) {
		// TODO Auto-generated method stub
		String sql = "UPDATE users SET fullname = ?, phone = ?, email = ?, image = ? WHERE id = ?;";
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);

			ps.setString(1, fullname);
			ps.setString(2, phone);
			ps.setString(3, email);
			ps.setString(4, image);
			ps.setInt(5, id);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
