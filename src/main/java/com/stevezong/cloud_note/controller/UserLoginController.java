package com.stevezong.cloud_note.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stevezong.cloud_note.entity.User;
import com.stevezong.cloud_note.service.UserService;
import com.stevezong.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/user")
public class UserLoginController {

	@Resource(name = "userService")
	private UserService userService;

	@ResponseBody
	@RequestMapping("/login.do")
	public NoteResult<User> login(HttpServletRequest request,HttpServletResponse response) {
		NoteResult<User> result = new NoteResult<User>();
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String auto = request.getParameter("autoLogin");
		System.out.println(name+":"+password+":"+auto);
		result = userService.checkLogin(name, password);
		return result;
	}

}
