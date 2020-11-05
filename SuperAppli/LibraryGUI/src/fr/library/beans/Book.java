package fr.library.beans;

import java.io.Serializable;
import java.util.Date;

public class Book implements Serializable{

	private static final long serialVersionUID = -6360097004294544955L;
	
	private int id;
	private String title;
	private Editor editor;
	private Author author;
	private Date parution;
	
	public Book(){
		editor = new Editor();
		author = new Author();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Editor getEditor() {
		return editor;
	}

	public void setEditor(Editor editor) {
		this.editor = editor;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Date getParution() {
		return parution;
	}

	public void setParution(Date parution) {
		this.parution = parution;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", \n\t editor=" + editor
				+ ",\n\t author=" + author + ",\n\t parution=" + parution + "]";
	}
	
		
}
