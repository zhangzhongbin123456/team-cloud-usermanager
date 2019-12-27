package com.team.usermanager.controller;

import com.team.usermanager.pojo.BaseResponse;
import com.team.usermanager.pojo.UserParam;
import com.team.usermanager.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     * @param userParam
     * @return
     */
    @PostMapping("/login")
    @ApiOperation(value = "用户登录", notes = "根据用户名密码查找用户")
    @ApiResponses({
            @ApiResponse(code = 1099, message = "请输入账号和密码"),
            @ApiResponse(code = 1100, message = "用户不存在"),
            @ApiResponse(code = 1101, message = "密码错误")
    })
    public BaseResponse login(@RequestBody UserParam userParam) {
        return userService.login(userParam);
    }

    /**
     * 用户注册
     *
     * @param userParam
     * @return BaseResponse
     */
    @PostMapping("/register")
    @ApiOperation(value = "用户注册", notes = "注册用户并生成唯一用户id返回给用户")
    @ApiResponses({
            @ApiResponse(code = 1100, message = "手机号已被注册"),
            @ApiResponse(code = 1003, message = "注册失败")
    })
    public BaseResponse register(@RequestBody UserParam userParam) {
        return userService.register(userParam);
    }

}
