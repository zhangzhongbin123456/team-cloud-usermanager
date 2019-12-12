package com.team.usermanager.controller;

import com.team.usermanager.pojo.BaseResponse;
import com.team.usermanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Created By zzbin .
 * @since 2019/10/15 17:29 .
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * @param map
     * @return
     */
    @PostMapping("/login")
    public BaseResponse login(@RequestBody Map map) {
        return userService.Login(map);
    }
}
