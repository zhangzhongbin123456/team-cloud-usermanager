package com.team.usermanager.controller;

import com.team.usermanager.pojo.BaseResponse;
import com.team.usermanager.service.UserService;
import io.swagger.annotations.*;
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
@Api(value = "/user", tags = "用户中心-用户模块")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户登录
     *
     * @param map
     * @return
     */
    @PostMapping("/login")
    @ApiOperation(value = "用户登录", notes = "根据用户名密码查找用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "union_id", value = "用户唯一编码", dataType = "String", required = true),
            @ApiImplicitParam(name = "password", value = "用户密码", dataType = "String", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 1100, message = "用户不存在"),
            @ApiResponse(code = 1101, message = "密码错误")
    })
    public BaseResponse login(@RequestBody Map map) {
        return userService.Login(map);
    }
    @PostMapping("/register")
    public BaseResponse register(@RequestBody Map map) {
        return userService.Register(map);
    }
}
