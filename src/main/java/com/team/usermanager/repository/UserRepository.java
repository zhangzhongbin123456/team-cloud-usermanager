package com.team.usermanager.repository;

import com.team.usermanager.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Created By zzbin .
 * @since 2019/10/15 17:35 .
 */

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findFirstByUnionIdAndDeletedTimeIsNull(String name);

    UserEntity findFirstByPhoneAndDeletedTimeIsNull(String phone);
}
