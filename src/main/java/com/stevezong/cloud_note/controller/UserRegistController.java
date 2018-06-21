package com.stevezong.cloud_note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stevezong.cloud_note.service.UserService;
import com.stevezong.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/user")
public class UserRegistController {

	@Resource(name = "userService")
	private UserService userService;

	@ResponseBody
	@RequestMapping("/add.do")
	public NoteResult<Object> execute(@RequestParam("name") String name, @RequestParam("password") String password,
			@RequestParam("nick") String nick) {
		NoteResult<Object> result = new NoteResult<Object>();
		result = userService.addUser(name, password, nick);
		return result;
	}
}
