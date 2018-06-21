package service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.stevezong.cloud_note.dao.UserDao;
import com.stevezong.cloud_note.service.BookService;
import com.stevezong.cloud_note.service.NoteService;
import com.stevezong.cloud_note.service.UserService;

public class TestNoteService {
	
	private ApplicationContext ac;
	@Resource(name="noteService")
	NoteService noteService;

	@Before
	public void init() {
		String[] conf = {"conf/spring-mybatis.xml","conf/spring-mvc.xml"};
		ac = new ClassPathXmlApplicationContext(conf);
		noteService = ac.getBean("noteService",NoteService.class);
	}
	
	@Test	//用列 1：查询note
	public void t1() {
		System.out.println(noteService.loadBookNotes("623c1074d04641f78a04afc4ed64e684"));
	}
	
	@Test
	public void t2() {
		System.out.println(noteService.loadNote("0e086e15000e4d3385afef193c18bb89"));
	}

	@Test
	public void t3() {
		Map<String,String> noteInfo = new HashMap<String, String>();
		noteInfo.put("cn_note_id","111111111111111111111111111111111");
		System.out.println(noteService.createNote(noteInfo));
	}
	
	@Test
	public void t4() {
		String noteId="0e086e15000e4d3385afef193c18bb89";
		String title="623c1074d04641f78a04afc4ed64e684";
		String body="623c1074d04641f78a04afc4ed64e684";
		System.out.println(noteService.updateNote(noteId, title, body));
	}
	
}
