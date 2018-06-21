package com.stevezong.cloud_note.service;

import java.util.List;
import java.util.Map;

import com.stevezong.cloud_note.entity.Book;
import com.stevezong.cloud_note.util.NoteResult;

public interface BookService {
	NoteResult<List<Book>>loadUserBooks(String userId);
	void addBook(Book book);
	Book createBook(Map<String,String> bookInfo);
}
