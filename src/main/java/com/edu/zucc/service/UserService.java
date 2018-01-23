package com.edu.zucc.service;

import com.edu.zucc.mapper.UserMapper;
import com.edu.zucc.model.EButil;
import com.edu.zucc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User findByUsername(String username) {
        User user = new User();
        user.setUsername(username);
        return userMapper.findByUsername(user);
    }

    public User findById(int id) {
        User user = new User();
        user.setId(id);
        return userMapper.findByKey(user);
    }

    public EButil add(User user) {
        EButil result = new EButil();
        if (findByUsername(user.getUsername()) != null) {
            result.Error("Account has been used");
            return result;
        }
        userMapper.add(user);
        result.Success();
        return result;
    }

    public EButil delete(User user) {
        EButil result = new EButil();
        if (findById(user.getId()) == null) {
            result.Error("Account is not existed");
            return result;
        }
        userMapper.delete(user);
        result.Success();
        return result;
    }

    public EButil update(User user) {
        EButil result = new EButil();
        if (findById(user.getId()) == null) {
            result.Error("Account is not existed");
            return result;
        }
        userMapper.update(user);
        result.Success();
        return result;
    }

    public List<User> findAll() {
        return userMapper.findAll();
    }

    public EButil Login(User user) {
        EButil result = new EButil();
        User user1 = findByUsername(user.getUsername());
        if (user1 == null) {
            result.Error("Account is not existed");
            return result;
        } else if (user1.getPassword().equals(user.getPassword()) == false) {
            result.Error("Password is fault");
            return result;
        }
        result.Success();
        return result;
    }

    /*注册*/


}
