package com.sgb.service;

import com.sgb.entity.User;

import java.util.List;

public interface UserService {
    void register(User user);
    List find();
    User findUser(Integer id);
    void update(User user);
    void delete(User user);
    User findByName(String username);
}
