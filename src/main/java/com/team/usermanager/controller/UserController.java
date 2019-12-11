package com.team.usermanager.controller;

import com.team.usermanager.domain.User;
import com.team.usermanager.service.UserService;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Created By zzbin .
 * @since 2019/10/15 17:29 .
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/selAll")
    public List<User> getAllUser() {
        return userService.findAllUser();
    }

    @GetMapping("/selUserById/{id}")
    public User getUserById(@PathVariable(value = "id") Long id) {
        return userService.findUserById(id);
    }

}
