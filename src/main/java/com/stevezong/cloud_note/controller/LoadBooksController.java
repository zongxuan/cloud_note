package com.stevezong.cloud_note.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stevezong.cloud_note.entity.Book;
import com.stevezong.cloud_note.service.BookService;
import com.stevezong.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/book")
public class LoadBooksController {
	
	@Resource(name="bookService")
	private BookService bookService;
	
	@ResponseBody
	@RequestMapping("/loadBooks.do")
	public NoteResult<List<Book>> loadBooks(@RequestParam("userId")String userId){
		NoteResult<List<Book>> result = new NoteResult<List<Book>>();
		result = bookService.loadUserBooks(userId);
		return result;
	}
	
}
