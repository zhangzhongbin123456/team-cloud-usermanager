package com.team.usermanager.service.impl;

import com.team.usermanager.domain.User;
import com.team.usermanager.mapper.UserMapper;
import com.team.usermanager.pojo.BaseResponse;
import com.team.usermanager.repository.UserRepository;
import com.team.usermanager.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import java.util.Objects;

/**
 * @author: Created By Zzbin
 * @date: 2019/12/10
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    /**
     * @param map
     * @return 登录
     */
    @Override
    public BaseResponse Login(Map map) {
        String name = (String) map.get("name");
        User user = userRepository.findFirstByName(name);
        if (Objects.isNull(user)) {
            return new BaseResponse(1100, "用户不存在");
        }
        String pwd = (String) map.get("pwd");
        if (!user.getPassword().equals(pwd)) {
            return new BaseResponse(1101, "密码错误");
        }
        return BaseResponse.SUCCESS;
    }

    /**
     * @param map
     * @return 注册
     */
    public BaseResponse Register(Map map) {
        String name = (String) map.get("name");
        User user = userRepository.findFirstByName(name);
        if (!Objects.isNull(user)) {
            return new BaseResponse(1100, "用户名已被注册");
        }
        long phone = Long.parseLong((String) map.get("phone"));
        if (!Objects.isNull(userRepository.findFirstByPhone(phone))) {
            return new BaseResponse(1100, "手机号已被注册");
        }
        Date created_time = new Date();
        String union_id = created_time.getTime() + (String) map.get("phone");
        String password = (String) map.get("password");
        String avatar_url = (String) map.get("avatar_url");
        double d = Math.random();
        String uid = String.valueOf((int)(d*1000000000));
        if (userMapper.register(uid, union_id, password, name, phone, avatar_url, created_time) < 0) {   //这个一步用jpa简单
            return BaseResponse.FAIL;
        }
        return BaseResponse.SUCCESS;
    }


}
