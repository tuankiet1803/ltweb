package ltweb.services.implement;

import ltweb.dao.implement.userDAOimplement;
import ltweb.models.UserModel;
import ltweb.services.IUserService;

public class userServiceimplement implements IUserService {

	userDAOimplement userDao = new userDAOimplement();

	@Override
	public UserModel login(String phone, String password) {
		// TODO Auto-generated method stub
		try {
			UserModel user = userDao.findByPhone(phone);
			System.out.println(user.toString());
			if (user != null && password.equals(user.getPassword())) {
				return user;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public UserModel get(String phone) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void insert(UserModel user) {
		// TODO Auto-generated method stub
		userDao.insert(user);

	}

	@Override
	public boolean register(String email, String password, String image, String fullname, String phone) {
		// TODO Auto-generated method stub
		if (userDao.checkExistPhone(phone)) {
			return false;
		}
		userDao.insert(new UserModel(0, fullname, phone, image, password, email));
		return true;
	}

	@Override
	public boolean checkExistEmail(String email) {
		// TODO Auto-generated method stub
		return userDao.checkExistEmail(email);
	}

	@Override
	public boolean checkExistPhone(String phone) {
		// TODO Auto-generated method stub
		return userDao.checkExistPhone(phone);
	}
}
