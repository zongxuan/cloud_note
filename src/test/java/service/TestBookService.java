package service;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.stevezong.cloud_note.dao.UserDao;
import com.stevezong.cloud_note.service.BookService;
import com.stevezong.cloud_note.service.UserService;

public class TestBookService {
	
	private ApplicationContext ac;
	@Resource(name="bookService")
	BookService bookService;

	@Before
	public void init() {
		String[] conf = {"conf/spring-mybatis.xml","conf/spring-mvc.xml"};
		ac = new ClassPathXmlApplicationContext(conf);
		bookService = ac.getBean("bookService",BookService.class);
	}
	
	@Test	//用列 1：查询book
	public void t1() {
		System.out.println(bookService.loadUserBooks("48595f52-b22c-4485-9244-f4004255b972"));
	}
	

}
