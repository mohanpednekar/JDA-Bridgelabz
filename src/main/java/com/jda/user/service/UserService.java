package com.jda.user.service;

import com.jda.user.model.Login;
import com.jda.user.model.User;

public interface UserService {

	void register(User user);

	User validateUser(Login login);

	User findUserByEmail(String email);

	User findUserByResetToken(String resetToken);

	void createPasswordResetTokenForUser(User user, String token);

}
