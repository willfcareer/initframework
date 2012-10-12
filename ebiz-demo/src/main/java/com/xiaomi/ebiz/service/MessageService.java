package com.xiaomi.ebiz.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiaomi.ebiz.dao.entity.Message;
import com.xiaomi.ebiz.dao.mapper.MessageMapper;

@Service
public class MessageService {

	private static final Logger logger = LoggerFactory.getLogger(MessageService.class);

	@Autowired
	private MessageMapper messageMapper;

	@Transactional
	public Message findMessage(int id) {
		boolean debugEnabled = logger.isDebugEnabled();
		List<Message> messages = messageMapper.findMessage(id);
		Message message = messages.get(0);
		if (debugEnabled) logger.debug(String.format("Found message: %s", message));
		return message;
	}
}
