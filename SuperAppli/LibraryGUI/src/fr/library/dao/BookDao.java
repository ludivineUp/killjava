package fr.library.dao;

import java.util.List;

import fr.library.beans.Book;

public interface BookDao {

	public void create(Book book);
	public List<Book> findAll();
	public Book findById(int id);
	public Book findByName(String name);
	public void update(Book book);
}
