package com.team.usermanager.service.impl;

import com.team.usermanager.domain.User;
import com.team.usermanager.mapper.UserMapper;
import com.team.usermanager.repository.UserRepository;
import com.team.usermanager.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.procedure.spi.ParameterRegistrationImplementor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<User> findAllUser() {
        List<User> users = userMapper.findAllUser();
        return userMapper.findAllUser();
    }

    @Override
    public User findUserById(Long Id) {
        return userRepository.findFirstById(Id);
    }
}
