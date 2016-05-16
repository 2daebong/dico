package com.helicopter.dico.api.user.controller;

import com.helicopter.dico.common.user.entity.User;
import com.helicopter.dico.common.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by LeeDaebeom-Mac on 2016. 3. 13..
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/addUser", method = RequestMethod.POST)
    public User createUser(@RequestBody User user){

        return userService.addUser(user);
    }

    @RequestMapping(value="/user", method = RequestMethod.GET)
    public User getUser(@RequestParam(value="userId") String userId){

        return userService.getUser(userId);
    }

    @RequestMapping(value="/userList", method = RequestMethod.GET)
    public List<User> getUserAll(){

        return userService.getUserList();
    }

}
