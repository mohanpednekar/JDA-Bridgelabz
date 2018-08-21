package com.jda.user.service;

import com.jda.user.dao.UserDao;
import com.jda.user.model.Login;
import com.jda.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

public class UserServiceImpl implements UserService {
	@Autowired
	public UserDao userDao;

	@Transactional
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
		userDao.setProperty(user, "resetToken", token);
	}

	@Override
	@Transactional
	public void savePasswordAndResetToken(User user, String password) {
		userDao.setProperty(user, "password", password);
		userDao.setProperty(user, "resetToken", null);
	}

}
