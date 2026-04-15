package io.github.mfthfzn.repository;

import io.github.mfthfzn.entity.User;

public interface UserRepository {

  User getUser(String username);

}
