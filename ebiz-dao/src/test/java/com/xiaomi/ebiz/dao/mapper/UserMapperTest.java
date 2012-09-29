package com.xiaomi.ebiz.dao.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xiaomi.ebiz.dao.entity.User;
import com.xiaomi.ebiz.dao.mapper.UserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:context-dao.xml")
public class UserMapperTest {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void testFindByName() {
		List<User> users = userMapper.findByName("edwin");
		assert users != null;
	}
}
