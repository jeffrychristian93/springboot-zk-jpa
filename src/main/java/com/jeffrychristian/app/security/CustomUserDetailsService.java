package com.jeffrychristian.app.security;

import com.jeffrychristian.app.common.types.RoleType;
import com.jeffrychristian.app.domain.user.User;
import com.jeffrychristian.app.repository.UserRepository;
import com.jeffrychristian.app.repository.UserRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jeffry.christian on 11/9/2016.
 */

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
	private final UserRepository userRepository;
	private final UserRolesRepository userRolesRepository;

	@Autowired
    public CustomUserDetailsService(UserRepository userRepository,UserRolesRepository userRolesRepository) {
        this.userRepository = userRepository;
        this.userRolesRepository=userRolesRepository;
    }


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(username);
		if (null == user){
			throw new UsernameNotFoundException("No user present with username: "+username);
		} else {
			List<RoleType> userRoles=userRolesRepository.findRoleByUserName(username);
			return new CustomUserDetails(user,userRoles);
		}
	}

}