package com.jeffrychristian.app.repository;

import com.jeffrychristian.app.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jeffry.christian on 11/9/2016.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String username);

}