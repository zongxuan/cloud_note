package service;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.stevezong.cloud_note.dao.UserDao;
import com.stevezong.cloud_note.entity.User;
import com.stevezong.cloud_note.service.UserService;
import com.stevezong.cloud_note.util.NoteResult;

public class TestUserService {
	
	private ApplicationContext ac;
	@Resource(name="userService")
	UserService userService;

	@Before
	public void init() {
		String[] conf = {"conf/spring-mybatis.xml","conf/spring-mvc.xml","conf/spring-transaction.xml"};
		ac = new ClassPathXmlApplicationContext(conf);
		userService = ac.getBean("userService",UserService.class);
	}
	
	@Test	//用列 1：用户名不存在
	public void t1() {
		System.out.println(userService.checkLogin("demo1", "123"));
	}
	
	@Test	//用列2：密码错误
	public void t2() {
		NoteResult<User> result = userService.checkLogin("demo", "123");
		System.out.println(userService.getClass().getName());
		//System.out.println(userService.checkLogin("demo2", "123"));
	}
	
	@Test	//用列3：login ok
	public void t3() {
		System.out.println(userService.checkLogin("demo", "/OqSD3QStdp74M9CuMk3WQ=="));
	}
	
	@Test //用例4：注册成功
	public void t4() {
		System.out.println(userService.addUser("zxxx", "123456", "lmdtx"));
	}
	
	@Test //用例5：注册失败
	public void t5() {
		System.out.println(userService.addUser("zxxx", "123456", "lmdtx"));
	}
}
