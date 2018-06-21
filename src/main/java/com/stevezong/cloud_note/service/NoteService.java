package com.stevezong.cloud_note.service;

import java.util.List;
import java.util.Map;

import com.stevezong.cloud_note.entity.Note;
import com.stevezong.cloud_note.util.NoteResult;

public interface NoteService {
	NoteResult<List<Map>> loadBookNotes(String bookId);
	NoteResult<Note> loadNote(String noteId);
	void UpdateNoteService(Note note);
	Note createNote(Map<String,String> noteInfo);
	NoteResult<Object> updateNote(String noteId,String title,String body);
	void addNote(Note note);
	void deleteNote(String noteId);
	
}
