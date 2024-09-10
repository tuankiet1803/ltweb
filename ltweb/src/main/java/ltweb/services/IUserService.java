package ltweb.services;

import ltweb.models.UserModel;

public interface IUserService {
	UserModel login(String phone, String password);

	UserModel get(String phone);

	void insert(UserModel user);

	boolean register(String email, String password, String username, String fullname, String phone);

	boolean checkExistEmail(String email);

	boolean checkExistPhone(String phone);

}
