package io.github.mfthfzn.repository;

import io.github.mfthfzn.entity.User;

import java.util.ArrayList;

public class UserRepository {

  private final ArrayList<User> users = new ArrayList<>();

  public UserRepository() {
    User user = new User();
    user.setUsername("eko");
    user.setPassword("rahasia");
    users.add(user);
  }

  public User getUser(String username) {
    for (User user : users) {
      if (user.getUsername().equals(username)) {
        return user;
      }
    }
    throw new NullPointerException("User tidak ditemukan");
  }
}
