package com.team.usermanager;

import com.google.gson.Gson;
import com.team.usermanager.pojo.BaseResponse;
import com.team.usermanager.pojo.UserParam;
import com.team.usermanager.service.UserService;
import com.team.usermanager.template.AbstractTestApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @author: Created By Zzbin
 * @version: v1.0
 * @date: 2019/12/26
 */
@Slf4j
public class TestUserServiceImpl extends AbstractTestApplication {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    /**
     * 登录
     */
    @Test
    public void Test1() {
        long strat = System.currentTimeMillis();
        UserParam user = new Gson().fromJson("{\"unionId\": \"157735184511918571257921\",\"passWord\": \"123456\"}", UserParam.class);
        BaseResponse baseResponse = userService.login(user);
        long end = System.currentTimeMillis();
        log.info("time:{}", end - strat);
        log.info(baseResponse.toString());
    }

    /**
     * 注册
     */
    @Test
    public void Test2() {
        long strat = System.currentTimeMillis();
        UserParam user = new Gson().fromJson("{\"name\": \"张三\",\"phone\": \"18571257921\"}", UserParam.class);
        BaseResponse baseResponse = userService.register(user);
        long end = System.currentTimeMillis();
        log.info("time:{}", end - strat);
        log.info(baseResponse.toString());
    }

}
