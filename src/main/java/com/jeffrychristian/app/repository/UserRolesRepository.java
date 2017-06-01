package com.jeffrychristian.app.repository;

import com.jeffrychristian.app.common.types.RoleType;
import com.jeffrychristian.app.domain.user.UserRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jeffry.christian on 11/9/2016.
 */
@Repository
public interface UserRolesRepository extends CrudRepository<UserRole, Long> {

    @Query("select a.role from UserRole a, User b where b.userName=?1 ")
    List<RoleType> findRoleByUserName(String username);

}