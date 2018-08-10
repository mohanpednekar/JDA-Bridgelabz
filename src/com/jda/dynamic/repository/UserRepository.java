package com.jda.dynamic.repository;

import com.jda.dynamic.model.User;

public interface UserRepository {
  void save(User user);
  
  boolean exists(User user, boolean withEmail);
}
