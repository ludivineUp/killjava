package fr.library.dao;

import java.util.List;

import fr.library.beans.Editor;

public interface EditorDao {
	
	public void create(Editor editor);
	public List<Editor> findAll();
	public Editor findById(int id);
	public Editor findByName(String name);
	public void update(Editor editor);

}
