package com.team.usermanager.service;

import com.team.usermanager.domain.User;
import com.team.usermanager.pojo.BaseResponse;

import java.util.List;
import java.util.Map;

/**
 * @author Created By zzbin .
 * @since 2019/10/15 17:29 .
 */

public interface UserService {

    BaseResponse Login(Map map);
}
