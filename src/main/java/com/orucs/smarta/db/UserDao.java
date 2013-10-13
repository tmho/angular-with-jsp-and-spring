package com.orucs.smarta.db;

import com.orucs.smarta.model.User;

import java.util.List;

public interface UserDao {
    public void insert(User user);
    public List<User> findUserByUsername(String username);
}
