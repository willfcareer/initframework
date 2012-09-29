package com.xiaomi.ebiz.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiaomi.ebiz.dao.entity.User;
import com.xiaomi.ebiz.dao.mapper.UserMapper;

@Service
public class UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserMapper userMapper;

	@Transactional
	public User findUserByName(String username) {
		List<User> users = userMapper.findByName(username);
		if (logger.isDebugEnabled()) logger.debug(String.format("Found user size %d", users.size()));
		return users.get(0);
	}
}
