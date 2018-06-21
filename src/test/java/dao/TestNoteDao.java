package dao;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.stevezong.cloud_note.dao.BookDao;
import com.stevezong.cloud_note.dao.NoteDao;
import com.stevezong.cloud_note.dao.UserDao;
import com.stevezong.cloud_note.entity.Note;
import com.stevezong.cloud_note.entity.User;
import com.stevezong.cloud_note.util.NoteUtil;

public class TestNoteDao {
	
	private ApplicationContext ac;
	NoteDao dao;

	@Before
	public void init() {
		String[] conf = {"conf/spring-mvc.xml","conf/spring-mybatis.xml"};
		ac = new ClassPathXmlApplicationContext(conf);
		dao = ac.getBean("noteDao",NoteDao.class);
	}
	
	@Test
	public void t1() {
		System.out.println(dao.findByBookId("623c1074d04641f78a04afc4ed64e684"));
	}
	
	@Test
	public void t2() {
		System.out.println(dao.findByNoteId("0e086e15000e4d3385afef193c18bb89"));
	}
	@Test
	public void t3() {
		Note note = new Note();
		note.setCn_note_id("0e086e15000e4d3385afef193c18bb89");
		note.setCn_note_title("wo bu shi title");
		note.setCn_note_body("我不是body");
		note.setCn_note_last_modify_time(System.currentTimeMillis());
		System.out.println(dao.updateNote(note));
	}
	
	@Test
	public void t4() {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("title", "java");
		map.put("noteId", "0e086e15000e4d3385afef193c18bb89");
		dao.updateNoteByMap(map);
	}
}
