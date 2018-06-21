package com.stevezong.cloud_note.service;

import java.util.Map;


import com.stevezong.cloud_note.entity.User;
import com.stevezong.cloud_note.util.NoteResult;

public interface UserService {
	NoteResult<User> checkLogin(String name,String password);
	NoteResult<Object>  addUser(String name,String password,String nick);
	User checkUser(String name);
	User createUser(Map<String,String> userInfo);
}
