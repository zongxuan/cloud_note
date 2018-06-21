package com.stevezong.cloud_note.dao;

import java.util.List;

import com.stevezong.cloud_note.entity.Book;

public interface BookDao {
	List<Book> findByUserId(String userId);
	void addBook(Book book);
}
