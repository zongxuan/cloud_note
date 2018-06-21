package service;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.stevezong.cloud_note.dao.UserDao;
import com.stevezong.cloud_note.service.BookService;
import com.stevezong.cloud_note.service.ShareService;
import com.stevezong.cloud_note.service.UserService;

public class TestShareService {
	
	private ApplicationContext ac;
	@Resource(name="shareService")
	ShareService shareService;

	@Before
	public void init() {
		String[] conf = {"conf/spring-mybatis.xml","conf/spring-mvc.xml"};
		ac = new ClassPathXmlApplicationContext(conf);
		shareService = ac.getBean("shareService",ShareService.class);
	}
	
	@Test	
	public void t1() {
		System.out.println(shareService.searchShare("123"));
	}
	

}
