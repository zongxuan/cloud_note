package com.stevezong.cloud_note.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stevezong.cloud_note.dao.UserDao;
import com.stevezong.cloud_note.entity.User;
import com.stevezong.cloud_note.util.NoteResult;
import com.stevezong.cloud_note.util.NoteUtil;

@Transactional

@Service("userService")
public class UserServiceImpl implements UserService{

	@Resource(name="userDao")
	private UserDao userDao;
	
	public NoteResult<User> checkLogin(String name, String password) {
		NoteResult<User> result = new NoteResult<User>();
		User user  = userDao.findByName(name);
		if(user == null) {//检测用户名
			result.setStatus(1);
			result.setMsg("用户名不存在");
			return result;
		}
		//密码加密
		String md5Password = NoteUtil.md5(password);
		if(!md5Password.equals(user.getCn_user_password())) {//检测密码
			result.setStatus(2);
			result.setMsg("密码错误");
			return result;
		}
		result.setStatus(0);
		result.setMsg("login ok");
		result.setData(user);
		return result;
	}

	public User checkUser(String name) {
		User user = null;
		user = userDao.findByName(name);
		return user;
	}
	
	public NoteResult<Object> addUser(String name, String password, String nick) {
		NoteResult<Object> result = new NoteResult<Object>();
		if(checkUser(name) != null) {
			result.setStatus(1);
			result.setMsg("用户名已存在");
			return result;
		}
		Map<String,String> userInfo = new HashMap<String, String>();
		userInfo.put("name", name);
		userInfo.put("password",NoteUtil.md5(password));
		userInfo.put("nick",nick);
		User user = createUser(userInfo);
		userDao.save(user);
		result.setStatus(0);
		result.setMsg("注册成功");
		return result;
	}

	
	public User createUser(Map<String,String> userInfo) {
		User user = new User();
		String name = userInfo.get("name");
		String password = userInfo.get("password");
		String nick = userInfo.get("nick");
		String token = userInfo.get("token");
		String id = userInfo.get("id");
		if(id == null) {
			id = NoteUtil.createId();
		}
		user.setCn_user_id(id);
		if(name == null) {
			name="adminsitrator";
		}
		user.setCn_user_name(name);
		if(password == null) {
			password = NoteUtil.md5("12345678");
		}
		user.setCn_user_password(password);
		if(token == null) {
			token ="";
		}
		user.setCn_user_token(token);
		if(nick == null) {
			nick = "匿名";
		}
		user.setCn_user_nick(nick);
		return user;
	}


}
