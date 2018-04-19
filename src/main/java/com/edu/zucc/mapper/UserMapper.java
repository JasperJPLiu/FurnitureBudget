package com.edu.zucc.mapper;

import com.edu.zucc.model.User;

import java.util.List;

public interface UserMapper {
    int add(User user);

    int delete(User user);

    int update(User user);

    List<User> findAll();

    User findByKey(User user);

    User findByUsername(User user);
}
