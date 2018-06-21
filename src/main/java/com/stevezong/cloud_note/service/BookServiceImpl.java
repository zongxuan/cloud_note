package com.stevezong.cloud_note.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.stevezong.cloud_note.dao.BookDao;
import com.stevezong.cloud_note.entity.Book;
import com.stevezong.cloud_note.util.NoteResult;
import com.stevezong.cloud_note.util.NoteUtil;


@Service("bookService")
public class BookServiceImpl implements BookService{

	@Resource(name="bookDao")
	private BookDao bookDao;
	
	public NoteResult<List<Book>> loadUserBooks(String userId) {
		NoteResult<List<Book>> result = new NoteResult<List<Book>>();
		List<Book> books =new ArrayList<Book>();
		books = bookDao.findByUserId(userId);
		result.setStatus(0);
		result.setMsg("一共有："+books.size()+"条");
		result.setData(books);
		return result;
	}

	public void addBook(Book book) {
		bookDao.addBook(book);
	}

	public Book createBook(Map<String, String> bookInfo) {
		Book book = new Book();
		String cn_notebook_id = bookInfo.get("cn_notebook_id");
		String cn_user_id = bookInfo.get("cn_user_id");
		String cn_notebook_type_id = bookInfo.get("cn_notebook_type_id");
		String cn_notebook_name = bookInfo.get("cn_notebook_name");
		String cn_notebook_desc = bookInfo.get("cn_notebook_desc");
		String cn_notebook_createtime = bookInfo.get("cn_notebook_createtime");
		if(cn_notebook_id == null) {
			cn_notebook_id = NoteUtil.createId();
		}
		if(cn_user_id == null) {
			cn_user_id = NoteUtil.createId();
		}
		if(cn_notebook_type_id == null) {
			cn_notebook_type_id="1";
		}
		if(cn_notebook_name == null) {
			cn_notebook_name = NoteUtil.createId();
		}
		if(cn_notebook_desc == null) {
			cn_notebook_desc="这个人很懒，没有写介绍";
		}
		if(cn_notebook_createtime == null) {
			Long time = System.currentTimeMillis();
			cn_notebook_createtime = time.toString();
		}
		book.setCn_notebook_id(cn_notebook_id);
		book.setCn_user_id(cn_user_id);
		book.setCn_notebook_type_id(cn_notebook_type_id);
		book.setCn_notebook_name(cn_notebook_name);
		book.setCn_notebook_desc(cn_notebook_desc);
		book.setCn_notebook_createtime(new Timestamp(Long.parseLong(cn_notebook_createtime)));
		return book;
	}

}
