package com.xiaomi.ebiz.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.xiaomi.ebiz.dao.entity.Resource;
import com.xiaomi.ebiz.dao.entity.Role;
import com.xiaomi.ebiz.dao.entity.User;
import com.xiaomi.ebiz.service.UserService;

@SuppressWarnings("deprecation")
public class DefaultUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("username is " + username);
		//这里应该可以不用再查了
		User user = userService.findUserByName(username);		
		Collection<GrantedAuthority> grantedAuths = obtionGrantedAuthorities(user);
		boolean enables = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		//封装成spring security的user
		org.springframework.security.core.userdetails.User userdetail = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), enables, accountNonExpired, credentialsNonExpired, accountNonLocked, grantedAuths);
		return userdetail;
	}
	
	//取得用户的权限
	private Set<GrantedAuthority> obtionGrantedAuthorities(User user) {
		Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();
		List<Resource> resources = new ArrayList<Resource>();
		Set<Role> roles = user.getRoles();
		
		for(Role role : roles) {
			Set<Resource> tempRes = role.getResources();
			for(Resource res : tempRes) {
				resources.add(res);
			}
		}
		for(Resource res : resources) {
			authSet.add(new GrantedAuthorityImpl(res.getName()));
		}
		return authSet;
	}

}
