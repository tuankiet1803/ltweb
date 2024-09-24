package ltweb.services.implement;

import java.util.Random;

import ltweb.dao.implement.userDAOimplement;
import ltweb.models.UserModel;
import ltweb.services.IUserService;

public class userServiceimplement implements IUserService {

	userDAOimplement userDao = new userDAOimplement();

	@Override
	public UserModel login(String username, String password) {
		// TODO Auto-generated method stub
		try {
			UserModel user = userDao.findByUsername(username);
			System.out.println(user.toString());
			if (user != null && password.equals(user.getPassWord())) {
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
	public boolean checkExistEmail(String email) {
		// TODO Auto-generated method stub
		return userDao.checkExistEmail(email);
	}

	@Override
	public boolean checkExistPhone(String phone) {
		// TODO Auto-generated method stub
		return userDao.checkExistPhone(phone);
	}

	@Override
	public boolean register(String email, String password, String username, String fullname, String phone,
			String avatar, int roleid) {
		if (userDao.checkExistPhone(phone)) {
			return false;
		}
		UserModel user = new UserModel();
		user.setEmail("email");
		user.setUserName("username");
		user.setFullName("fullname");
		user.setPassWord("password");
		user.setAvatar("avatar");
		user.setRoleid(roleid);
		user.setPhone("phone");
		userDao.insert(user);
		return true;
	}
	public String RandomPassword() {
	    int leftLimit = 48; // numeral '0'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 10;
	    Random random = new Random();

	    String generatedString = random.ints(leftLimit, rightLimit + 1)
	      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();
	    return generatedString;
	}

	@Override
	public void updatePassword(String password, String email) {
		// TODO Auto-generated method stub
		userDao.updatePassword(email, password);
	}
}
