package com.stevezong.cloud_note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stevezong.cloud_note.entity.Note;
import com.stevezong.cloud_note.service.NoteService;
import com.stevezong.cloud_note.util.NoteResult;
import com.stevezong.cloud_note.util.NoteUtil;

@Controller
@RequestMapping("/note")
public class AddNoteController {

	@Resource(name="noteService")
	private NoteService noteService;
	
	@RequestMapping("/addNote.do")
	@ResponseBody
	public NoteResult<Note> execute(String noteTitle,String userId,String bookId){
		NoteResult<Note> result = new NoteResult<Note>();
		Note note = new Note();
		Long time = System.currentTimeMillis();
		note.setCn_note_id(NoteUtil.createId());
		note.setCn_notebook_id(bookId);
		note.setCn_user_id(userId);
		note.setCn_note_status_id("1");
		note.setCn_note_type_id("1");
		note.setCn_note_title(noteTitle);
		note.setCn_note_body("请输入：！！！");
		note.setCn_note_create_time(time);
		note.setCn_note_last_modify_time(time);
		noteService.addNote(note);
		result.setStatus(0);
		result.setData(note);
		result.setMsg("添加成功");
		return result;
	} 
}
