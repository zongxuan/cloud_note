package com.stevezong.cloud_note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stevezong.cloud_note.service.ShareService;
import com.stevezong.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/share")
public class AddShareController {
	@Resource(name="shareService")
	private ShareService shareService;
	
	@RequestMapping("/add.do")
	@ResponseBody
	public NoteResult<Object> execute(String noteId,String title,String body){
		NoteResult<Object> result = new NoteResult<Object>();
		result = shareService.addShaer(noteId, title, body);
		return result;
	}
	
}
