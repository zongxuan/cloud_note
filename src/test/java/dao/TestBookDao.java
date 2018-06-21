package dao;

import java.sql.Timestamp;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.stevezong.cloud_note.dao.BookDao;
import com.stevezong.cloud_note.dao.UserDao;
import com.stevezong.cloud_note.entity.Book;
import com.stevezong.cloud_note.entity.Note;
import com.stevezong.cloud_note.entity.User;
import com.stevezong.cloud_note.util.NoteUtil;

public class TestBookDao {
	
	private ApplicationContext ac;
	BookDao dao;

	@Before
	public void init() {
		String[] conf = {"conf/spring-mvc.xml","conf/spring-mybatis.xml"};
		ac = new ClassPathXmlApplicationContext(conf);
		dao = ac.getBean("bookDao",BookDao.class);
	}
	
	@Test
	public void t1() {
		System.out.println(dao.findByUserId("48595f52-b22c-4485-9244-f4004255b972"));
	}
	
	@Test
	public void t4() {
		Book book = new Book();
		book.setCn_notebook_id(NoteUtil.createId());
		book.setCn_notebook_name("我的笔记");
		book.setCn_user_id(NoteUtil.createId());
		book.setCn_notebook_createtime(new Timestamp(System.currentTimeMillis()));
		dao.addBook(book);
		
	}
}
