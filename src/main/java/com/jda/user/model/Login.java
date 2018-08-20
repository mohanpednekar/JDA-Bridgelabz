package com.jda.user.model;

public class Login {

	private String username;
	private String password;
	private String password1;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Login{" +
				"username='" + username + '\'' +
				", password='" + password + '\'' +
				", password1='" + password1 + '\'' +
				'}';
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}
}
