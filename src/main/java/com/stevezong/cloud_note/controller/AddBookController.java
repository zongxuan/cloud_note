package com.stevezong.cloud_note.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stevezong.cloud_note.entity.Book;
import com.stevezong.cloud_note.service.BookService;
import com.stevezong.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/book")
public class AddBookController {
	@Resource(name="bookService")
	private BookService bookService;
	
	@ResponseBody
	@RequestMapping("/addBook.do")
	public NoteResult<Book> execute(String noteName,String userId){
		NoteResult<Book> result  = new NoteResult<Book>();
		Map<String,String> bookInfo = new HashMap<String, String>();
		bookInfo.put("cn_notebook_name", noteName);
		bookInfo.put("cn_user_id", userId);
		Book book = bookService.createBook(bookInfo);
		bookService.addBook(book);
		result.setStatus(0);
		result.setMsg("添加成功");
		result.setData(book);
		return result;
	}
}
