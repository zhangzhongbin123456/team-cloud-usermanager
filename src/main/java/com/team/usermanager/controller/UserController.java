package com.team.usermanager.controller;

import com.team.usermanager.domain.User;
import com.team.usermanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
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

    @GetMapping("/selAll")
    public List<User> getAllUser() {
        return userService.findAllUser();
    }

    @GetMapping("/selUserById/{id}")
    public User getUserById(@PathVariable(value = "id") Long id) {
        return userService.findUserById(id);
    }

    /**
     * @param map
     * @return
     */
    @PostMapping("/login")
    public Map<String,Object> login(@RequestBody Map map){
        User u = userService.findUserByNameAndPwd((String) map.get("name"),(String) map.get("pwd"));
        if(u!=null){
            map.put("msg","登录成功");
            map.put("code",200);
            return map;
        }else{
            map.put("msg","登录失败");
            map.put("code",0);
            return map;
        }
    }
}
