package com.sgb.service.Impl;

import com.sgb.entity.User;
import com.sgb.mapper.UserMapper;
import com.sgb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void register(User user) {
        System.out.println(user);
        userMapper.add(user);

    }

    @Override
    public List find() {
        return  userMapper.getAll();
    }

    @Override
    public User findUser(Integer id) {
        return userMapper.getUserById(id);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public void delete(User user) {
        userMapper.delete(user);
    }

    @Override
    public User findByName(String username) {
        return  userMapper.findByName(username);
    }
}
