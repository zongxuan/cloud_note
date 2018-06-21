package com.stevezong.cloud_note.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.stevezong.cloud_note.dao.NoteDao;
import com.stevezong.cloud_note.entity.Note;
import com.stevezong.cloud_note.util.NoteResult;
import com.stevezong.cloud_note.util.NoteUtil;

@Service("noteService")
public class NoteServiceImpl implements NoteService {

	@Resource(name = "noteDao")
	private NoteDao noteDao;

	public NoteResult<List<Map>> loadBookNotes(String bookId) {
		NoteResult<List<Map>> result = new NoteResult<List<Map>>();
		List<Map> notes = noteDao.findByBookId(bookId);
		result.setStatus(0);
		result.setMsg("一共返回：" + notes.size() + "条 数据");
		result.setData(notes);
		return result;
	}

	public NoteResult<Note> loadNote(String noteId) {
		NoteResult<Note> result = new NoteResult<Note>();
		Note note = noteDao.findByNoteId(noteId);
		if (note != null) {
			result.setStatus(0);
			result.setMsg("成功");
			result.setData(note);
		} else {
			result.setStatus(1);
			result.setMsg("没有数据");
		}
		return result;
	}

	public void UpdateNoteService(Note note) {
		noteDao.updateNote(note);
		
	}

	public Note createNote(Map<String, String> noteInfo) {
		Note note = new Note();
		String cn_note_id = noteInfo.get("cn_note_id");
		if(noteDao.findByNoteId(cn_note_id) !=null) {
			note = noteDao.findByNoteId(cn_note_id);
		}
		String cn_notebook_id = noteInfo.get("cn_notebook_id");
		String cn_user_id = noteInfo.get("cn_user_id");
		String cn_note_status_id = noteInfo.get("cn_note_status_id");
		String cn_note_type_id = noteInfo.get("cn_note_type_id");
		String cn_note_title = noteInfo.get("cn_note_title");
		String cn_note_body = noteInfo.get("cn_note_body");
		String cn_note_create_time = noteInfo.get("cn_note_create_time");
		String cn_note_last_modify_time = noteInfo.get("cn_note_last_modify_time");
		if (cn_note_id != null) {
			note.setCn_note_id(cn_note_id);
		}
		if (cn_notebook_id != null) {
			note.setCn_notebook_id(cn_notebook_id);
		}
		if (cn_user_id != null) {
			note.setCn_user_id(cn_user_id);
		}
		if (cn_note_status_id != null) {
			note.setCn_note_status_id(cn_note_status_id);
		}
		if(cn_note_type_id != null) {
			note.setCn_note_type_id(cn_note_type_id);
		}
		if (cn_note_title != null) {
			note.setCn_note_title(cn_note_title);
		}
		if (cn_note_body != null) {
			note.setCn_note_body(cn_note_body);
		}
		if (cn_note_create_time != null) {
			note.setCn_note_create_time(Long.parseLong(cn_note_create_time));
		}
		if (cn_note_last_modify_time != null) {
			note.setCn_note_last_modify_time(Long.parseLong(cn_note_last_modify_time));
		}
		return note;
	}

	public NoteResult<Object> updateNote(String noteId, String title, String body) {
		NoteResult< Object> result = new NoteResult<Object>();
		Note note = new Note();
		note.setCn_note_id(noteId);
		note.setCn_note_title(title);
		note.setCn_note_body(body);
		note.setCn_note_last_modify_time(System.currentTimeMillis());
		Integer rows =  noteDao.updateNote(note);
		if(rows == 1) {
			result.setStatus(0);
			result.setMsg("保存成功");
		}else {
			result.setStatus(1);
			result.setMsg("保存失败");
		}
		return result;
		
	}

	public void addNote(Note note) {
		noteDao.save(note);
	}

	public void deleteNote(String noteId) {
		System.out.println(noteId);
		noteDao.delete(noteId);
	}

}
