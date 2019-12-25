package com.team.usermanager.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * @author Created By zzbin .
 * @since 2019/10/15 17:34 .
 */

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO T_USER_ACCOUNT(UID,UNION_ID,PASSWORD,NAME,PHONE,AVATAR_URL,CREATED_TIME) values(#{uid}, #{union_id}, #{password}, #{name}, #{phone}, #{avatar_url}, #{created_time, jdbcType=TIMESTAMP})")
    int register(@Param("uid")String uid, @Param("union_id")String union_id, @Param("password")String password, @Param("name")String name, @Param("phone")Long phone, @Param("avatar_url")String avatar_url, @Param("created_time") Date created_time);

}
