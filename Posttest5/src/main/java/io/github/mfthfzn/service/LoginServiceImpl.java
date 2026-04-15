package io.github.mfthfzn.service;

import io.github.mfthfzn.entity.User;
import io.github.mfthfzn.repository.UserRepositoryImpl;

public class LoginServiceImpl implements LoginService{

  private final UserRepositoryImpl userRepositoryImpl;

  public LoginServiceImpl(UserRepositoryImpl userRepositoryImpl) {
    this.userRepositoryImpl = userRepositoryImpl;
  }

  @Override
  public void auth(String username, String password) {
    User user = userRepositoryImpl.getUser(username);
    if (!user.getPassword().equals(password)) {
      throw new RuntimeException("Username atau password salah");
    }
  }

}
