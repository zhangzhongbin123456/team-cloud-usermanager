package com.team.usermanager.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Created By Zzbin
 * @version: v1.0
 * @date: 2019/12/10
 */
@RestController
public class HelloController {

    @RequestMapping("/")
    public String ok() {
        return "ok !!!";
    }

}
