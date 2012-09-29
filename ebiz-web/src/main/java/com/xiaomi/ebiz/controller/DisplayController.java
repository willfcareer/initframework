package com.xiaomi.ebiz.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaomi.ebiz.dao.entity.User;
import com.xiaomi.ebiz.service.UserService;

@Controller
@RequestMapping("/display")
public class DisplayController {

	private static final Logger logger = LoggerFactory.getLogger(DisplayController.class);

	@Autowired
	private UserService userService;

	@RequestMapping("user")
	@ResponseBody
	public Object displayUser(@RequestParam String username) {
		User user = userService.findUserByName(username);
		logger.debug(String.format("[Found user] %s", user));
		return user.toString();
	}
}
