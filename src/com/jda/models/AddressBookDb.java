package com.jda.models;

import com.jda.interfaces.AddressBookInterface;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public
class AddressBookDb implements AddressBookInterface {
	public static final String ADDRESS_BOOK = "feedback.addressBook";
	public static final String SELECT_FNAME_SNAME = "select fname,sname from " + ADDRESS_BOOK + " where id=?";
	public static final String
			INSERT_INTO_ADDRESSBOOK =
			"insert into " + ADDRESS_BOOK + " values(default, ?, ?, ?, ?, ?, ?, ?)";
	public static final String
			createTableQuery =
			"create table if not exists " +
			ADDRESS_BOOK +
			"(id int auto_increment primary key, fname varchar(32), sname varchar(32), address varchar(100), city " +
			"varchar(32), state varchar(32), zip int, phone bigint)";
	Properties props = new Properties();
	String dbUrl = "jdbc:mysql://localhost/feedback";
	String driver = "com.mysql.cj.jdbc.Driver";

	public
	AddressBookDb() {
		props.put("user", "sqluser");
		props.put("password", "sqluserpw");
		try {
			Class.forName(driver);
		} catch (Exception e) {
			System.out.println("driver not found");
		}

		try (Connection connection = DriverManager.getConnection(dbUrl, props);
		     Statement statement = connection.createStatement()) {
			statement.execute(createTableQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public
	int getNumberOfPersons() {
		try (Connection connection = DriverManager.getConnection(dbUrl, props);
		     Statement statement = connection.createStatement();
		     ResultSet resultSet = statement.executeQuery("select count(*) from " + ADDRESS_BOOK)) {
			int count = -1;
			while (resultSet.next()) {
				count = resultSet.getInt(1);
			}
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public
	void addPerson(String firstName,
	               String lastName,
	               String address,
	               String city,
	               String state,
	               String zip,
	               String phone) {
		try (Connection conn = DriverManager.getConnection(dbUrl, props);
		     PreparedStatement ps = conn.prepareStatement(INSERT_INTO_ADDRESSBOOK)) {
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ps.setString(3, address);
			ps.setString(4, city);
			ps.setString(5, state);
			ps.setString(6, zip);
			ps.setString(7, phone);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public
	String getFullNameOfPerson(int index) {
		try (Connection conn = DriverManager.getConnection(dbUrl, props);
		     PreparedStatement ps = conn.prepareStatement(SELECT_FNAME_SNAME)) {
			ps.setInt(1, index);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String fName = rs.getString(1);
				String sName = rs.getString(2);
				return fName + " " + sName;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public
	ArrayList<String> getOtherPersonInformation(int index) {

		//TODO
		return null;
	}

	@Override
	public
	void updatePerson(int index, String address, String city, String state, String zip, String phone) {
//TODO
	}

	@Override
	public
	void removePerson(int index) {
//TODO
	}

	@Override
	public
	void sortByName() {
//TODO
	}

	@Override
	public
	void sortByZip() {
//TODO
	}

	@Override
	public
	void printAll() {
//TODO
	}

	@Override
	public
	File getFile() {
//TODO
		return null;
	}

	@Override
	public
	void setFile(File file) {
//TODO
	}

	@Override
	public
	String getTitle() {
//TODO
		return null;
	}

	@Override
	public
	boolean getChangedSinceLastSave() {
//TODO
		return false;
	}

	@Override
	public
	void setChangedSinceLastSave(boolean changedSinceLastSave) {
//TODO
	}
}
