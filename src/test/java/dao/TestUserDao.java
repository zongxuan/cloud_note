package dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.stevezong.cloud_note.dao.UserDao;
import com.stevezong.cloud_note.entity.User;
import com.stevezong.cloud_note.util.NoteUtil;

public class TestUserDao {
	
	private ApplicationContext ac;
	UserDao dao;

	@Before
	public void init() {
		String[] conf = {"conf/spring-mvc.xml","conf/spring-mybatis.xml"};
		ac = new ClassPathXmlApplicationContext(conf);
		dao = ac.getBean("userDao",UserDao.class);
	}
	
	@Test
	public void t1() {
		System.out.println(dao.findByName("demo"));
	}
	
	@Test
	public void t2() {
		User user = new User();
		user.setCn_user_id("123123");
		user.setCn_user_name("zongxuan");
		user.setCn_user_password(NoteUtil.md5("zongxuan"));
		user.setCn_user_nick("lmdtx");
		user.setCn_user_token("lmdtx");
		System.out.println(user);
		dao.save(user);
	}
}
