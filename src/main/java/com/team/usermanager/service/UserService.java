package com.team.usermanager.service;

import com.team.usermanager.domain.User;

import java.util.List;

/**
 * @author Created By zzbin .
 * @since 2019/10/15 17:29 .
 */

public interface UserService {

    List<User> findAllUser();

    User findUserById(Long Id);

    User findUserByNameAndPwd(String name ,String pwd);
}
