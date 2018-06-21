package com.stevezong.cloud_note.dao;

import java.util.List;
import java.util.Map;

import com.stevezong.cloud_note.entity.Note;

public interface NoteDao {
	List<Map> findByBookId(String bookId);
	Note findByNoteId(String noteId);
	Integer updateNote(Note note);
	Integer updateNoteByMap(Map<String,Object> map);
	void save(Note note);
	void delete(String noteId);
	/**
	 * map 中需要添加两个参数
	 * 	map={ids:[id1,id2....],status:2}
	 * ids代表被删掉笔记的ID列表
	 * status 代表被删除笔记的状态属性
	 * @param map
	 * @return
	 */
	int deleteNotes(Map<String,Object> map);
	
	
}
