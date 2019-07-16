package com.sgb.mapper;

import com.sgb.entity.User;

import java.util.List;

public interface UserMapper {
    void add(User user);
    List<User> getAll();
    User getUserById(Integer id);
    void update(User user);
    void delete(User user);
    User findByName(String username);
}
