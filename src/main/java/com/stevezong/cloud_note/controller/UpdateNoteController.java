package com.stevezong.cloud_note.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stevezong.cloud_note.entity.Note;
import com.stevezong.cloud_note.service.NoteService;
import com.stevezong.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/note")
public class UpdateNoteController {

	@Resource(name="noteService")
	private NoteService noteService;
	

	@ResponseBody
	@RequestMapping("/updateNote.do")
	public NoteResult<Object> execute(@RequestParam("noteId")String noteId,@RequestParam("title")String title,@RequestParam("body")String body){
		NoteResult<Object> result = new NoteResult<Object>();
		result = noteService.updateNote(noteId, title, body);
		return result;
	}
	
}
