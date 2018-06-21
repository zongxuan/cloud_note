package com.stevezong.cloud_note.dao;

import com.stevezong.cloud_note.entity.User;

public interface UserDao {
	User findByName(String name);
	void save(User user);
}
