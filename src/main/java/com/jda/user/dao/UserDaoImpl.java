package com.jda.user.dao;

import com.jda.user.model.Login;
import com.jda.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	public void register(User user) {
		String sql = "insert into users values(?,?,?,?,?,?,?,null)";
		String encrypted = passwordEncoder.encode(user.getPassword());
		jdbcTemplate.update(sql, user.getUsername(), encrypted, user.getFirstname(), user.getLastname(), user.getEmail(), user.getAddress(), user.getPhone());
	}

	public User validateUser(Login login) {
		String sql = "select * from users where username='" + login.getUsername() + "'";
		List<User> users = jdbcTemplate.query(sql, new UserMapper());
		String dbPassword = users.get(0).getPassword();
		System.out.println("***************passwords*************");
		System.out.println(dbPassword);
		System.out.println(login.getPassword());
		boolean match = passwordEncoder.matches(login.getPassword(), dbPassword);
		System.out.println(match);
		return match ? users.get(0) : null;
	}

	@Override
	public User findUser(String fieldName, String fieldValue) {

		String sql = "select * from users where " + fieldName + "='" + fieldValue + "'";
		System.out.println(sql);
		List<User> users = jdbcTemplate.query(sql, new UserMapper());
		return users.size() > 0 ? users.get(0) : null;
	}

	@Override
	public void setProperty(User user, String propName, String propValue) {
		if (propName.equals("password")) propValue = passwordEncoder.encode(propValue);
		System.out.println(propValue);
		String sql = "update users set " + propName + "=? where email=?";
		jdbcTemplate.update(sql, propValue, user.getEmail());
	}
}

class UserMapper implements RowMapper<User> {
	public User mapRow(ResultSet rs, int arg1) throws SQLException {
		User user = new User();
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setFirstname(rs.getString("firstname"));
		user.setLastname(rs.getString("lastname"));
		user.setEmail(rs.getString("email"));
		user.setAddress(rs.getString("address"));
		user.setPhone(rs.getString("phone"));
		user.setResetToken(rs.getString("resetToken"));
		return user;
	}
}
