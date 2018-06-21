package dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.stevezong.cloud_note.dao.RelationDao;
import com.stevezong.cloud_note.dao.UserDao;
import com.stevezong.cloud_note.entity.Book;
import com.stevezong.cloud_note.entity.User;
import com.stevezong.cloud_note.util.NoteUtil;

public class TestRelationDao {
	
	private ApplicationContext ac;
	RelationDao dao;

	@Before
	public void init() {
		String[] conf = {"conf/spring-mvc.xml","conf/spring-mybatis.xml"};
		ac = new ClassPathXmlApplicationContext(conf);
		dao = ac.getBean("relationDao",RelationDao.class);
	}
	
	@Test
	public void t1() {
		User user = dao.findUserAndBooks1("48595f52-b22c-4485-9244-f4004255b972");
		System.out.println(user);
		System.out.println(user.getCn_user_name());
		System.out.println(user.getBooks().size());
		for(Book sub:user.getBooks()) {
			System.out.println(sub);
		}
	}
	
	@Test
	public void t2() {
		List<Book> books = dao.findBookAndUser1();
		for(Book sub:books) {
			System.out.println(sub.getUser());
		}
	}
}
