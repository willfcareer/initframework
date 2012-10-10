package com.xiaomi.ebiz.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiaomi.ebiz.dao.entity.Resource;
import com.xiaomi.ebiz.dao.entity.Role;
import com.xiaomi.ebiz.dao.entity.User;
import com.xiaomi.ebiz.dao.mapper.ResourceMapper;
import com.xiaomi.ebiz.dao.mapper.RoleMapper;
import com.xiaomi.ebiz.dao.mapper.UserMapper;

@Service
public class UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private RoleMapper roleMapper;

	@Autowired
	private ResourceMapper resourceMapper;

	@Transactional
	public User findUserByName(String username) {
		List<User> users = userMapper.findByName(username);
		if (logger.isDebugEnabled()) logger.debug(String.format("Found user size %d", users.size()));
		User user = users.get(0);
		int uid = user.getId();
		List<Role> roles = roleMapper.findRolesByUid(uid);
		for (Role role : roles) {
			int rid = role.getId();
			List<Resource> resources = resourceMapper.findResourcesByRid(rid);
			role.addResources(resources);
		}
		user.addRoles(roles);
		return user;
	}
}
