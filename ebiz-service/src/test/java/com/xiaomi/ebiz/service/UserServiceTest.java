package com.xiaomi.ebiz.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xiaomi.ebiz.dao.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:context-dao.xml", "classpath:context-service.xml" })
public class UserServiceTest {

	@Autowired
	private UserService userService;

	@Test
	public void testFindUserByName() {
		User user = userService.findUserByName("edwin");
		assert user != null;
	}
}
