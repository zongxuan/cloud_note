package com.stevezong.cloud_note.controller;

import java.util.List;
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
public class LoadBookNotesController {

	@Resource(name = "noteService")
	private NoteService noteService;

	@ResponseBody
	@RequestMapping("/loadnotes.do")
	public NoteResult<List<Map>> loadnotes(@RequestParam("bookId") String bookId) {
		NoteResult<List<Map>> result =noteService.loadBookNotes(bookId);
		return result;
	}

}
