package dao;

import java.sql.Timestamp;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.stevezong.cloud_note.dao.BookDao;
import com.stevezong.cloud_note.dao.ShareDao;
import com.stevezong.cloud_note.dao.UserDao;
import com.stevezong.cloud_note.entity.Book;
import com.stevezong.cloud_note.entity.Note;
import com.stevezong.cloud_note.entity.User;
import com.stevezong.cloud_note.util.NoteUtil;

public class TestShareDao {
	
	private ApplicationContext ac;
	ShareDao dao;

	@Before
	public void init() {
		String[] conf = {"conf/spring-mvc.xml","conf/spring-mybatis.xml"};
		ac = new ClassPathXmlApplicationContext(conf);
		dao = ac.getBean("shareDao",ShareDao.class);
	}
	
	@Test
	public void t1() {
		System.out.println(dao.findByTitle("%123%"));
	}
	
	
}
