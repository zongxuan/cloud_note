package com.stevezong.cloud_note.service;

import java.util.List;

import com.stevezong.cloud_note.entity.Share;
import com.stevezong.cloud_note.util.NoteResult;

public interface ShareService {
	NoteResult<Object> addShaer(String noteId,String title,String body);
	NoteResult<List<Share>> searchShare(String title,int page);
}
