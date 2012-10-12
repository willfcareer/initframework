package com.xiaomi.ebiz.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaomi.ebiz.dao.entity.Message;
import com.xiaomi.ebiz.service.MessageService;

@Controller
@RequestMapping("/message")
public class MessageController {

	private static final Logger logger = LoggerFactory.getLogger(MessageController.class);

	@Autowired
	private MessageService messageService;

	@RequestMapping("show")
	@ResponseBody
	public Object displayMessage(@RequestParam int id) {
		if(logger.isDebugEnabled()) logger.debug(String.format("Get id: %d",id));
		Message message = messageService.findMessage(id);
		return message.getMessage();
	}
}
