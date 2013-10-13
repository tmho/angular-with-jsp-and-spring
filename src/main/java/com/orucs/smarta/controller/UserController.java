package com.orucs.smarta.controller;

import com.orucs.smarta.db.UserDao;
import com.orucs.smarta.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/user/{username}", method = RequestMethod.GET)
    public
    @ResponseBody
    List<User> findUsersByName(@PathVariable String username) {
        return userDao.findUserByUsername(username);
    }

    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public
    @ResponseBody
    String createUser(@RequestBody User user) {
        userDao.insert(user);
        return user.getUsername();
    }
}
