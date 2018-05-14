package com.edu.zucc.controller;

import com.edu.zucc.model.User;
import com.edu.zucc.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Api(value = "11用户接口", description = "用户管理和登陆注册")
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "获得所有用户")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Object getAllUsers() {
        return userService.findAll();
    }

    @ApiOperation(value = "根据账号查询用户")
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public Object getOneUserByAccount(@RequestParam String username) {
        return userService.findByUsername(username);
    }

    @ApiOperation(value = "新增用户")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object createUser(@RequestParam String username, @RequestParam String password, @RequestParam String type) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setUserType(type);
        return userService.add(user);
    }

    @ApiOperation(value = "删除用户")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Object deleteUser(@PathVariable int id) {
        User user = new User();
        user.setId(id);
        return userService.delete(user);
    }

    @ApiOperation(value = "修改用户")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Object modifyUser(@PathVariable int id, @RequestParam String username, @RequestParam String password, @RequestParam String userType) {
        User user = new User();
        user.setId(id);
        user.setPassword(password);
        user.setUsername(username);
        user.setUserType(userType);
        return userService.update(user);
    }

    @ApiOperation(value = "登陆")
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public Object loginUser(@RequestParam String username, @RequestParam String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return userService.Login(user);
    }

    /*注册*/
    @ApiOperation(value = "注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Object createUser(@RequestParam String username, @RequestParam String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setUserType("normal");
        return userService.add(user);
    }
}
