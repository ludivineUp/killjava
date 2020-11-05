package fr.library.controller;

import fr.library.beans.Book;
import fr.library.dao.DaoFactory;

public class BookController implements IController {

	private Book book;
	@Override
	public void okButton() throws Exception {
		// TODO Auto-generated method stub
		DaoFactory.getBookDao().create(book);
	}
	
	public void setBook(Book book){
		this.book = book;
	}

}
