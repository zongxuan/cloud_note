package com.stevezong.cloud_note.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stevezong.cloud_note.entity.Share;
import com.stevezong.cloud_note.service.ShareService;
import com.stevezong.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/share")
public class SearchSharesController {
	
	@Resource(name="shareService")
	private ShareService shareService;
	
	@RequestMapping("search.do")
	@ResponseBody
	private NoteResult<List<Share>> execute(@RequestParam("title")String title,@RequestParam("page")int page){
		NoteResult<List<Share>> result = new NoteResult<List<Share>>();
		result = shareService.searchShare(title,page);
		return result;
	}
	
}
