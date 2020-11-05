package fr.library.dao;

import java.util.List;

import fr.library.beans.Author;

public interface AuthorDao {

	public void create(Author author);
	public List<Author> findAll();
	public Author findById(int id);
	public Author findByName(String name);
	public void update(Author author);
}
