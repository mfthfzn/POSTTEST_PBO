package io.github.mfthfzn.service;

import io.github.mfthfzn.entity.User;
import io.github.mfthfzn.repository.UserRepository;

public class LoginService {

  private final UserRepository userRepository;

  public LoginService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public void auth(String username, String password) {
    User user = userRepository.getUser(username);
    if (!user.getPassword().equals(password)) {
      throw new RuntimeException("Username atau password salah");
    }
  }

}
