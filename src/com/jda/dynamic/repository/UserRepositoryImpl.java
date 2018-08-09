package com.jda.dynamic.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.jda.dynamic.model.User;
import com.mysql.cj.jdbc.Driver;

public class UserRepositoryImpl implements UserRepository {

  private static String     dbName;
  private static String     dbUrl;
  private static Properties props = new Properties();
  private static String     driver;

  public UserRepositoryImpl() {}
  
  static {
    dbName = "db1000202";
    dbUrl = "jdbc:mysql://10.0.0.160:3306/" + dbName;
    driver = "com.mysql.cj.jdbc.Driver";
    props.put("user", "u1000202");
    props.put("password", "B1jCkmoOot");
    try {
      // Class.forName(driver);
      DriverManager.registerDriver(new Driver());
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

  @Override
  public void save(User user) {
    String tableName = dbName + ".users";
    String name = user.getName();
    String email = user.getEmail();
    String phone = user.getPhone();
    String password = user.getPassword();
    try (Connection conn = DriverManager.getConnection(dbUrl, props);
        PreparedStatement ps = conn.prepareStatement("insert into " + tableName + " values(1,?, ?, ?, ?)")) {
      ps.setString(1, name);
      ps.setString(2, email);
      ps.setString(3, phone);
      ps.setString(4, password);
      if (ps.executeUpdate() > 0) {
        System.out.println("Successfully saved");
      } else {
        System.out.println("Failed to save user");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

}
