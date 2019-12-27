package com.team.usermanager.service;

import com.team.usermanager.pojo.BaseResponse;
import com.team.usermanager.pojo.UserParam;

/**
 * @author Created By zzbin .
 * @since 2019/10/15 17:29 .
 */

public interface UserService {

    BaseResponse login(UserParam userParam);

    BaseResponse register(UserParam userParam);
}
