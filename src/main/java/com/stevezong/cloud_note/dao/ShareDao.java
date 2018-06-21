package com.stevezong.cloud_note.dao;

import java.util.List;
import java.util.Map;

import com.stevezong.cloud_note.entity.Share;

public interface ShareDao {
	void add(Share share);
	List<Share> findByTitle(Map params);
}
