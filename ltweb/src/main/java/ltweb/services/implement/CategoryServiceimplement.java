package ltweb.services.implement;

import java.util.List;

import ltweb.dao.ICategoryDAO;
import ltweb.dao.implement.CategoryDAOimplement;
import ltweb.models.CategoryModel;
import ltweb.services.ICategoryService;

public class CategoryServiceimplement implements ICategoryService{
	public ICategoryDAO cateDAO = new CategoryDAOimplement();
	@Override
	public List<CategoryModel> findAll() {
		// TODO Auto-generated method stub
		return cateDAO.findAll();
	}

	@Override
	public CategoryModel findByID(int id) {
		// TODO Auto-generated method stub
		return cateDAO.findByID(id);
	}

	@Override
	public void insert(CategoryModel category) {
		// TODO Auto-generated method stub
		cateDAO.insert(category);
	}

	@Override
	public void update(CategoryModel category) {
		// TODO Auto-generated method stub
		cateDAO.update(category);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		cateDAO.delete(id);
	}

	@Override
	public List<CategoryModel> findName(String keyword) {
		// TODO Auto-generated method stub
		return cateDAO.findName(keyword);
	}

}
