package com.xiaomi.ebiz.dao.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xiaomi.ebiz.dao.entity.Message;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:context-dao.xml")
public class MessageMapperTest {

	@Autowired
	private MessageMapper messageMapper;

	@Test
	public void testFindMessage() {
		List<Message> messages = messageMapper.findMessage(1);
		assert messages != null;
	}
}
