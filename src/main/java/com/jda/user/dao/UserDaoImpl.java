package com.jda.user.dao;

import com.jda.user.model.Login;
import com.jda.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {
	@Autowired
	DataSource datasource;
	@Autowired
	JdbcTemplate jdbcTemplate;

	public void register(User user) {
		String sql = "insert into users values(?,?,?,?,?,?,?,null)";
		jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getFirstname(),
				user.getLastname(), user.getEmail(), user.getAddress(), user.getPhone());
	}

	public User validateUser(Login login) {
		String sql = "select * from users where username='" + login.getUsername() + "' and password='" + login.getPassword() + "'";
		List<User> users = jdbcTemplate.query(sql, new UserMapper());
		return users.size() > 0 ? users.get(0) : null;
	}

	@Override
	public User findUser(String fieldName, String fieldValue) {
		String sql = "select * from users where " + fieldName + "='" + fieldValue + "'";
		List<User> users = jdbcTemplate.query(sql, new UserMapper());
		return users.size() > 0 ? users.get(0) : null;
	}

	@Override
	public void setResetToken(User user, String token) {
		String sql = "update users set resetToken='" + token + "' where email= '" + user.getEmail() + "'";
		jdbcTemplate.update(sql);
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
