package ltweb.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import ltweb.config.DBConnectMySQL;
import ltweb.dao.ICategoryDAO;
import ltweb.models.CategoryModel;

public class CategoryDAOimplement implements ICategoryDAO {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public List<CategoryModel> findAll() {
		String sql = "select * from categories";
		List<CategoryModel> list = new ArrayList<CategoryModel>();
		try {
			conn = DBConnectMySQL.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				CategoryModel category = new CategoryModel();
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("cate_name"));
				category.setImage(rs.getString("cate_image"));
				category.setStatus(rs.getInt("status"));
				list.add(category);
			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public CategoryModel findByID(int id) {
		String sql = "select * from categories where id = ?";
		try {
			conn = DBConnectMySQL.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				CategoryModel category = new CategoryModel();
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("cate_name"));
				category.setImage(rs.getString("cate_image"));
				category.setStatus(rs.getInt("status"));
				return category;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(CategoryModel category) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO categories (cate_name, cate_image, status) VALUES (?,?,?)";
		try {
			conn = DBConnectMySQL.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, category.getName());
			ps.setString(2, category.getImage());
			ps.setInt(3, category.getStatus());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void update(CategoryModel category) {
		String sql = "UPDATE categories SET cate_name = ?, cate_image = ?, status = ? WHERE id = ?" + "";
		try {
			conn = DBConnectMySQL.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, category.getName());
			ps.setString(2, category.getImage());
			ps.setInt(3, category.getStatus());
			ps.setInt(4, category.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM categories WHERE id = ?";
		try {
			conn = DBConnectMySQL.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public List<CategoryModel> findName(String keyword) {
		String sql = "select * from categories where cate_name like ?";
		List<CategoryModel> list = new ArrayList<CategoryModel>();
		try {
			conn = DBConnectMySQL.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + keyword + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				CategoryModel category = new CategoryModel();
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("cate_name"));
				category.setImage(rs.getString("cate_image"));
				category.setStatus(rs.getInt("status"));
				list.add(category);
			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
