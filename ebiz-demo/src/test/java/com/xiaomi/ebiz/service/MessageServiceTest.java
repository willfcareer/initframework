package com.xiaomi.ebiz.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xiaomi.ebiz.dao.entity.Message;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:context-dao.xml", "classpath:context-service.xml" })
public class MessageServiceTest {

	@Autowired
	private MessageService messageService;

	@Test
	public void testFindMessage() {
		Message message = messageService.findMessage(1);
		assert message != null;
	}
}
