package com.jda.dynamic.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Random;

import com.jda.dynamic.model.User;
import com.mysql.cj.jdbc.Driver;

public class UserRepositoryImpl implements UserRepository {
  private static String     dbHost;
  private static String     dbName;
  private static String     dbUrl;
  private static String     tableName;
  private static Properties props = new Properties();
  private static String     driver;
  
  public UserRepositoryImpl() {}

  static {
    dbName = "db1000202";
    dbHost = "jdbc:mysql://10.0.0.160:3306/";
    dbUrl = dbHost + dbName;
    driver = "com.mysql.cj.jdbc.Driver";
    props.put("user", "u1000202");
    props.put("password", "B1jCkmoOot");
    tableName = dbName + ".users";
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
    String name = user.getName();
    String email = user.getEmail();
    String phone = user.getPhone();
    String password = user.getPassword();
    try (Connection conn = DriverManager.getConnection(dbUrl, props);
        PreparedStatement ps = conn.prepareStatement("insert into " + tableName + " values(?, ?, ?, ?, ?)")) {
      String random = String.valueOf(new Random().nextInt(10000));
      ps.setString(1, random);
      ps.setString(2, name);
      ps.setString(3, email);
      ps.setString(4, phone);
      ps.setString(5, password);
      if (ps.executeUpdate() > 0) {
        System.out.println("Successfully saved");
      } else {
        System.out.println("Failed to save user");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  
  @Override
  public boolean exists(User user, boolean withEmail) {
    String username = withEmail ? user.getEmail() : user.getPhone();
    String password = user.getPassword();
    
    try (Connection conn = DriverManager.getConnection(dbUrl, props);
        PreparedStatement ps = conn
            .prepareStatement("select count(*) from " + tableName + " where ? = ? and password = ?")) {
      ps.setString(1, withEmail ? "email" : "phone");
      ps.setString(2, username);
      ps.setString(3, password);
      try (ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
          if (rs.getInt(1) == 1) { return true; }
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

}
