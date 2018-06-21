package com.stevezong.cloud_note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stevezong.cloud_note.service.NoteService;
import com.stevezong.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/note")
public class DeleteNoteController {
	
	@Resource(name="noteService")
	private NoteService noteService;
	
	
	@RequestMapping("/delete.do")
	@ResponseBody
	public NoteResult<Object> execute(@RequestParam("noteId")String noteId){
		NoteResult<Object> result = new NoteResult<Object>();
		System.out.println(noteId);
		noteService.deleteNote(noteId);
		result.setStatus(0);
		result.setMsg("删除笔记成功");
		return result;
				
	}
	
}
