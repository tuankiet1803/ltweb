package ltweb.dao;

import java.util.List;

import ltweb.models.UserModel;

public interface IUserDAO {

	List<UserModel> findall();

	UserModel findByID(int id);

	UserModel findByPhone(String phone);

	boolean checkExistEmail(String email);

	boolean checkExistPhone(String phone);

	void insert(UserModel user);
}
