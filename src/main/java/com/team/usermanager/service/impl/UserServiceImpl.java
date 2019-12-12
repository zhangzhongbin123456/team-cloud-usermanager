package com.team.usermanager.service.impl;

import com.team.usermanager.domain.User;
import com.team.usermanager.mapper.UserMapper;
import com.team.usermanager.pojo.BaseResponse;
import com.team.usermanager.repository.UserRepository;
import com.team.usermanager.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public BaseResponse Login(Map map) {
        String name = (String) map.get("name");
        User user = userRepository.findFirstByName(name);
        if (Objects.isNull(user)) {
            return new BaseResponse(1100, "用户不存在");
        }
        String pwd = (String) map.get("pwd");
        if (!user.getPwd().equals(pwd)) {
            return new BaseResponse(1101, "密码错误");
        }
        return BaseResponse.SUCCESS;
    }
}
