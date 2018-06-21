package com.stevezong.cloud_note.controller;

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
public class LoadNoteController {

	@Resource(name="noteService")
	private NoteService noteService;
	
	@RequestMapping("/loadnote.do")
	@ResponseBody
	public  NoteResult<Note>  execute(@RequestParam("noteId")String noteId){
		NoteResult<Note> result = new NoteResult<Note>();
		result = noteService.loadNote(noteId);
		return result;
	}
	
}
