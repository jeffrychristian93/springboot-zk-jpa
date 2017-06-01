package com.jeffrychristian.app.security;

import com.jeffrychristian.app.common.types.RoleType;
import com.jeffrychristian.app.domain.user.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.List;

/**
 * Created by jeffry.christian on 11/9/2016.
 */

public class CustomUserDetails extends User implements UserDetails {

	private static final long serialVersionUID = 1L;
	private List<RoleType> userRoles;


	public CustomUserDetails(User user, List<RoleType> userRoles){
		super(user);
		this.userRoles=userRoles;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
//		String roles = "";
//		int i = 0;
//		for (RoleType role : userRoles) {
//			if(i == 0)
//				roles += role.getValue();
//			 else
//				roles += ","+role.getValue();
//			i++;
//		}
		String roles= StringUtils.collectionToCommaDelimitedString(userRoles);
		return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}


	@Override
	public String getUsername() {
		return super.getUserName();
	}


}
