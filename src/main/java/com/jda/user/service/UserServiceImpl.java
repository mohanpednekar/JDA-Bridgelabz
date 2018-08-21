package com.jda.user.service;

import com.jda.user.dao.UserDao;
import com.jda.user.model.Login;
import com.jda.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {
	@Autowired
	public UserDao userDao;

	public void register(User user) {
		userDao.register(user);
	}

	public User validateUser(Login login) {
		return userDao.validateUser(login);
	}

	@Override
	public User findUserByEmail(String email) {
		return userDao.findUser("email", email);
	}

	@Override
	public User findUserByResetToken(String resetToken) {
		User user = userDao.findUser("resetToken", resetToken);
		System.out.println("UserService: " + user);
		return user;
	}

	@Override
	public void createPasswordResetTokenForUser(User user, String token) {
		userDao.setResetToken(user, token);
	}

	@Override
	public void savePasswordAndResetToken(User user, String password) {
		userDao.setPassword(user, password);
	}

}
