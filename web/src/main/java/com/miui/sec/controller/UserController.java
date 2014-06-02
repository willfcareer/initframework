package com.miui.sec.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.miui.sec.dao.entity.User;
import com.miui.sec.service.UserService;

@Controller
@RequestMapping("/user")
//@RestController
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@RequestMapping("show")
	@ResponseBody
	public Object getUser(@RequestParam String username) {
		logger.info("get username:{}",username);
		User user = new User();
		user.setId(1);
		user.setUsername("edwin");
		user.setPassword("");
		return user;
	}
}
