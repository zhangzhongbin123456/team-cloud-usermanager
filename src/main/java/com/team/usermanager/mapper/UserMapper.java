package com.team.usermanager.mapper;

import com.team.usermanager.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Created By zzbin .
 * @since 2019/10/15 17:34 .
 */

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM `t_user_account`")
    List<User> findAllUser();
}
