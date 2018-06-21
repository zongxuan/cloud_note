package com.stevezong.cloud_note.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.stevezong.cloud_note.dao.ShareDao;
import com.stevezong.cloud_note.entity.Share;
import com.stevezong.cloud_note.util.NoteResult;
import com.stevezong.cloud_note.util.NoteUtil;

@Service("shareService")
public class ShareServiceImpl implements ShareService{

	@Resource(name="shareDao")
	private ShareDao  shareDao;
	
	
	public NoteResult<Object> addShaer(String noteId,String title,String body) {
		NoteResult<Object> result = new NoteResult<Object>();
		Share share = new Share();
		share.setCn_share_id(NoteUtil.createId());
		share.setCn_note_id(noteId);
		share.setCn_share_title(title);
		share.setCn_share_body(body);
		shareDao.add(share);
		/*String str =null;
		str.length();*/
		result.setStatus(0);
		result.setMsg("分享成功");
		return result;
	}


	public NoteResult<List<Share>> searchShare(String title,int page) {
		List<Share> shares = new ArrayList<Share>();
		NoteResult<List<Share>> result = new NoteResult<List<Share>>();
		title = "%"+title+"%";
		int begin = (page-1)*3;
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("title", title);
		params.put("begin", begin);
		shares = shareDao.findByTitle(params);
		//System.out.println(shares);
		if(shares.size() !=0) {
			result.setStatus(0);
			result.setMsg("查询成功");
			result.setData(shares);
		}else {
			result.setStatus(1);
			result.setMsg("没有");
		}
		return result;
	}

}
