package com.team.usermanager.service.impl;

import com.team.usermanager.domain.UserEntity;
import com.team.usermanager.mapper.UserMapper;
import com.team.usermanager.pojo.BaseResponse;
import com.team.usermanager.pojo.ExtraResponse;
import com.team.usermanager.pojo.UserParam;
import com.team.usermanager.repository.UserRepository;
import com.team.usermanager.service.UserService;
import com.team.usermanager.util.UUIDGenerator;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Objects;

/**
 * @author: Created By Zzbin
 * @date: 2019/12/10
 */
@Slf4j
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserRepository userRepository;

    /**
     * 用户登录
     *
     * @param userParam
     * @return BaseResponse
     */
    @Override
    public BaseResponse login(UserParam userParam) {
        log.info("strat_time:{}", System.currentTimeMillis());
        if (StringUtils.isEmpty(userParam.unionId) || StringUtils.isEmpty(userParam.passWord))
            return BaseResponse.invalidParam("请输入账号和密码");
        UserEntity user = userRepository.findFirstByUnionIdAndDeletedTimeIsNull(userParam.unionId);
        if (Objects.isNull(user)) return new BaseResponse(1100, "用户不存在");
        if (!user.getPassword().equals(userParam.passWord)) return new BaseResponse(1101, "密码错误");
        log.info("end_time:{}", System.currentTimeMillis());
        log.info("Response:{}", BaseResponse.SUCCESS.toString());
        return BaseResponse.SUCCESS;
    }

    /**
     * 用户注册
     *
     * @param userParam
     * @return
     */
    public BaseResponse register(UserParam userParam) {
        if (!Objects.isNull(userRepository.findFirstByPhoneAndDeletedTimeIsNull(userParam.phone))) {
            return new BaseResponse(1100, "手机号已被注册");
        }
        UserEntity user = userRepository.save(new UserEntity(UUIDGenerator.getUUID(),
                new Date().getTime() + "" + userParam.phone,
                "1000", "123456", userParam.name, userParam.phone));
        if (Objects.isNull(user)) {
            return BaseResponse.FAIL;
        }
        return new ExtraResponse(user);
    }


}
