package com.team.usermanager.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Created By Zzbin
 * @version: v1.0
 * @date: 2019/12/10
 */
@RestController
@Api(tags = "校验项目")
public class HelloController {

    @RequestMapping("/")
    @ApiOperation(value = "校验项目接口", notes = "返回ok!!!即项目运行")
    public String ok() {
        return "ok !!!";
    }

}
